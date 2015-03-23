package HW6;

public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//ArraySet<String> arraySet = new ArraySet<String>();
		LinkedCycle<String> arraySet = new LinkedCycle<String>();
		arraySet.add("abc");
		//System.out.println(arraySet.contains("ab"));
		arraySet.add("abcd");
		//System.out.println(arraySet.contains("abcc"));
		arraySet.add("a");
		arraySet.add("abcde");
		arraySet.add("abcd");
		//System.out.println(arraySet.contains("abcd"));
		//arraySet.add("ab");
		
		System.out.println(arraySet.toList().toString());
		System.out.println(arraySet.size());
		System.out.println("Remove element:"+arraySet.remove());
		System.out.println(arraySet.toList().toString());
		arraySet.scroll(2);
		System.out.println(arraySet.toList().toString());
		
		//System.out.println(arraySet.size());
		//arraySet.add("ab");
		//arraySet.add("abc");
		//arraySet.remove("abc");
		
		
		
		
	}

}
