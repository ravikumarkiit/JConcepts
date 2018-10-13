package oracle;

public class Test {
	
	public static void main() {
		Book book1 = new EBook ();
		book1.readBook();
	}
	
}

interface Readable {
	public void readBook();
	public void setBookMark();
}

abstract class Book implements Readable {
	public void readBook() {}
	
}

class EBook extends Book {
	public void readBook() {}
	public void setBookMark() {}
}