import java.util.List;

public class LamdaToPrint {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		printAllNumbersInListFunctional(numbers);
	}
	
	private static void printAllNumbersInListFunctional(List<Integer> numbers) {
		// What to do?
		numbers.stream().forEach(System.out::println);// Method Reference
		numbers.stream().forEach(s -> System.out.println(s));
	}

}
