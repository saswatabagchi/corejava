package com.assignment.simplejosn;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class DocReadingProgram {

	public static void main(String[] args) throws IOException {
		String dbURL = "jdbc:mysql://sql354.main-hosting.eu:3306/resurse";
		String username = "u195589955_root";
		String password = "Test1234";
		try {
			 
		    Connection conn = DriverManager.getConnection(dbURL, username, password);
		 
		    if (conn != null) {
		        System.out.println("Connected");
		    }
		} catch (SQLException ex) {
		    ex.printStackTrace();
		}

		String fileName = "D:\\Users\\DELL\\Desktop\\java_tutorial\\knowledge_base_phase_2.docx";
		FileWriter fw=new FileWriter("C:\\\\Users\\\\Dell\\\\Desktop\\\\saswata_bagchi_doc\\testout_7.sql");    
        try (XWPFDocument doc = new XWPFDocument(
                Files.newInputStream(Paths.get(fileName)))) {

            XWPFWordExtractor xwpfWordExtractor = new XWPFWordExtractor(doc);
            String docText = xwpfWordExtractor.getText();
            //System.out.println(docText);
            
            List<XWPFParagraph> list = doc.getParagraphs();
            for (XWPFParagraph paragraph : list) {
            	if ( !paragraph.getText().matches("^[a-zA-Z]*$")) {          		
            	    List<String> extractUrls = extractUrls(paragraph.getText()).stream().filter(value -> value != null).collect(Collectors.toList());
            		if (extractUrls.size() != 0) {
            		fw.write("INSERT INTO `bookmark` ( `bookmark`, `url`) VALUES " + "( '" +extractUrls.get(0).toString().substring(8)+"' , '"+extractUrls.get(0).toString() + "') ;");
            		fw.write("\n");
            		
            		try {
            			   Document doc1 = Jsoup.connect(extractUrls.get(0).toString()).get();
            			   Element firstArticle = doc1.select("[title]").first();
            			   String sectionDivText = firstArticle.text();
            			   System.out.println("Titel is :"+doc1.title());
            			} catch (HttpStatusException ex) {
            			   System.out.println("Exception happened "+ ex.getMessage() + " UrL "+ extractUrls.get(0).toString());
            			} catch (Exception ex ) {
            				System.out.println("Un Known Exception happened "+ ex.getMessage() + " UrL "+ extractUrls.get(0).toString() );	
            			}
            		
            		
            		CloseableHttpClient httpClient = HttpClients.createDefault();
            		HttpGet request = new HttpGet(extractUrls.get(0).toString());
//            		try {
//            		//CloseableHttpResponse response = httpClient.execute(request);
//            		//HttpEntity entity = response.getEntity();
//                    //Header headers = entity.getContentType();
//                    //System.out.println(headers);
//
//                    
//            	    System.out.println(response.getStatusLine().toString() + "Url" + extractUrls.get(0).toString());
//            		} catch (Exception e) {
//            			System.out.println("exception"+ e.getMessage());
//            		}
            		
            		}
            		//System.out.println(extractUrls("Url Only "+ paragraph.getText()));
            		//System.out.println("paragragh " + paragraph.getText() +" index no " + list.indexOf(paragraph));
				}
                
            }
            
            // find number of words in the document
            long finalCont = list.stream().count();
            long count = Arrays.stream(docText.split("\\s+")).count();
            System.out.println("Total words: " + count);
            fw.close();    
            System.out.println("final word count : " + finalCont); 

        }
	}
	
	public static List<String> extractUrls(String text)
    {
        List<String> containedUrls = new ArrayList<String>();
        String urlRegex = "((https?|ftp|gopher|telnet|file):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)";
        Pattern pattern = Pattern.compile(urlRegex, Pattern.CASE_INSENSITIVE);
        Matcher urlMatcher = pattern.matcher(text);

        while (urlMatcher.find())
        {
            containedUrls.add(text.substring(urlMatcher.start(0),
                    urlMatcher.end(0)));
        }

        return containedUrls;
    }

}
