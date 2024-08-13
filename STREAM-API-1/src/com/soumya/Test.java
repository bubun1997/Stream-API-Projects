package com.soumya;

import java.util.List;
import java.util.UUID;

import com.soumya.dto.Employee;

public class Test {

	public static void main(String[] args) {
       
		var employees = List.of(new Employee[] {
				
				Employee.
				builder().
				empId(UUID.randomUUID().toString()).
				empName("Ram").
				empDept("Dev").
				empSalary(52000.00).
				build(),
				
				Employee.
				builder().
				empId(UUID.randomUUID().toString()).
				empName("Mohan").
				empDept("Analyst").
				empSalary(56000.00).
				build(),
				
				Employee.
				builder().
				empId(UUID.randomUUID().toString()).
				empName("Priya").
				empDept("Dev").
				empSalary(54000.00).
				build(),
				
				Employee.
				builder().
				empId(UUID.randomUUID().toString()).
				empName("Kunal").
				empDept("Testing").
				empSalary(32000.00).
				build(),
				
				Employee.
				builder().
				empId(UUID.randomUUID().toString()).
				empName("Anjali").
				empDept("Sales").
				empSalary(42000.00).
				build(),
				
				Employee.
				builder().
				empId(UUID.randomUUID().toString()).
				empName("Nishant").
				empDept("Dev").
				empSalary(62000.00).
				build(),
		});
		
		var salary = employees.
					 parallelStream().
					 filter(emp -> emp.getEmpDept().equals("Dev")).
					 mapToDouble(Employee::getEmpSalary).
					 sum();
		
		System.out.println(salary);
		
		
	}

}
