
public class CustomCheckedException {
  
	public static int AmountAdder (int a, int b) throws Exception {
		
		if (a==b) {
			throw new Exception("Currencies don't match");
			}
			return a +b;
	}


	
	
}