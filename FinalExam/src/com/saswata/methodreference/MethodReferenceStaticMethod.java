package com.saswata.methodreference;

import java.util.ArrayList;
import java.util.List;

public class MethodReferenceStaticMethod {

//	//When and how to use double colon operator?
//
//			Method reference or double colon operator can be used to refer:
//
//			a static method,
//			an instance method, or
//			a constructor. SomeClass::someStaticMethod
	
	static void someFunction(String s)
    {
        System.out.println(s);
    }
	
	public static void main(String[] args)
    {
  
        List<String> list = new ArrayList<String>();
        list.add("Geeks");
        list.add("For");
        list.add("GEEKS");
  
        // call the static method
        // using double colon operator
        list.forEach(MethodReferenceStaticMethod::someFunction);
    }
	
	
	
}
