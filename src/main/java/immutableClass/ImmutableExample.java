package immutableClass;

public class ImmutableExample {

	public static void main(String[] args) {
		Age age = new Age();
	    age.setDay(1);
	    age.setMonth(1);
	    age.setYear(1992);
	    ImmutableStudent student = new ImmutableStudent(1, "Alex", age); // Mutable data type Age, How to handle?? use Cloned Object for setting and getting age
	    
	    System.out.println("Alex age year before modification = " + student.getAge().getYear());
	    age.setYear(1993); // No Impact
	    System.out.println("Alex age year after modification = " + student.getAge().getYear());
	    
	    System.out.println("Alex age year before modification = " + student.getAge().getYear());
	    student.getAge().setYear(1993); // No Impact
	    System.out.println("Alex age year after modification = " + student.getAge().getYear());
	    
	    
	}

}
