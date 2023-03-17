package com.predifiendFI;

import java.util.function.Predicate;

public class PredicateEx {

	
	public static void main(String[] args) {
	
		Predicate<Integer> p = (e) -> e %2==0;
		
		System.out.println(p.test(10));
		
	}
}
