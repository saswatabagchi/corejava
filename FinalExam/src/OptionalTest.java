import java.util.Optional;

public class OptionalTest {
	public static void main(String []args){
        String s  = null ;
        Optional<String> a = Optional.ofNullable(s);
        if (s == null)
        	System.out.println("null");
        if(a.isPresent()){  // check for value is present or not  
            String lowercaseString = s.toLowerCase();  
            System.out.print(lowercaseString);  
        }else  
            System.out.println("string value is not present");  
    }  
}
