package examples;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
 
/**
 * @author www.codejava.net
 */
public class ConcurrentHashmapExample {

public static void main(String[] args) { //One thread writing will impact otherThread already created iterator() and read Opern.
        Map<Integer, String> map = new ConcurrentHashMap<>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        map.put(4, "d");
        map.put(5, "e");
 
        new WriteThreadMap("Writer", map).start();
        new ReadThreadMap("Reader", map).start();
    }
}
 
 
class WriteThreadMap extends Thread {
 
    private Map<Integer, String> map;
 
    public WriteThreadMap(String name, Map<Integer, String> map) {
        this.map = map;
        super.setName(name);
    }
 
    public void run() {
        int count = 6;
 
        while (true) {
 
            try {
                Thread.sleep(900);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            map.put(count++,"a");
            System.out.println(super.getName() + " done");
        }
    }
}
 
 
class ReadThreadMap extends Thread {
    private Map<Integer, String> map;
 
    public ReadThreadMap(String name, Map<Integer, String> map) {
        this.map = map;
        super.setName(name);
    }
 
    public void run() {
 
            String output = "";
 
            /*Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
            	Map.Entry<Integer, String> next = iterator.next();
                output = " " + next.getKey();
                try {
                    Thread.sleep(1000);
                    System.out.println(super.getName() + ": "+output);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }*/
            //OR
            for(Map.Entry<Integer, String> entry : map.entrySet()) {
            	 output = " " + entry.getKey();
            	try {
                    Thread.sleep(1000);
                    System.out.println(super.getName() + ": "+output);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
 
    }
}
