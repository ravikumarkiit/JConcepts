package custommap;

public class Student implements Comparable{
	public String name;

	Student(String name) {
		this.name = name;
	}
	
	public int compareTo(Object o) {
		Student s = (Student) o;
		return this.name.compareTo(s.name);
	}
	
}
