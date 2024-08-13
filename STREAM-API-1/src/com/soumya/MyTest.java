package com.soumya;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MyTest {

	static public String transform(String name) {
		
		System.out.println(Thread.currentThread().getName()+" with : "+name);
		System.out.println(Thread.currentThread().getName()+" completed with : "+name);

		return name.toUpperCase();
	}
	public static void main(String[] args) {
		
		List<String> names = Arrays.asList("Aa","bbcv","cc","2MNds","xxD");
		
		List<String> modifiedNames = names.
									 parallelStream().
									 map(name -> transform(name)).
									 collect(Collectors.toList());
		
		
		System.out.println(modifiedNames);
		
	}

}
