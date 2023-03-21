package com.streamApi.ashokIt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex2 {

	public static void main(String[] args) {

		// get the customer data
		List<Customer> custList = CustomerUtils.getCusomerData();

		// to display customer data without java8 -> using Iterator,ListIterator,forEach
		// loop
		Iterator<Customer> itr = custList.iterator();
		System.out.println("using iterator");

		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		System.out.println("using java 8 to display");
		// displaying the custList using java8 Terminal Operations i.e forEach
		Stream<Customer> custStream1 = custList.stream();

		Consumer<Customer> con = (c) -> System.out.println(c);
		// passing consumer fi to forEach method of stream interface
		custStream1.forEach(con);

		System.out.println("*********** revised code for javva 8 *************8");
		// reverside code
		custList.stream().forEach((c) -> System.out.println(c));

		// understanding filter() -> it is an intermediate operation -> it accepts one
		// predicate and return is boolean
		Stream<Customer> custStream2 = custList.stream();

		Predicate<Customer> predicate1 = (c) -> c.getName().length() > 5;

		Stream<Customer> filterdResult = custStream2.filter(predicate1);
		System.out.println("********** filter Result ***************");

		System.out.println(filterdResult);
		filterdResult.forEach(con);

		System.out.println("*********** Ashta ke sare employees *************");

		custList.stream().filter((e) -> "ASHTA".equals(e.getLocation().toUpperCase()))
				.forEach((e) -> System.out.println(e));

		// filterResultByCityAshta.forEach(con);

		// Map Operations
		// map -> is an also intermediate operations because its return type is stream
		// object
		// map is used for transformation
		// if we want to perform some operation on each element of array or stream then
		// we go for Map operation

		// examples of Map
		// Converting string into wrapper object
		// transforming the object from one type to another

		System.out.println("Map Operattions");

		List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5);
		Stream<Integer> intStream = numList.stream();
		Function<Integer, Integer> intFunction = (no) -> no * no;

		Predicate<Integer> intPredicate = no -> no > 9;

		intStream.map(intFunction).filter(intPredicate).forEach(e -> System.out.println(e));

		System.out.println("forEach() operation");
		// forEach is an Terminal Opertaion because return type is non stream
		// it is taking one parameter i.e. Consumer FI(taking one input and no output )
		// abd return type is void

		// once this method got encountered then only all intermediate
		// operations are exceuted in Stream of operations

		System.out.println("findAny() operations ");
		// findAny() is an terminal operation beacause return type is non-stream
		// as name suggest it is for find any element from stream and it
		// doesn't expect which element will be returned and returning the optional
		// object

		// findAny() is not taking any parameters

		// Optional is predefined class from java8 act as container object
		// holding data or not

		// in order to validate the data is present or not
		// in optional container objects have several utility methods
		// boolean isPresent() , Object get()

		List<String> namesList = Arrays.asList("ajay", "vijay", "raju", "kaju", "gaju");
		List<String> namesList1 = Arrays.asList();

		Optional<String> optional = namesList1.stream().findAny();
		System.out.println(optional);
		if (optional.isPresent()) {
			String name = optional.get();
			System.out.println("name -> " + name);

		}

		System.out.println("Collect operations");
		// collect() is an "Terminal operations"

		// it allows us to perform mutable fold operationss
		// (repackaging to some data structures and applyinng some
		// additional logic,, concatenating them )

		// In order to accumulate the elements into one collection object we
		// need to call below methods
		// Collectors.toList() - Accumulating elements into List Object
		// Collectors.toSet() - Accumulating elements into Set Object
		// Collectors.toMap() - Accumulating elements into Map Object
		// Collectors.toJoining() - Accumulating the strings into comma seperated value

		Predicate<String> p = x -> x.length() >= 3;

		List<String> listNames = namesList.stream().filter(p).collect(Collectors.toList());
		listNames.forEach(s -> System.out.println(s));

		System.out.println("***** set operations ********** ");
		namesList.stream().filter(p).sorted().collect(Collectors.toSet()).forEach(e -> System.out.println(e));
		;

		System.out.println("********** joining with collectors *********");
		String nameWithCommaSeperated = namesList.stream().filter(p).sorted().collect(Collectors.joining(","));
		System.out.println("name with comma seperated value -> " + nameWithCommaSeperated);

		System.out.println("toMap() operations");

		Map<Integer, String> map = custList.stream().collect(Collectors.toMap((c) -> c.getId(), (c) -> c.getName()));

		System.out.println(map);
		System.out.println("************************88");

		Map<Integer, Customer> mapWithIdAndObject = custList.stream()
				.collect(Collectors.toMap((c) -> c.getId(), Function.identity()));

		System.out.println("Map with id and its object -> " + mapWithIdAndObject);
	}
}
