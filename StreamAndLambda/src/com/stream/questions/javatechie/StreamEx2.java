package com.stream.questions.javatechie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamEx2 {

	public static void main(String[] args) {
		System.out.println(
				"Q1 Given a list of integers, find out all the even numbers exist in the list using Stream functions?");

		List<Integer> myList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 20, 25);

		Predicate<Integer> p = (e) -> e % 2 == 0;
		myList.stream().filter(p).forEach(e -> System.out.print(e + " "));

		System.out.println();
		System.out.println(
				"Q2 Given a list of integers, find out all the numbers starting with 1 using Stream functions?");

		Predicate<Integer> p1 = (e) -> {
			while (e >= 10) {
				e /= 10;
			}
			if (e == 1) {
				return true;
			} else {
				return false;
			}
		};

		// another approach for finding the digit count
		// Log-based Solution to count digits in an integer

		Predicate<Integer> p2 = (e) -> {

			int n = (int) Math.floor(Math.log10(e) + 1);

			e /= n;

			if (e == 1) {
				return true;
			} else {
				return false;
			}
		};

		myList.stream().filter(p1).forEach(e -> System.out.print(e + " "));

		int x = (int) Math.floor((int) Math.log10(999) + 1);

		System.out
				.println("Q3 How to find duplicate elements in a given integers list in java using Stream functions?");

		List<Integer> myList1 = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);

		Set<Integer> set = myList1.stream().collect(Collectors.toSet());
		System.out.println(set);

		System.out.println("Q4 Given the list of integers, find the first element of the list using Stream functions?");

		myList1.stream().findFirst().ifPresent(System.out::println);

		System.out.println(
				"Q5 Given a list of integers, find the total number of elements present in the list using Stream functions?");

		long count = myList.stream().count();
		System.out.println(count);

		
		System.out.println("Q6 Given a list of integers, find the maximum value element present in it using Stream functions?");
		Integer max = myList1.stream().max(Integer::compare).get();
		System.out.println(max);
	
	}
}
