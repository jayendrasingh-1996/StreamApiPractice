package com.predifiendFI;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
	 Student getObject()
	{
		return this;
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

		
		//function chaining is possible
		//f1.andThen(f2).apply(i) - >first f1 then followed by f2
		
		//f1.compose(f2).apply(i) -> first f2 
		
		// need to store name in map as a key and there grade in value
		//stuList.stream().map((s) -> f3.apply(s)).collect(Collectors.toMap(Student::getObject,"123",(x,y)->x+","+y+",",LinkedHashMap::new));
		
		
		Map<Student, String> map = stuList.stream().collect(Collectors.toMap(Function.identity(), (s) -> f3.apply(s)));
	
		map.entrySet().stream().forEach(val->System.out.println(val.getValue()+" "+val.getKey()));
		
		
		
	}

}
