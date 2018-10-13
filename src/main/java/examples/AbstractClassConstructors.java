package examples;


/*If we define parametrized constructor in Abstract class then we must have 
 * 1. Similar parametrized constuctor in Child Class
 * 2. OR Have call to parametrized constructor from default constructor of child class using super()
 * 3. OR define default constructor in abstract class so that implicitly child class default constructor 
 * will call default constructor of parent
 * */
public class AbstractClassConstructors extends Foo{
	
/*	public Test() {
super("");
	}*/
	
	/*public Test(String text) {

	}*/

	public static void main(String[] args) {
		Foo tt =new AbstractClassConstructors();
//		Foo tt =new Test("tt");
		System.out.println(tt.getmText());
	}

}

abstract class Foo {
    String mText;

    public String getmText() {
		return mText;
	}

	public void setmText(String mText) {
		this.mText = mText;
	}

	public Foo() {
    	
    }
    
    public Foo(String text) {
        mText = text;
    }  
}
