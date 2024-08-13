package com.soumya;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	
	static int computeSum() {
		
		List<Integer> nums = List.of(4,6,8,9,3,2,4,12);
		
		
		
		int sum = nums.
				  parallelStream().
				  mapToInt(num -> {
					  
					    System.out.println(Thread.currentThread().getName()+" processing... "+num);
					    
//					    try {
//							Thread.sleep(9000);
//						} catch (InterruptedException e) {
//							e.printStackTrace();
//						}
					    System.out.println(Thread.currentThread().getName()+" completed waiting for "+num);

					    return num;
				   }).
				  sum();
		 System.out.println(Thread.currentThread().getName()+" finished processing...");
		return sum;
	}
	public static void main(String[] args) throws InterruptedException, ExecutionException {
        
		List<String> names = List.of("Ram","shyam","Vimal","Priya","Nandita");
		
		ExecutorService service = Executors.newFixedThreadPool(4);
		
		 Future<Integer> data = service.submit(() -> computeSum());
		
		names.forEach(name -> {
			
			System.out.println(Thread.currentThread().getName()+" consumed : "+name);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		System.out.println("Result : "+data.get());
		
		service.shutdown();
	}

}
