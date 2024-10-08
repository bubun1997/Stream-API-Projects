package com.soumya.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	
	private String empId;
	
	private String empName;
	
	private String empDept;
	
	private Double empSalary;
	
	

}
