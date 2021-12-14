
public class CustomUnchekedException {


public static int AmountAdder1 (int a, int b)  {
		
		if (a==b) {
			throw new RuntimeException("Currencies don't match");
			}
			return a +b;
	}

}
