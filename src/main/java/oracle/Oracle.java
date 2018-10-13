package oracle;

import java.io.Serializable;

public class Oracle implements Serializable {

	String s;

	Oracle(String s){
		this.s = s;
	}
	
	public static void main(String[] args) {
		String s2 = "a";
		StringBuffer s1 = new StringBuffer("a");
		
		if(s1.equals(s2)) {
			System.out.println("Match 1");
		} else if (s1.toString().equals(s2.toString())){
			System.out.println("Match 2");
		} else {
			System.out.println("No Match");
		}
	}

}

class TestImpl extends Oracle {

	String t;
	
	TestImpl(String t) {
		super(t);
		this.t = t;
	}
	
	TestImpl(String v1, String v2){
		super(v1);
		this.t = v2;
	}
	
}