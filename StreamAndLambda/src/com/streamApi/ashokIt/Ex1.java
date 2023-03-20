package com.streamApi.ashokIt;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex1 {

	public static void main(String[] args) {

		// get the customer informations
		List<Customer> customerData = CustomerUtils.getCusomerData();

		// converting the collection object into stream object

		Stream<Customer> stream = customerData.stream();

		// display customer info by using stream

		// stream.forEach((e) -> System.out.println(e));

		System.out.println("=============================");
		Consumer<Customer> con = (c) -> System.out.println(c);

		con.accept(customerData.get(1));

		customerData.forEach(con);

		// getting all the customer names from list of customers

		// map() is an intermediate operation
		// which is used to extract required property(customerName)
		// from object

		Function<Customer, String> f = (obj) -> {
			return obj.getName();
		};

		Stream<String> customerName = stream.map(f);
		customerName.forEach(c -> System.out.println(c));

		// map is and intermediate operation
		// stream.map((cust) -> cust.getName()).collect(Collectors.toList());

		List<String> names = Arrays.asList("abc", "dbc", "xyz");

		Stream<String> stream1 = names.stream();

		stream1.map(s -> s.toUpperCase()).forEach(s1 -> System.out.println(s1));

		// get all customer from ashta

		// filter() -> intermediate operation -> input parameter is predicate interface

		
		Predicate<Customer> p = (cust) -> cust.getAddress().get(1).getCityName().equalsIgnoreCase("Ashta");

		System.out.println("**************");
		Stream<Customer> newStream = customerData.stream();
		
		Stream<Customer> filteredListOfAshta = newStream.filter(p);
		
		filteredListOfAshta.forEach(con);
		

		

	}

}
