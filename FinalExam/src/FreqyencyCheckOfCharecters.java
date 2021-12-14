import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FreqyencyCheckOfCharecters {
	
	public static void main(String[] args) {
		String word = "AAABBBeeEE";
		IntStream codePoints2 = word.codePoints();
		Stream<String> local = codePoints2.mapToObj(Character::toString);
		Map<String, Long> charCount = local
		        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(charCount);
		
	}

}
