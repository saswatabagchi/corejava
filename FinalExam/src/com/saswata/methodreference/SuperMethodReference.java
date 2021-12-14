package com.saswata.methodreference;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class SuperMethodReference extends Test {

	@Override
    String print(String s)
    {
  
        // call the super method
        // using double colon operator
        Function<String, String>
            func = super::print;
  
        String newValue = func.apply(s);
        newValue += "Bye " + s + "\n";
        System.out.println(newValue);
  
        return newValue;
    }
	// Driver code
    public static void main(String[] args)
    {
  
        List<String> list = new ArrayList<String>();
        list.add("Geeks");
        list.add("For");
        list.add("GEEKS");
  
        // call the instance method
        // using double colon operator
        list.forEach(new SuperMethodReference()::print);
    }
}

class Test {
	  
    // super function to be called
    String print(String str)
    {
        return ("Hello " + str + "\n");
    }
}
