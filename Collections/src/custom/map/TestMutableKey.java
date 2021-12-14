package custom.map;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class TestMutableKey
{
    public static void main(String[] args)
    {
        //Create a HashMap with mutable key
       HashMap<Account, String> map = new LinkedHashMap<Account, String>();
          
        //Create key 1
       
        Account a1 = new Account(1);
        a1.setHolderName("A_ONE");
        //Create key 2
       
        Account a2 = new Account(2);
        a2.setHolderName("A_TWO");
          
        //Put mutable key and value in map
        System.out.println("map put is created + "+1);
        map.put(a1, a1.getHolderName());
        System.out.println("map put is created + "+2);
        map.put(a2, a2.getHolderName());
          
        //Change the keys state so hash map should be calculated again
        System.out.println("map update + "+1);
        a1.setHolderName("Defaulter");
        map.put(a1, a1.getHolderName());
        System.out.println("map update + "+2);
        a2.setHolderName("Bankrupt");
        map.put(a2, a2.getHolderName());
        
        //Success !! We are able to get back the values
        System.out.println("map fetch for + "+1);
        System.out.println("a1 hash code"+a1.hashCode()); 
        System.out.println(map.get(a1)); //Prints A_ONE
        System.out.println("map fetch for + "+2);
        System.out.println("a2 hash code"+a2.hashCode()); 
        System.out.println(map.get(a2)); //Prints A_TWO
          
        //Try with newly created key with same account number
        Account a3 = new Account(1);
        a3.setHolderName("A_THREE");
        System.out.println("a3 hash code"+a3.hashCode()); 
        map.put(a3, a3.getHolderName());  
        
        //Success !! We are still able to get back the value for account number 1
        System.out.println(map.size()); 
        System.out.println(map.get(a3)); //Prints A_ONE
    }
}
