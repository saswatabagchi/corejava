import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortAStringList {
	
	
	public static void main(String[] args) {
	
	List<String> names = Arrays.asList("Alex", "Xaarles", "Brian", "David");  
	names.sort( Comparator.comparing( String::toString ) ); 
	System.out.println(names);
	Collections.sort(names, new Mycomparetor());
	System.out.println(names);
	List<String> sortedList = names.stream()
			.sorted((o1,o2)-> o2.length()-(o1.length()))
			.collect(Collectors.toList());
	System.out.println(sortedList);
	}
}
