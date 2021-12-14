import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StrinArrayToString {

	public static void main(String[] args) {
		List<String> str = Arrays.asList("Geeks", "for", "Geeks");

		// Convert the character list into String
		// using Collectors.joining() method
		String chString = str.stream().map(String::valueOf).collect(Collectors.joining());

		// Print the concatenated String
		System.out.println(chString);
	}

}
