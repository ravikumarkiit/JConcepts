package examples;

/*Comment equals method and see the diff, default Object.equals compares references But in String it only compares data*/
 /*It return true if two String object contains same content but == will only return true if two references are pointing to same object
		 To compare object references, you use == and != , while equals is used to compare the values*/

public class ObjectEquality {
	
	String id;
	
	
	public ObjectEquality(String id) {
		super();
		this.id = id;
	}
	
	/*@Override
	public boolean equals(Object o) {
		return this.id == ((ObjectEquality)o).getId();
	}*/

	public static void main(String[] args) {
		ObjectEquality cc1 = new ObjectEquality("1");
		ObjectEquality cc2 = new ObjectEquality("1");
		
		System.out.println(cc1.equals(cc2));
		System.out.println(cc1 == (cc2));
		
		String s1 = new String("1");
		String s2 = new String("1");
		
		System.out.println(s1.equals(s2));
		System.out.println(s1 == (s2));
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


}
