import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CovertArraytoList {
	public static void main(String[] args) {

		String[] geeks = { "Rahul", "Utkarsh", "Shubham", "Neelam" };

		// Conversion of array to ArrayList
		// using Arrays.asList
		List al = Arrays.asList(geeks);
		System.out.println(al);

		// Adding some more values to the List.
		al.add("Shashank");
		al.add("Nishant");

		System.out.println(al);
		String[] geeks1 = { "Rahul", "Utkarsh", "Shubham", "Neelam" };

		List<String> al1 = new ArrayList<String>(Arrays.asList(geeks1));
		System.out.println(al);

// Adding some more values to the List.
		al.add("Shashank");
		al.add("Nishant");

		System.out.println("\nArrayList After adding two" + " more Geeks: ");
		System.out.println(al1);

		String[] geeks2 = { "Rahul", "Utkarsh", "Shubham", "Neelam" };

		List<String> al2 = new ArrayList<String>();

// adding elements of array to arrayList.
		Collections.addAll(al2, geeks);

		System.out.println(al2);
		String[] geeks3 = { "Rahul", "Utkarsh", "Shubham", "Neelam" };

		List<String> al3 = new ArrayList<String>();
		Collections.addAll(null, geeks);

		System.out.println(al3);

	}
}
