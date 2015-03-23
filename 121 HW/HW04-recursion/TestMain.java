

public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList myList= new LinkedList();
		myList.add("c");
		myList.add("a");
		myList.add("d");
		myList.add("b");
		myList.add("sdf");
		myList.add("123");
		myList.add("678");
		myList.add("z");
		System.out.println("Before"+myList.toString());
		myList.reverse();
		System.out.println("After"+myList.toString());
	}

}
