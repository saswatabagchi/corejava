import java.util.Comparator;

public class Mycomparetor implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		String s1 = (String ) o1;
		String s2 = (String ) o2;
		// TODO Auto-generated method stub
		return s2.substring(0, 0).compareTo(s1.substring(0, 0));
	}

}
