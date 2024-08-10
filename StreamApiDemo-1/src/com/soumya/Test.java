package com.soumya;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

class Comparison{
	
	public int compare(Employee e1,Employee e2) {
		
		return e1.getSalary().compareTo(e2.getSalary());
	}
}

public class Test {

	public static void main(String[] args) {
		
		List<Employee> employees = List.of(
				      
				    new Employee("aa", "Dev", 32000.00),
				    new Employee("bb", "Sales", 36000.00),
				    new Employee("cc", "Dev", 28000.00),
				    new Employee("dd", "Mrkt", 33000.00),
				    new Employee("ee", "Sales", 39000.00),
				    new Employee("ff", "Dev", 45000.00),
				    new Employee("gg", "Testing", 35000.00)

				
				);
				
		Map<String, Optional<Employee>> resultSet = employees.stream().
		          collect(
		        		    Collectors.groupingBy(
		        		    		     emp -> emp.getDepartmentName(),
		        		    		     Collectors.minBy(
		        		    		    		     (e1,e2) -> e1.getSalary().compareTo(e2.getSalary())
		        		    		    		 )
		        		    		     
		        		    		  
		        		    		)
		        		  
		        		 
		        		  );
		
		
		
		 Map<String,Long> noOfEmployeesdepartmentwise= employees.stream().collect(
				 
				       Collectors.groupingBy(
				    		   
				    		      e -> e.getDepartmentName(),
				    		      Collectors.counting()
				    		      )
				 
				 );
		 
		 noOfEmployeesdepartmentwise.forEach((d,count) -> System.out.println(d+" -> "+count));
		 
		 System.out.println("-----------------------------");
		 
		 
		
		  Optional<Employee> employeeWithHighestSalary = employees.stream().max(new Comparison()::compare);
		  
		  System.out.println("Employee with Highest Salary -> "+employeeWithHighestSalary.get().getEmployeeName());
		  
		  System.out.println("-------------------------");
		  
		  Employee employee = employees.stream().sorted(
				  
				  			(e1,e2) -> e2.getSalary().compareTo(e1.getSalary())
				  ).skip(2).findFirst().get();
		  
		  System.out.println("Employee with 3rd lowest salary is -> "+employee.getEmployeeName());
		  
		  System.out.println("-------------------------");
		  
		  resultSet.forEach((dept,emp) -> System.out.println(dept+" -> "+emp.get().getEmployeeName()));
				

	}

}
