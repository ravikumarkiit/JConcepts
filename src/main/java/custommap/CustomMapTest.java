package custommap;

import java.util.Map.Entry;
import java.util.TreeMap;

public class CustomMapTest {
	
	public static void main(String[] args) {
		Student s1 = new Student("A");
		Student s2 = new Student("B");
		Student s3 = new Student("C");
		Student s4 = new Student("D");
		
		College c1 = new College();
		
		TreeMap<Student, College> cmap = new CustomMap<Student, College>();
		cmap.put(s3, c1);
		cmap.put(s1, c1);
		cmap.put(s4, c1);
		cmap.put(s2, c1);
		
		for (Entry<Student, College> entry : cmap.entrySet()) {
			System.out.println(entry.getKey().name + " - " + entry.getValue());
		}

	}

}
