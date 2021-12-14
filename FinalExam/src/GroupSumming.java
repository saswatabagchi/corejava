import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;



class Employee {
 private int id;
 private int deptId;
 private String name;
 private int salary;

 public Employee(int id, int deptId, String name, int salary) {
  super();
  this.id = id;
  this.deptId = deptId;
  this.name = name;
  this.salary = salary;
 }
 public int getId() {
  return id;
 }
 public String getName() {
  return name;
 }
 public int getSalary() {
  return salary;
 }
 public int getDeptId() {
  return deptId;
 }

}

public class GroupSumming {

	
	public static void main(String[] args) {
		  List < Employee > employees = Arrays.asList(new Employee(1, 1000, "Chandra Shekhar", 6000),
		   new Employee(1, 1000, "Rajesh", 8000),
		   new Employee(1, 1004, "Rahul", 9000),
		   new Employee(1, 1001, "Suresh", 12000),
		   new Employee(1, 1004, "Satosh", 8500)
		  );

		  Map<Integer, Integer> collect15 = employees.stream()
					.collect(Collectors.groupingBy(Employee::getDeptId, Collectors.summingInt(Employee::getSalary)));
				 System.out.println("Total Employees Salary of 1000 Dept :   " +
						 collect15.get(1000));
				 System.out.println("Total Employees Salary : " + collect15.values().stream().reduce(0, Integer::sum));
		 }

}
