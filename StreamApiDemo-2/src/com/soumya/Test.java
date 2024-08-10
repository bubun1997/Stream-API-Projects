package com.soumya;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Test {

	public static void main(String[] args) {
        
		List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		int sum1 =  nums.
					stream().
					filter( num -> num%2 == 0).
					map(num -> num*2).
					reduce(0, Integer::sum);
		
		double sum2 = nums.
				      stream().
				      filter( num -> num%2 == 0).
				      mapToDouble(num -> num*2). 
				      sum();
		
		IntStream doubleStream =nums.stream().mapToInt(num -> {
			   
			System.out.println("map executed");
			return num;
		});
		
		System.out.println(sum1);
		System.out.println(sum2);

		System.out.println(doubleStream.sum());
		
		   
	}

}
