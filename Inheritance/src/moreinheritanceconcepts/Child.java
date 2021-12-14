package moreinheritanceconcepts;

public class Child extends Parent {
	
	 public  int c = 20;
	 public  int d = 50;
	 public  int e = 12;
	 public  int f = 23;
	 int x;
	 int y;
	 
	 public void dispalyFromParent( String str )
		{
			System.out.println("String from Chield" + str );
		}
	 

	   void m1() {
	      x = y - 1;	 
	      System.out.println(y+ " " +x);
	      System.out.println(y+ " " +super.x);
	      super.x = super.x + 1;	 
	      System.out.println(super.x+ " " +y);
	 }
}
