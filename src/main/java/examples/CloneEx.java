package examples;

public class CloneEx implements Cloneable{

	String s;
	Nonprimitve nonprimitve;

	public static void main(String[] args) throws CloneNotSupportedException {
		CloneEx t1 = new CloneEx();
		String strObj1 = "s1";
		Nonprimitve nonPremObj1 = new Nonprimitve("Name1");
		t1.setS(strObj1);
		t1.setNonprimitve(nonPremObj1);

		CloneEx t2 = (CloneEx) t1.clone();
		
		System.out.println("Before Changing data");
		System.out.println(t2.getS());
		System.out.println(t2.getNonprimitve().getName());
		
		strObj1 = "s2";
		nonPremObj1.setName("Name2");
		
		System.out.println("\nAfter Changing data");
		System.out.println(t2.getS());
		System.out.println(t2.getNonprimitve().getName());
		
		System.out.println(t2 == t1);
		System.out.println(t2.equals(t1));
	}

	public String getS() {
		return s;
	}
	public void setS(String s) {
		this.s = s;
	}
	public Nonprimitve getNonprimitve() {
		return nonprimitve;
	}
	public void setNonprimitve(Nonprimitve nonprimitve) {
		this.nonprimitve = nonprimitve;
	}
	
	
}

class Nonprimitve {
	String name;
	Nonprimitve(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}