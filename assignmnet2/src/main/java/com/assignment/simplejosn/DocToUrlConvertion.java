package com.assignment.simplejosn;



import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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

public class DocToUrlConvertion {

	public static void main(String[] args) throws IOException {
		String dbURL = "jdbc:mysql://sql354.main-hosting.eu:3306/u195589955_resurse";
		String username = "u195589955_root";
		String password = "Test1234";
		
        int count = 0;
        int excount = 0;
		String fileName = "D:\\Users\\DELL\\Desktop\\java_tutorial\\knowledge_base.docx";
		FileWriter fw=new FileWriter("C:\\\\Users\\\\Dell\\\\Desktop\\\\saswata_bagchi_doc\\testout_9.sql");
		FileWriter fw1=new FileWriter("C:\\\\Users\\\\Dell\\\\Desktop\\\\saswata_bagchi_doc\\exception_9.txt");
		//fw.write("bookmark $ url");
		//fw.write("\n");
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
            			
            		    
            		try {
            			   
            			   Document doc1 = Jsoup.connect(extractUrls.get(0).toString()).userAgent("Mozilla").get();
            			   
            			   if (doc1.title().trim().length() > 0)
            			   {
            				   //fw.write(doc1.title()+" $ "+extractUrls.get(0).toString());
            				   //fw.write("INSERT INTO `bookmark` ( `bookmark`, `url`) VALUES " + "( '" +doc1.title()+"' , '"+extractUrls.get(0).toString() + "') ;");
                       		   //fw.write("\n");
                       		   
                       		try(Connection conn = DriverManager.getConnection(dbURL, username, password);
                       	         Statement stmt = conn.createStatement();
                       	      ) {		      
                       	         // Execute a query
                       	                  
                       	         String sql = "INSERT INTO `bookmark` ( `bookmark`, `url`) VALUES " + "( '" +doc1.title()+"' , '"+extractUrls.get(0).toString() + "') ;";
                       	         stmt.executeUpdate(sql);
                       	      System.out.println("Link inserted : "+doc1.title()); 
                       	      count ++ ;
                       	      } catch (SQLException e) {
                       	    	System.out.println("SQl Exception is : "+ e.getMessage());
                       	    	fw1.write(" SQL Exception : " + e.getMessage() + "  [ " +extractUrls.get(0).toString() +" ] " );
                				fw1.write("\n");
                				excount ++ ;
                       	      }  
                			    
            			   }else {
            				   fw1.write("Title Exception Happened   |"+ extractUrls.get(0).toString());
                			   fw1.write("\n");
                			   excount ++ ;
            			   }
            			   
            			} catch (HttpStatusException ex) {
            			   System.out.println("Exception happened "+ ex.getMessage() + " UrL "+ extractUrls.get(0).toString());
            			   fw1.write("HTTP Exception happened        |"+extractUrls.get(0).toString());
            			   fw1.write("\n");
            			   excount ++ ;
            			} catch (Exception ex ) {
            				System.out.println("Un Known Exception happened "+ ex.getMessage() + " UrL "+ extractUrls.get(0).toString() );	
            				fw1.write("Un Known Exception happened   |"+ extractUrls.get(0).toString());
            				fw1.write("\n");
            				excount ++ ;
            			}
            		
            		
            		
            		
            		}
            		
				}
                
            }
            
            // find number of words in the document
            
            
            System.out.println("link inserted  " + count);
            System.out.println("Exception happened   " + excount);
            fw.close();  
            fw1.close();
           
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



