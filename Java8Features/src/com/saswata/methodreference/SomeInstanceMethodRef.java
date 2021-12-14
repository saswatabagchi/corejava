package com.saswata.methodreference;

import java.util.ArrayList;
import java.util.List; 

public class SomeInstanceMethodRef {
	
	 public static void main(String[] args) 
	    { 
	  
	        List<MethodRefClass> list = new ArrayList<MethodRefClass>(); 
	        list.add(new MethodRefClass("Geeks")); 
	        list.add(new MethodRefClass("For")); 
	        list.add(new MethodRefClass("GEEKS")); 
	  
	        // call the instance method 
	        // using double colon operator 
	        list.forEach( MethodRefClass::someFunction); 
	    } 
}

