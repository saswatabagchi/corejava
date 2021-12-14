package com.saswata.methodreference;

public class MethodRefClass {
	
	String str=null;
    
    public MethodRefClass(String s) {
    	this.str=s;
	}
	// instance function to be called 
    void someFunction() 
    { 
        System.out.println(this.str); 
    } 

}
