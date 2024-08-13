package com.soumya;

import java.util.List;
import java.util.stream.Stream;

public class ParallelStream2 {
	
	public static void main(String[] args) {
		
		List<Integer> list = List.of( 3,7,8,9,0,6,8,4 );
		
		Stream<Integer> s	= 
							  list.
							  parallelStream().
							  filter(num -> {
						    	
						    	System.out.println(Thread.currentThread().getName()+" filter with : "+num);
						    	return num > 3;
							  }).
							  map(num -> {
						    	
						    	System.out.println(Thread.currentThread().getName()+" map-1 with : "+num);
						    	return num*2;
						    	
							  }).
							  map(num -> {
						    	
						    	System.out.println(Thread.currentThread().getName()+" sleeping in map-2 with : "+num);
						   
						    	
//						    	try {
//									Thread.sleep(1);
//								} catch (InterruptedException e) {
//									e.printStackTrace();
//								}
						    	return num*2;
						    	
							  });
		
		
		s.forEach(data -> {
			
			System.out.println(Thread.currentThread().getName()+" consumed : "+data);
			System.out.println(Thread.currentThread().getName()+" bye... ");
			
		});
		//System.out.println(s.findFirst().get());

		 
		System.out.println();
		System.out.println("Main terminated");
		
	}

}
