package examples;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListEx {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,6,7,777,6,44454,5454);
		
		//CopyOnWriteArrayList : Creates a new copy of list if list is modified. Returns FailSafe iterator()
		list = new CopyOnWriteArrayList<Integer>(list); //If Commented : UnsupportedOperationException 
    	
    	/*for(int i : list) {
    		System.out.println(" "+ i);
    		list.remove(list.indexOf(i));
    	}*/
    	int count = 5454;
    	Iterator<Integer> iterator = list.iterator();
    	while(iterator.hasNext()) {
    		System.out.println("List is: "+ list);
    		Integer current = iterator.next();
    		System.out.println(current);
    		list.remove(current);
    		list.add(count++);
    	}
    	
    	System.out.println(list.size());
	}
 
}
