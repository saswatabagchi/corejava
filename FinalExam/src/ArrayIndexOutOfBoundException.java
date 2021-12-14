
public class ArrayIndexOutOfBoundException {
	
	public static void main(String[] args) throws ArrayIndexOutOfBoundsException
    {
        int ar[] = {1, 2, 3, 4, 5};
        for (int i=0; i<=ar.length; i++)
       try { 	
          System.out.println(ar[i]);
       }catch(Exception e ){
    	   System.out.println("Index out of bount exception "+ e.getMessage());
       }
    }

}
