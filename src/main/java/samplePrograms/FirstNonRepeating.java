package samplePrograms;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeating {
	
	private void nonRepeating1(String input) {
		char[] inputArry = input.toCharArray();
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		
		for(char ch : inputArry) {
			if(map.get(ch) != null) {
				int intV = map.get(ch);
				map.put(ch, ++intV);
			} else {
				map.put(ch, 1);
			}
		}
		
		/*for(Map.Entry<Character, Integer> entry: map.entrySet()) {
			if(entry.getValue() == 1) {
				System.out.println(entry.getKey());
				break;
			}
		}*/
		
		/****OR Java8*/
		System.out.println(map.entrySet().stream()
				.filter(e -> e.getValue() == 1)
				.findFirst()
				.map(Map.Entry::getKey)
				.orElse(null));
	}
	
	private void nonRepeating2(String input) {
		int i = 0;
		Set<Character> set = new HashSet<Character>();
		while( i <= input.length()) {
			char ch = input.charAt(i);
			if(!set.contains(ch) && (input.indexOf(ch, (i+1))) == -1) {
				System.out.println(input.charAt(i));
				break;
			}
			++i;
			set.add(ch);
		}
	}
	
	/**
	 * Using JAVA8
	 */
	private char nonRepeating3(String input) {
		Map<Integer,Long> characters = input.chars().boxed()
	            .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
	    return (char)(int)characters.entrySet().stream()
	            .filter(e -> e.getValue() == 1L)
	            .findFirst()
	            .map(Map.Entry::getKey)
	            .orElseThrow(() -> new RuntimeException("No unrepeated character"));
	}

	public static void main(String[] args) {
		FirstNonRepeating obj = new FirstNonRepeating();
		obj.nonRepeating1("appale");
		obj.nonRepeating2("appale");
		System.out.println(obj.nonRepeating3("appale"));
	}

}
