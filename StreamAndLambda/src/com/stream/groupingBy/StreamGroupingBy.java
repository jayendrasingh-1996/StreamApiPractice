package com.stream.groupingBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamGroupingBy {

	public static void main(String[] args) {

		Student st1 = new Student(1, "ajay", 26, new int[] { 10, 80, 70, 60, 50 });
		Student st2 = new Student(2, "jay", 27, new int[] { 10, 80, 70, 60, 50 });
		Student st3 = new Student(3, "vijay", 23, new int[] { 10, 80, 70, 60, 50 });
		Student st4 = new Student(4, "rakesh", 24, new int[] { 10, 80, 70, 60, 50 });
		Student st5 = new Student(5, "ramesh", 29, new int[] { 10, 80, 70, 60, 50 });
		Student st6 = new Student(6, "anu", 24, new int[] { 10, 80, 70, 60, 50 });
		Student st7 = new Student(7, "akash", 24, new int[] { 10, 80, 70, 60, 50 });
		Student st8 = new Student(8, "ritu", 26, new int[] { 10, 80, 70, 60, 50 });
		Student st9 = new Student(9, "nilesh", 24, new int[] { 10, 80, 70, 60, 50 });
		Student st10 = new Student(10, "monu", 22, new int[] { 10, 80, 70, 60, 50 });

		Function<Student, String> funForFindingGrade = (s) -> {

			int[] mark = s.getMarks();
			int totalMarks = findTotalSum(mark);

			double marks = findPercentage(totalMarks, mark.length);

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
		stuList.add(st1);
		stuList.add(st2);
		stuList.add(st3);
		stuList.add(st4);
		stuList.add(st5);
		stuList.add(st6);
		stuList.add(st7);
		stuList.add(st8);
		stuList.add(st9);
		stuList.add(st10);

		Map<Integer, List<Student>> goupByAge = stuList.stream().collect(Collectors.groupingBy((s) -> s.getAge()));

		System.out.println(goupByAge);

		Map<Integer, Map<Student, String>> mapOfGrade = stuList.stream().collect(
				Collectors.groupingBy(s -> s.getAge(), Collectors.toMap(Function.identity(), funForFindingGrade)));

		System.out.println(mapOfGrade);

		Map<Integer, Set<Student>> groupBySet = stuList.stream()
				.collect(Collectors.groupingBy(s -> s.getId(), Collectors.toSet()));

		System.out.println(groupBySet);

		Map<Integer, List<String>> collect = stuList.stream().collect(
				Collectors.groupingBy(e -> e.getAge(), Collectors.mapping(Student::getName, Collectors.toList())));

		System.out.println(collect);

	}

	private static double findPercentage(int totalMarks, int n) {

		return totalMarks / n;
	}

	private static int findTotalSum(int[] marks) {

		int sum = 0;
		for (int i = 0; i < marks.length; i++) {
			sum += marks[i];
		}

		return sum;
	}
}

class Student {
	int id;
	String name;
	int age;
	int[] marks;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int[] getMarks() {
		return marks;
	}

	public void setMarks(int[] marks) {
		this.marks = marks;
	}

	public Student(int id, String name, int age, int[] marks) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", marks=" + Arrays.toString(marks) + "]";
	}

}
