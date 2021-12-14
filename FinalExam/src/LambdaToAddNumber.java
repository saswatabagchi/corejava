interface SumFunc {
   int func(int a, int b);
}
public class LambdaToAddNumber {
	
	public static void main(String args[]) {
		SumFunc sum = (a,b) -> ( a+b );
		System.out.println("Lambda reversed is: " + sum.func(1,2));	
		
	}

}
