package com.predifiendFI;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class Employee {
	String name;
	int age;
	double salary;

	public Employee(String name, int age, double salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

}

public class PredicateEx {
	public static boolean test(Integer i) {
		if (i % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {

		Predicate<Integer> p = (e) -> e % 2 == 0;

		System.out.println(p.test(10));

		String[] s = { "ajay", "vijay", "raja", "qwerty" };
		Predicate<String> p1 = str -> str.length() > 5;

		for (String s1 : s) {

			if (p1.test(s1)) {
				System.out.print(s1);
			}
		}

		System.out.println();
		System.out.println("even length string");
		Predicate<String> p2 = str -> str.length() % 2 == 0;
		for (String s1 : s) {

			if (p2.test(s1)) {
				System.out.print(s1 + " ");
			}
		}

		List<Employee> empList = new ArrayList<>();

		empList.add(new Employee("ajay", 25, 150));
		empList.add(new Employee("jay", 11, 100));
		empList.add(new Employee("vijay", 15, 250));
		empList.add(new Employee("aaa", 20, 350));
		empList.add(new Employee("bbb", 30, 650));
		empList.add(new Employee("ccc", 14, 550));
		empList.add(new Employee("ddd", 15, 450));

		// list of employees whose salary is more than 400
		Predicate<Employee> p3 = e -> e.salary > 400;
		System.out.println("List of Employees Names");
		for (Employee e1 : empList) {
			if (p3.test(e1)) {
				System.out.print(e1.name + " ");
			}
		}

		// Predicate Joining
		// we can combine two predicate using ( and , or , negate )
		// p1.or(p2)
		// p1.and(p2);

		int[] x = { 0, 11, 12, 7, 9, 16 };

		Predicate<Integer> p4 = i -> i > 10;

		System.out.println("the no's which are even and > 10");

		for (int x1 : x) {

			if (p.and(p4).test(x1)) {
				System.out.print(x1 + " ");
			}
		}

		System.out.println("the no's which are not even ");
		for (int x1 : x) {

			if (p.negate().test(x1)) {
				System.out.print(x1 + " ");
			}
		}
	}
}
