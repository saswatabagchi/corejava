package moreinheritanceconcepts;

public class Parent {
	
	public int c =10 ;
	public final int e =40;
	private  int f =41;
	int g =45;
	int x;
	int y;

	
	public void dispalyFromParent( String str )
	{
		System.out.println("String from Parent" + str );
	}
	
	void m1(){
		  System.out.println(x);	  
		 }
}
