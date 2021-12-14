import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WithDeliminetor {

	public static void main(String[] args) {
		// Create a character list
        List<String> str = Arrays.asList("Geeks", "for", "Geeks");
  
        // Convert the character list into String
        // using Collectors.joining() method
        String chString = str.stream()
                              .map(String::valueOf)
                              .collect(Collectors.joining(", "));
  
        // Print the concatenated String
        System.out.println(chString);
        
     // Create a character list
        List<Character> ch = Arrays.asList('G', 'e', 'e', 'k', 's',
                                           'f', 'o', 'r',
                                           'G', 'e', 'e', 'k', 's');
  
        // Convert the character list into String
        // using Collectors.joining() method
        // with, as the delimiter
        String chString1 = ch.stream()
                              .map(String::valueOf)
                              .collect(Collectors.joining(", "));
  
        // Print the concatenated String
        System.out.println(chString1);
        
     // Create a character list
        List<String> str1 = Arrays.asList("Geeks", "for", "Geeks");
  
        // Convert the character list into String
        // using Collectors.joining() method
        String chString2 = str1.stream()
                              .map(String::valueOf)
                              .collect(Collectors.joining(", "));
  
        // Print the concatenated String
        System.out.println(chString2);
        
     // Create a character list
        List<Character> ch2 = Arrays.asList('G', 'e', 'e', 'k', 's',
                                           'f', 'o', 'r',
                                           'G', 'e', 'e', 'k', 's');
  
        // Convert the character list into String
        // using Collectors.joining() method
        // with, as the delimiter
        String chString3 = ch2.stream()
                              .map(String::valueOf)
                              .collect(Collectors.joining(", ", "[", "]"));
  
        // Print the concatenated String
        System.out.println(chString3);
        
     // Create a character list
        List<String> str5 = Arrays.asList("Geeks", "for", "Geeks");
  
        // Convert the character list into String
        // using Collectors.joining() method
        String chString5 = str5.stream()
                              .map(String::valueOf)
                              .collect(Collectors.joining(", ", "{", "}"));
  
        // Print the concatenated String
        System.out.println(chString5);

	}

}
