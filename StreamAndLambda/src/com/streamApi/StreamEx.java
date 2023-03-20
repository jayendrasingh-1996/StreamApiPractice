package com.streamApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Stream;

public class StreamEx {

	public static void main(String[] args) {

		Stream<String> names = Stream.empty();

		Collection<String> name = Arrays.asList("Mahesh", "Ramesh", "upesh");

		name.add("Jay");
		name.add("Ajay");
		name.add("Vijay");
		name.add("XXX");

//		long count = name.stream().count();

		// System.out.println(count);

		String[] arr = new String[] { "a", "b", "c" };

		Stream<String> name1 = Arrays.stream(arr);
		Stream.builder().add("a").add("b").build();
		
		
	}
}
