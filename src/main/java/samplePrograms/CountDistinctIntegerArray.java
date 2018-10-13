package samplePrograms;

import java.util.Arrays;

public class CountDistinctIntegerArray {
	
	public static void main(String args[]){
		int[] arr = {2,2,5,6,3,2,5,1};

		new CountDistinctIntegerArray().countDistinct(arr);
	}

	private void countDistinct(int[] arr) {
		Arrays.stream(arr).distinct().forEach(input -> {
			int count = (int) Arrays.stream(arr).filter(a -> a == input).count();
			System.out.println("element: "+ input+ " Count: "+ count);
		});
	}
	
}
