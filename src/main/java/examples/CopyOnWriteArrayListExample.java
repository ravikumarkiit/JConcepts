package examples;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author www.codejava.net
 */
public class CopyOnWriteArrayListExample {

	//One thread writing will NOT impact otherThread already created iterator() and read Opern. iterator() Works on snapShot while creation.
	public static void main(String[] args) {  
		List<Integer> list = new CopyOnWriteArrayList<>();

		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

		new WriteThread("Writer", list).start();
		new ReadThread("Reader", list).start();
	}
}


class WriteThread extends Thread {

	private List<Integer> list;

	public WriteThread(String name, List<Integer> list) {
		this.list = list;
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

			list.add(count++);
			System.out.println(super.getName() + " done");
		}
	}
}


class ReadThread extends Thread {
	private List<Integer> list;

	public ReadThread(String name, List<Integer> list) {
		this.list = list;
		super.setName(name);
	}

	public void run() {
		String output = "\n" + super.getName() + ":";
		Iterator<Integer> iterator = list.iterator();

		while (iterator.hasNext()) {
			Integer next = iterator.next();
			output = " " + next;
			try {
				Thread.sleep(1000);
				System.out.println(output);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
}
