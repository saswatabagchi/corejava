package GmailAPiLib;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.swing.text.Document;
import javax.swing.text.rtf.RTFEditorKit;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.GmailScopes;
import com.google.api.services.gmail.model.Label;
import com.google.api.services.gmail.model.ListLabelsResponse;
import com.google.api.services.gmail.model.ListMessagesResponse;
import com.google.api.services.gmail.model.Message;
import com.google.api.services.gmail.model.Thread;


import io.restassured.path.json.JsonPath;

/**
 * Date: May 31st, 2020
 * @author NaveenKhunteta
 *
 */
public class GMail {
    private static final String APPLICATION_NAME = "Desktop client 1";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String USER_ID = "me";
    /**
     * Global instance of the scopes required by this quickstart.
     * If modifying these scopes, delete your previously saved tokens/ folder.
     */
    private static final List<String> SCOPES = Collections.singletonList(GmailScopes.MAIL_GOOGLE_COM);
    private static final String CREDENTIALS_FILE_PATH =  
    		System.getProperty("user.dir") +
             File.separator + "src" +
             File.separator + "main" +
             File.separator + "resources" +
             File.separator + "credentials" +
             File.separator + "credentials_new.json";
    
    private static final String TOKENS_DIRECTORY_PATH = System.getProperty("user.dir") +
            File.separator + "src" +
            File.separator + "main" +
            File.separator + "resources" +
            File.separator + "credentials";
    /**
     * Creates an authorized Credential object.
     * @param HTTP_TRANSPORT The network HTTP Transport.
     * @return An authorized Credential object.
     * @throws IOException If the credentials.json file cannot be found.
     */
    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
        // Load client secrets.
        InputStream in = new FileInputStream(new File(CREDENTIALS_FILE_PATH));
        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
        }
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(9999).build();
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }
    
    
    public static Gmail getService() throws IOException, GeneralSecurityException {
        // Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        Gmail service = new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();
        return service;
    }
    public static List<Message> listMessagesMatchingQuery(Gmail service, String userId,
                                                          String query) throws IOException {
        ListMessagesResponse response = service.users().messages().list(userId).setQ(query).execute();
        List<Message> messages = new ArrayList<Message>();
        while (response.getMessages() != null) {
            messages.addAll(response.getMessages());
            if (response.getNextPageToken() != null) {
                String pageToken = response.getNextPageToken();
                response = service.users().messages().list(userId).setQ(query)
                        .setPageToken(pageToken).execute();
            } else {
                break;
            }
        }
        return messages;
    }
    public static Message getMessage(Gmail service, String userId, List<Message> messages, int index)
            throws IOException {
    	if (!(messages.get(index)== null)) {
        Message message = service.users().messages().get(userId, messages.get(index).getId()).execute();
        return message;
    	}
        return null;
    }
    public static String getMessageText(JsonPath jp)
    {
    	String body;
    	try {
    	 body = new String(Base64.getUrlDecoder().decode(jp.getString("payload.parts[0].body.data")));
    		return body;
    	}
    	catch (Exception e){
    		return "null";
    	}
    	
        
    }
    public static HashMap<String, String> getGmailData(String query) {
    	HashMap<String, String> hm = new HashMap<String, String>();
        try {
            Gmail service = getService();
            ListLabelsResponse listResponse = service.users().labels().list(USER_ID).execute();
            List<Label> labels = listResponse.getLabels();
            if (labels.isEmpty()) {
                System.out.println("No labels found.");
            } else {
                System.out.println("Labels:");
                for (Label label : labels) {
                    System.out.printf("- %s\n", label.getName());
                }
            }   
            List<Message> messages = listMessagesMatchingQuery(service, USER_ID, query);
            Message message = getMessage(service, USER_ID, messages, 0);
            System.out.println("message" + message.toString());
            JsonPath jp = new JsonPath(message.toString());
            String subject = jp.getString("payload.headers.find { it.name == 'Subject' }.value");
            String body = new String(Base64.getDecoder().decode(jp.getString("payload.parts[0].body.data")));
            String link = null;
            String arr[] = body.split("\n");
            for(String s: arr) {
                s = s.trim();
                if(s.startsWith("http") || s.startsWith("https")) {
                    link = s.trim();
                }
            }
            
            hm.put("subject", subject);
            hm.put("body", body);
            hm.put("link", link);
            return hm;
        } catch (Exception e) {
        	
        		System.out.println("email not found...."+ e.getMessage());
            //throw new RuntimeException(e);
        		hm.put(null,null);
        		return hm;
        }
        
    }
    
    public static int getTotalCountOfMails() {
        int size;
        try {
            final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            Gmail service = new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                    .setApplicationName(APPLICATION_NAME)
                    .build();
            List<Thread> threads = service.
                    users().
                    threads().
                    list("me").
                    execute().
                    getThreads();
             size = threads.size();
        } catch (Exception e) {
            System.out.println("Exception log " + e);
            size = -1;
        }
        return size;
    }
    
    public static boolean isMailExist(String messageTitle) throws IOException, GeneralSecurityException {
    	FileWriter fw1=new FileWriter("C:\\\\Users\\\\Dell\\\\Desktop\\\\saswata_bagchi_doc\\mail_1.txt");
    	final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        Gmail service = new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();
    	List<Message> messages = null;
    	int i = 5;
        try {
            
            ListMessagesResponse response = service.
                    users().
                    messages().
                    list("me").
                    //setQ("subject:" + messageTitle).
                    setQ(messageTitle).
                    execute();
            messages = getMessages(response);
            System.out.println("Numner of mail "+ messages.size());
            
            
        } catch (Exception e) {
            System.out.println("Exception log" + e);
            fw1.write("Exception log " + e.getClass() + " at count " + i);
            
        }
        for(; i < messages.size(); i++) {
        	Message message = getMessage(service, USER_ID, messages, i);
        	JsonPath jp = new JsonPath(message.toString());        	
            String subject = jp.getString("payload.headers.find { it.name == 'Subject' }.value");
           
                if ((!(subject==null))) {        	
                fw1.write("No " + i +"Subject of mail is "+ subject);
                fw1.write("\n");
                fw1.write("==================================================");
                fw1.write("\n");
                //String body = new String(Base64.getUrlDecoder().decode(jp.getString("payload.parts[0].body.data")));
                fw1.write(getMessageText(jp));
       			fw1.write("\n");
       			fw1.write("=================end===============================");
       			fw1.write("\n");
                } 
            }
           
         
        
        
        	return messages.size() != 0;
        
        
    }
        
        private static List<Message> getMessages(ListMessagesResponse response) throws IOException {
            List<Message> messages = new ArrayList<Message>();
            
            int i = 100;
           
            try {
                final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
                Gmail service = new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                        .setApplicationName(APPLICATION_NAME)
                        .build();
                while (response.getMessages() != null) {
                	//messages = null;
                    messages.addAll(response.getMessages());
//                    Message message = getMessage(service, USER_ID, messages, i);
//                    System.out.println("Length of the bodyis 1:");
                    //System.out.println("message" + message.toString());
//                    JsonPath jp = new JsonPath(message.toString());
//                    String subject = jp.getString("payload.headers.find { it.name == 'Subject' }.value");
             

//                    ObjectMapper mapper = new ObjectMapper();
//                     Payload obj = mapper.readValue(message.toString(), Payload.class);
//                    List<Part> parts = obj.getPayload().getParts();
//                    for (Part  part : parts) {
//                    	byte[] decodedBytes = Base64.getDecoder().decode(part.getBody().getData());
//                    	String decodedString = new String(decodedBytes);
//                    	RTFEditorKit rtfParser = new RTFEditorKit();
//                    	Document document = rtfParser.createDefaultDocument();                 	
//                    	rtfParser.read(new ByteArrayInputStream(jp.getString("payload.parts[0].body.data").getBytes()), document, 0);
//                    	String decodedString = document.getText(0, document.getLength());
//                        System.out.printf("- %s\n",  Base64.getDecoder().decode(jp.getString("payload.parts[0].body.data")));
//                    }
//                    if (! (jp.getString("payload.parts[0].body.data") == null)
//                    		)
//                    {
//                      System.out.println("Count of mail is : "+ i);
//                      fw1.write("start of mail no "+ i);
//                      fw1.write("\n");
//                      fw1.write("==================================================");
//                      fw1.write("\n");
//                      String body = new String(Base64.getUrlDecoder().decode(jp.getString("payload.parts[0].body.data")));
////                    Decoder decoder = Base64.getDecoder();
////                    byte[] bytes = decoder.decode(jp.getString("payload.parts[0].body.data"));
//                      fw1.write(body);
//      				  fw1.write("\n");
//      				  fw1.write("=================end===============================");
//      				  fw1.write("\n");
//                      //System.out.println( body);
//                     
//                    }
////                    String link = null;
////                    String arr[] = body.split("\n");
////                    for(String s: arr) {
////                        s = s.trim();
////                        if(s.startsWith("http") || s.startsWith("https")) {
////                            link = s.trim();
////                           
////                        }
////                    }
                   //System.out.println("mail deatisl is :" + subject );
                    if (response.getNextPageToken() != null) {
                        String pageToken = response.getNextPageToken();
                        
                        response = service.users().messages().list(USER_ID)
                                .setPageToken(pageToken).execute();
                        
                        i++;
                    } else {
                        break;
                    }
                }
               
                return messages;
            } catch (Exception e) {
                System.out.println("Exception log " + e.getClass() + " at count " + i);
//                fw1.write("Exception log " + e.getClass() + " at count " + i);
                return messages;
            }
            finally {
            	System.out.println("the total number of mails"+i);
            }
        }
    
    
    public static void main(String[] args) throws IOException, GeneralSecurityException {
//        HashMap<String, String> hm = getGmailData("subject:Notification from Axis Bank");
//        System.out.println(hm.get("subject"));
//        System.out.println("=================");
//        System.out.println(hm.get("body"));
//        System.out.println("=================");
//        System.out.println(hm.get("link"));
//        
//        System.out.println("=================");
//        System.out.println("Total count of emails is :"+getTotalCountOfMails());
        
        System.out.println("=================");
        boolean exist = isMailExist("@naukri.com");
        System.out.println("title exist or not: " + exist);


    }
}