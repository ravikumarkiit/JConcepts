package samplePrograms;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.function.Function;

public class Sorting {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1,2,3,4,11,14,12,5,6,7,8,9,10));
		
		System.out.println("Natural Order");
		list.sort(Comparator.naturalOrder());
		list.stream().forEach(System.out::println);
		
		System.out.println("Reverse Order");
		list.sort(Comparator.reverseOrder());
		list.stream().forEach(System.out::println);
		
		Collections.sort(list, Comparator.naturalOrder());

		System.out.println("Natural Order");
		list
		.stream()
		.sorted(Comparator.comparing(Function.identity(), Comparator.reverseOrder()/*.thenComparing(a -> a, Comparator.naturalOrder())*/ ))
		.sorted(Comparator.comparing(Function.identity(), Comparator.naturalOrder() ))
		.forEach(System.out::println);
	}

}
