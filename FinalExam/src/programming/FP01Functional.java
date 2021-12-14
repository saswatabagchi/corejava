
package programming;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FP01Functional { 
	
	public static void main(String[] args) {
		
        String word = "AAABBBeeEE";
        Integer int1 = 123445;
        Map<Integer, Long> charCount1;
        IntStream codePoints2 = word.codePoints();
        Stream<String> local = codePoints2.mapToObj(Character::toString);
         Map<String, Long> charCount = local
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
         System.out.println(charCount);
		
		
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		// printAllNumbersInListFunctional(numbers);
		//printEvenNumbersInListFunctional(numbers);
		printSquaresOfEvenNumbersInListFunctional(numbers);
	}

	// private static void print(int number) {
	// System.out.println(number);
	// }

	// private static boolean isEven(int number) {
	// return number%2 == 0;
	// }

	private static void printAllNumbersInListFunctional(List<Integer> numbers) {
		// What to do?
		numbers.stream().forEach(System.out::println);// Method Reference
	}

	// number -> number%2 == 0
	private static void printEvenNumbersInListFunctional(List<Integer> numbers) {
		// What to do?

		numbers.stream() // Convert to Stream
				.filter(number -> number % 2 == 0) // Lamdba Expression
				.forEach(System.out::println);// Method Reference

		// .filter(FP01Functional::isEven)//Filter - Only Allow Even Numbers
	}
	
	private static void printSquaresOfEvenNumbersInListFunctional(List<Integer> numbers) {
		numbers.stream() // Convert to Stream
				.filter(number -> number % 2 == 0) // Lamdba Expression
				//mapping - x -> x * x
				.map(number -> number * number)
				.forEach(System.out::println);// Method Reference

		// .filter(FP01Functional::isEven)//Filter - Only Allow Even Numbers
	}

}
