package samplePrograms;

public class Fibonnaci {

	public static void print(int range) {
		int i = 0;
		int j = 1;
		int sum = 0;
		while(sum < range) {
			i = j;
			j = sum;
			System.out.println(sum);
			sum = i + j;
		}
	}
	public static void main(String[] args) {
		Fibonnaci.print(50);
	}

}
