package samplePrograms;

public class FibonnaciRecursive {
	int i = 0;
	int j = 1;
	int sum = 0;

	public void print(int count) {
		i = j;
		j = sum;
		if(count > 0) {
			System.out.println(sum);
			sum = i + j;
			print(--count);
		}
	}
	public static void main(String[] args) {
		new FibonnaciRecursive().print(10);
	}

}
