package com.saswata.methodreference;

import java.util.ArrayList;
import java.util.List;

public class ConstructorReference {
	public ConstructorReference(String s)
    {
        System.out.println("Hello " + s);
    }
	
	public ConstructorReference() {
		
	}
  
    // Driver code
	//(ClassName::new)
    public static void main(String[] args)
    {
  
        List<String> list = new ArrayList<String>();
        list.add("Geeks");
        list.add("For");
        list.add("GEEKS");
  
        // call the class constructor
        // using double colon operator
        list.forEach(ConstructorReference::new);
        list.forEach(l -> new ConstructorReference(l));
    }
}
