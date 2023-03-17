package com.predifiendFI;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Student {
	String name;
	int marks;

	Student(String name, int marks) {
		this.marks = marks;
		this.name = name;
	}

}

public class FunctionFIEx {

	// input -> perform operation -> output
	// 4 -> square operations -> 16

	// interface Function<T,R>
	// public R apply(T t);
	public static void main(String[] args) {

		Function<Integer, Integer> f = i -> i * i;

		System.out.println(f.apply(4));

		System.out.println("return the string length");

		Function<String, Integer> f1 = s -> s.length();

		System.out.println(f1.apply("ajay"));

		System.out.println("return the string to uppercase");

		Function<String, String> f2 = s -> s.toUpperCase();

		System.out.println(f2.apply("ajay"));

		// write a function to find out grade of student

		Function<Student, String> f3 = (s) -> {
			int marks = s.marks;
			String grade = "";
			if (marks >= 80)
				grade = "A[Distinction]";
			else if (marks >= 60)
				grade = "B[First Class]";
			else if (marks >= 50)
				grade = "C[Second Class]";
			else if (marks >= 4)
				grade = "D[Third Class ]";
			else
				grade = "F[Failed]";

			return grade;
		};

		List<Student> stuList = new ArrayList<>();

		stuList.add(new Student("Ajay", 65));
		stuList.add(new Student("jay", 105));
		stuList.add(new Student("vijay", 95));
		stuList.add(new Student("raja", 45));
		stuList.add(new Student("gajju", 85));
		stuList.add(new Student("tej", 75));

		for (Student s : stuList) {

			System.out.println("name " + s.name + " Grade " + f3.apply(s));
		}

		// need to store name in map as a key and there grade in value
		stuList.stream().map((s) -> f3.apply(s)).collect(Collectors.toList());

	}

}
