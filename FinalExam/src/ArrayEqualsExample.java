import java.util.Arrays;

public class ArrayEqualsExample {

	public static void main(String[] args) {
		String[] inarray1 = new String[] {"mango", "grapes", "plum", "watermelon", "apple"};   
		String[] inarray2 = new String[] {"mango", "grapes", "plum", "apple",  "watermelon"}; 
		Object[] array1 = {inarray1};  // array1 have only one element   
		Object[] array2 = {inarray2};  // array2 also have only one element   
		//comparing two arrays using equals() method  
		if (Arrays.deepEquals(array1, array2))   
		System.out.println("Arrays are equal.");   
		else  
		System.out.println("Arrays are not equal."); 
		
		//defining arrays to compare   
		int[] array11 = new int [] {21, 32, 36, 47};   
		int[] array21 = new int [] {11, 22, 33, 44};   
		int[] array3 = new int [] {21, 32, 36, 47};   
		System.out.println("Are array1 and array2 equal?" + Arrays.equals(array11, array21));   
		System.out.println("Are array1 and array3 equal?" + Arrays.equals(array11, array3));   

	}

}
