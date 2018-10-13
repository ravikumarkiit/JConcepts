package samplePrograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MissingFirstIntegerInArray {
	
	/*Solution1*/
	public int solution1(int[] A) {
		int data=0;
		List<Integer> list = arrayToList(A);
		
		for(int i = 1; i<100000;i++) {
			data = i;
			if(!list.contains(i)) {
				break;
			}
		}
        return data;
	}
	
	/*Solution2 JAVA 8*/
	int data = 0;
	private void setData(int i) {
		data = i;
	}
	public int solution2(int[] A) {
		List<Integer> list = /*arrayToList(A);*/ Arrays.stream(A).boxed().collect(Collectors.toList());
		IntStream.range(1, 100000).noneMatch(i -> {
			boolean result = !list.contains(i);
			if(result) {
				setData(i);
			}
			/*System.out.println(i);*/
			return result;
		});
		return data;
    }
	
	private List<Integer> arrayToList(int[] A) {
		List<Integer> list = new ArrayList<>(A.length);
		for(int i : A) {
			list.add(i);
		}
		return list;
	}

	public static void main(String[] args) {
		MissingFirstIntegerInArray obj = new MissingFirstIntegerInArray();
		int[] A = {4,2,1,6,3, 8, 9};
		System.out.println("First missing integer= "+obj.solution1(A));
		System.out.println("First missing integer= "+obj.solution2(A));
	}

}
