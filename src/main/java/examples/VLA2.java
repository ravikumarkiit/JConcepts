package examples;

import java.util.Arrays;
import java.util.Comparator;

public class VLA2 implements Comparator<VLA2> {
	int dishSize;
	VLA2(int d){
		dishSize = d;
	}

	@Override
	public int compare(VLA2 arg0, VLA2 arg1) {
		return arg1.dishSize - arg0.dishSize;
	}
	
	public static void main(String args[]) {
		VLA2[] va = {new VLA2(40), new VLA2(200), new VLA2(60)};
		Arrays.sort(va, va[1]);
		Arrays.stream(va).map(a-> a.dishSize).forEach(System.out::println);
		int index1 = Arrays.binarySearch(va, new VLA2(40), va[0]);
		System.out.println(index1 + " ");
		index1 = Arrays.binarySearch(va, new VLA2(80), va[0]); //If not found return (-(insertion point) - 1).
		System.out.println(index1 + " ");
	}

}
