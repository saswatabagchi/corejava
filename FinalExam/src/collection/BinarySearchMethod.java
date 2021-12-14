
package collection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BinarySearchMethod {

	public static void main(String[] args) {
		 List<Integer> al = new ArrayList<Integer>();
	        al.add(100);
	        al.add(50);
	        al.add(30);
	        al.add(10);
	        al.add(2);
	 
	        // The last parameter specifies the comparator
	        // method used for sorting.
	        int index = Collections.binarySearch(
	            al, 50, Collections.reverseOrder());
	 
	        System.out.println("Found at index " + index);
	        
	     // Create a list
	        List<Domain> l = new ArrayList<Domain>();
	        l.add(new Domain(10, "quiz.geeksforgeeks.org"));
	        l.add(new Domain(20, "practice.geeksforgeeks.org"));
	        l.add(new Domain(30, "code.geeksforgeeks.org"));
	        l.add(new Domain(40, "www.geeksforgeeks.org"));
	 
	        Comparator<Domain> c = new Comparator<Domain>() {
	            public int compare(Domain u1, Domain u2)
	            {
	                return u1.getId().compareTo(u2.getId());
	            }
	        };
	 
	        // Searching a domain with key value 10. To search
	        // we create an object of domain with key 10.
	        int index1 = Collections.binarySearch(
	            l, new Domain(10, null), c);
	        System.out.println("Found at index  " + index1);
	 
	        // Searching an item with key 5
	        index1 = Collections.binarySearch(
	            l, new Domain(5, null), c);
	        System.out.println(index1);

	}

}

class Domain {
    private int id;
    private String url;
 
    // Constructor
    public Domain(int id, String url)
    {
        this.id = id;
        this.url = url;
    }
 
    public Integer getId() { return Integer.valueOf(id); }
}
