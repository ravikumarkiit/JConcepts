package examples;

public class PassByValue {
	
	public static void main(String[] args) {
		Age age = new Age(1987);
		Employee employee1 = new Employee("ravi", age);
		
		Age age2 = new Age(1980);
		Employee employee2 = new Employee("Xyz", age2);
		
		swap(employee1, employee2); //No Impact
		System.out.println(employee1 + " "+ employee2);
		
		swapValues(employee1, employee2);// Values Can be Modified As Pas By value
		System.out.println(employee1 + " "+ employee2);
	}
	
	static void swap(Employee e1, Employee e2) {
		e1 = e2;
		e2=null;
	}
	
	static void swapValues(Employee e1, Employee e2) {
		e1.name = e2.name;
		e2.name=null;
	}
	

}

class Employee {
	String name;
	Age age;
	
	public Employee(String name, Age age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Age getAge() {
		return age;
	}
	public void setAge(Age age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + "]";
	}
	
	
}

class Age {
	int year;

	public Age(int year) {
		this.year = year;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Age [year=" + year + "]";
	}
	
}
