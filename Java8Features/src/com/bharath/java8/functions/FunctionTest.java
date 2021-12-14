package com.bharath.java8.functions;

import java.util.function.Function;

public class FunctionTest {

	public static void main(String[] args) {
		
		
		//input/output
		Function<String,Integer> f = s->s.length();
		System.out.println(f.apply("Bharath"));
		System.out.println(f.apply("John"));
		 // Function which takes in a number and
        // returns half of it
		
		Function<Integer, Integer> times2 = e -> e * 2;

		Function<Integer, Integer> squared = e -> e * e;  
		
		System.out.println(times2.compose(squared).apply(4));
		System.out.println(times2.andThen(squared).apply(4));
        
        // Function which takes in a number and
        // returns half of it
		//While the compose function executes the caller last and the parameter first, the andThen executes the caller first and the parameter last.
  
        Function<Integer, Double> half1 = a -> a / 2.0;
  
        try {
  
            // try to pass null as parameter
             half1.andThen(null);
        }
        catch (Exception e) {
            System.out.println("Exception thrown "
                               + "while passing null: " + e);
        }
        
        
    }
	

}
