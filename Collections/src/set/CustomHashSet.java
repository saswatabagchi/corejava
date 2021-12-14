package set;

import java.util.HashSet;

public class CustomHashSet {
	String empName;
	public CustomHashSet(String empName) {
	// TODO Auto-generated constructor stub
	this.empName = empName;
	}
	public String getEmpName() {
	return empName;
	}
	public void setEmpName(String empName) {
	this.empName = empName;
	}
	 
	public String toString(){
	return empName;
	}
	 
	public boolean equals(Object o){
	System.out.println("In equals " +"value is :" +this.empName);
	CustomHashSet employee = (CustomHashSet)o;
	if(employee.getEmpName().equals(this.empName)){
	return true;
	}
	return false;
	}
	 
	@Override
	public int hashCode() {
	System.out.println("In hashcode "+"value is :"+this.empName);
	int hash = 3;
	hash = 7 * hash + this.empName.hashCode();
	return hash;
	}
	public static void main(String[] args) {
		 //Custom Class Impl witout override equals and hascode
		 
		 HashSet<CustomHashSet> employees =  new HashSet<>();
		 employees.add(new CustomHashSet("learn"));
		 System.out.println("-----------------------");
		 employees.add(new CustomHashSet("learn"));
		 System.out.println("-----------------------");
		 employees.add(new CustomHashSet("from"));
		 System.out.println("-----------------------");
		 employees.add(new CustomHashSet("examples"));
		 System.out.println("-----------------------");
		 employees.add(new CustomHashSet("learn"));
		 System.out.println("-----------------------");
		 employees.add(new CustomHashSet("from"));
		 System.out.println("-----------------------");
		 employees.add(new CustomHashSet("from"));
		 System.out.println("-----------------------");
		 System.out.println(employees);
		 
		 }
}
