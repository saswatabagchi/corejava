import java.util.ArrayList;

public class ArrayListToArray {
	
	 public static void main(String[] args) {
	        ArrayList<String> course = new ArrayList<String>();
	        course.add("Java");
	        course.add("Spring");
	        course.add("Hibernate");
	        course.add("Angular");
	        course.add("PHP");
	        Object[] courseArray = course.toArray(new String[course.size()]);
	        System.out.println("courseArray.length = " + courseArray.length);

	    }

}
