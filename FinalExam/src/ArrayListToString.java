import java.util.ArrayList;

public class ArrayListToString {
	
	 

	 public static void main(String[] args) {  
         ArrayList<String> l= new ArrayList<String>();//ArrayList implementation  
         l.add("Hello");  
         l.add("Java");  
         l.add("Tpoint");  
         String frnames[]=l.toArray(new String[l.size()]);//ArrayList to String Array Conversion  
         for(String j: frnames) /// To display Array elements  
         {  
             System.out.println(j); // Printing Elements  
         }  
     }  
}
