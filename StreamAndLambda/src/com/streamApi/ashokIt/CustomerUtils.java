package com.streamApi.ashokIt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomerUtils {

	public static List<Customer> getCusomerData() {

		Address homeAddress = new Address("123", "abc street", "bhopal");
		Address officeAddress = new Address("321", "xyz street", "Ashta");

		Customer customer1 = new Customer(1, "Ajay", "Ashta", "ajay@gmail.com", "789874561",
				Arrays.asList(homeAddress, officeAddress));

		Customer customer2 = new Customer(2, "Jay", "Bhopal", "jay@gmail.com", "9874561787",
				Arrays.asList(homeAddress, officeAddress));
		Customer customer3 = new Customer(3, "Vijay", "Indore", "vijay@gmail.com", "6698745614",
				Arrays.asList(homeAddress, officeAddress));
		Customer customer4 = new Customer(4, "Rajesh", "Ashta", "ajay@gmail.com", "789874561",
				Arrays.asList(homeAddress, officeAddress));
		Customer customer5 = new Customer(5, "Rakesh", "Ashta", "ajay@gmail.com", "789874561",
				Arrays.asList(homeAddress, officeAddress));
		Customer customer6 = new Customer(6, "Raju", "Ashta", "raju@gmail.com", "339874561",
				Arrays.asList(homeAddress, officeAddress));
		Customer customer7 = new Customer(7, "golu", "Pune", "golu@gmail.com", "559874561",
				Arrays.asList(homeAddress, officeAddress));
		Customer customer8 = new Customer(8, "ajay", "Ashta", "ajay@gmail.com", "449874561",
				Arrays.asList(homeAddress, officeAddress));

//		List<Customer> list = new ArrayList<>();

		return Arrays.asList(customer1, customer2, customer3, customer4, customer5, customer6, customer7, customer8);

	}
}
