package com.soumya;

import java.util.*;

public class ParallelStream1
{
	public static void main(String[] args) {
		
		List<Integer> list = List.of(
		        3,7,8,9,0,6,8,4
		        
		    
		    );
		 
		 list.
		 parallelStream().
		 forEach(num -> {
		     		     
		     
		     System.out.println(Thread.
		         currentThread().getName()
		         +" consumed : "+num);
		     
		     System.out.println(Thread.currentThread().getName()+" bye... ");

		        
		 });
		
		System.out.println("Hello World by main");
	}
}
