package examples;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public abstract class TestConcept {

	public static void main(String[] args) throws Exception{
		  //Creating a ConcurrentHashMap
        
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<String, Integer>();
         
        //Adding elements to map
         
        map.put("ONE", 1);
         
        map.put("TWO", 2);
 
        map.put("THREE", 3);
         
        map.put("FOUR", 4);
         
        //Getting an Iterator from map
         
        Iterator<Entry<String, Integer>> it = map.entrySet().iterator();
         
        while (it.hasNext())
        {
        	Entry entry = it.next();
             
            System.out.println("value : "+entry.getValue());
             
            map.put("FIVE", 5);     //This will not be reflected in the Iterator
        }
	}

}
