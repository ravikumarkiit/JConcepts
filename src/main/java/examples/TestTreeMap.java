package examples;
import java.util.Map.Entry;
import java.util.TreeMap;

/*Custom Objects need to be comparable in order to be eligible to be added to a TreeSet OR as Key in TreeMap*/

class Dog implements Comparable<Dog>{
	String color;
	int size;
	Dog(String c, int s) {
		color = c;
		size = s;
	}

	@Override
	public String toString(){
		return color + " dog";
	}

	public int compareTo(Dog o) {
		return o.size - this.size;
	}
}

public class TestTreeMap {
	public static void main(String[] args) {
		Dog d1 = new Dog("red", 30);
		Dog d2 = new Dog("black", 20);
		Dog d3 = new Dog("white", 10);
		Dog d4 = new Dog("white", 10);
		
		System.out.println("Equals "+ d3.equals(d4) + "\n hashcode: " + d3.hashCode() +" hashcode: "+ d4.hashCode());
		
		TreeMap<Dog, Integer> treeMap = new TreeMap<Dog, Integer>();
		treeMap.put(d1, 10);
		treeMap.put(d2, 15);
		treeMap.put(d3, 5);
		treeMap.put(d4, 20);
		
		for (Entry<Dog, Integer> entry : treeMap.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
	}
}