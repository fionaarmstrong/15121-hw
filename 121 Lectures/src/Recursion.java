/**
 *
 * @author Guoguo Lu <guoguol>
 * @section AAA
 */

// YOU MAY NOT IMPORT ANY ADDITIONAL
// CLASSES OR PACKAGES
import java.util.ArrayList;

public class Recursion {

  /**
   * The count method searches through each Node in the LinkedList
   *   and returns the number of Nodes whose data equals the findData
   *   parameter. If there are no matches, this method should just
   *   return 0
   *
   *   THIS METHOD MUST BE RECURSIVE
   *
   * @param head - reference to the front Node of the LinkedList
   * @param findData - the data we are searching for in a node
   * @return - the number of Nodes that match findData
   */
  public static int count(Node head, String findData) {
    if(head.next==null){
    	return head.data.equals(findData)?1:0;
    }
	  
    return (head.data.equals(findData)?1:0)+count(head.next,findData); 
  }

  /**
   * The isReverse method takes two String parameters and determines if
   *   string1 is the reverse of string2. string1 is the reverse of string2
   *   if every character is in the opposite position, mirrored across the
   *   center of the string. Here are some examples:
   *
   *   string1 = "foo";
   *   string2 = "oof";
   *   isReverse(string1, string2); // true
   *
   *   string1 = "cookie";
   *   string2 = "eikooc"
   *   isReverse(string1, string2); // true
   *
   *   string1 = "abc";
   *   string2 = "def";
   *   isReverse(string1, string2); // false
   *
   *   string1 = "";
   *   string2 = "";
   *   isReverse(string1, string2); // true
   *
   *   THIS METHOD MUST BE RECURSIVE
   *
   * @param string1 - the first string to compare
   * @param string2 - the second string to compare
   * @return - true if string1 is th reverse of string2, false otherwise
   */
  public static boolean isReverse(String string1, String string2) {
	  if(string1.length()!=string2.length())
		  return false;
	  if(string1.length()==1)
		  return string1.charAt(0)==string2.charAt(0);
	  //System.out.println(string1+"  "+string2);
    return (string1.charAt(0)==string2.charAt(string2.length()-1))
    		&& (isReverse(string1.substring(1, string1.length()),string2.substring(0,string2.length()-1))); // remove this line when you are done
  }

  public static int countStrings(Integer n) {
    return -1;
  }

  /**
   * The insertAfter method recursively searches the LinkedList looking
   *   for Nodes whose data (String) matches the findData parameter.
   *   It then creates a new Node and inserts the newly created node
   *   AFTER the FIRST occurrence of findData
   *
   * If there are multiple occurrences of findData, ONLY THE CLOSEST
   *   TO THE FRONT will be used
   *
   * If there are no occurrences of findData, the LinkedList should
   *   remain unchanged
   *
   *   THIS METHOD MUST BE RECURSIVE
   *
   * @param head - reference to the first Node of the LinkedList
   * @param findData - the data we are searching for
   * @param newData - the data we are inserting
   */
  public static void insertAfter(Node head, String insertData, String findData) {
    if(head.data.equals(findData)){
    	Node newNode = new Node(insertData);
    	newNode.next=head.next;
    	head.next=newNode;
    }
    else if(head.next==null){
    	return;
    }
    else {
    	insertAfter(head.next,insertData,findData);
    }
  }

  /**
   * The itAddsUp method returns true if all the elements in the ArrayList
   *  list add up (sum) to the specified target
   */
  public static boolean itAddsUp(ArrayList<Integer> list, Integer target) {
	  if(list.size()==1)
		  return list.get(0)==target;
	  
	 return itAddsUp(list,target-list.remove(list.size()-1));
    
  }

  /**
   * The removeDuplicates method removes all consecutive, duplicate
   *   characters from string. Here are some examples:
   *
   *   removeDuplicates("pizza"); // returns "piza"
   *   removeDuplicates("shell"); // returns "shel"
   *   removeDuplicates("mississippi"); // returns "misisipi"
   *   removeDuplicates("boooooooooooooooooo"); // returns "bo"
   *   removeDuplicates("desk"); // returns "desk"
   *
   *   THIS METHOD MUST BE RECURSIVE
   *
   * @param string
   * @return
   */
  public static String removeDuplicates(String string) {
	  if(string.length()==1){
		  return string;
	  }
	  else if(string.charAt(0)!=string.charAt(1)){
		  return string.charAt(0)+removeDuplicates(string.substring(1));
	  }	  
	  else{
		  return removeDuplicates(string.substring(1));
	  }
  }

  /**
   * This method returns a String with all the numbers from 1 to n,
   *   separated by dashes("-"). The string must start with the values
   *   of the even integers in descending order first and then follow
   *   with the odd integers in ascending order. This method does not
   *   print anything at all. Assume n is positive. You may NOT use helper
   *   methods to solve this problem; write a single method to solve this
   *   problem. Here are some examples:
   *
   *   stringNumbers(4); // returns "4-2-1-3"
   *   stringNumbers(1); // returns "1"
   *   stringNumbers(7); // returns "6-4-2-1-3-5-7"
   *
   *   THIS METHOD MUST BE RECURSIVE
   */
  public static String stringNumbers(Integer n) {
    if(n==1)
    	return "1";
    else if(n%2==1)
    	return stringNumbers(n-1)+"-"+n;
    else
    	return n+"-"+stringNumbers(n-1);
  }

  /**
   * For every consecutive pair of strings the method removes the longer
   *   of the two from the list. If there is a tie (strings with the same
   *   length), it removes the first of the pair. If there are an odd number
   *   of strings in the list, the final value remains in the list. You may
   *   not create new ArrayLists or arrays to solve this problem. Here are
   *   some examples:
   *
   *   ["foo", "zaps", "caps", "place"] -> ["foo", "caps"]
   *   ["fad", "fod", "zip", "zap"] -> ["fod", "zap"]
   *   ["foo"] -> ["foo"]
   *   ["foo", "caps", "fact"] -> ["foo", "fact"]
   *
   * Recall that ArrayLists are passed by reference.
   *
   *   THIS METHOD MUST BE RECURSIVE
   *
   * @param list
   */
  public static void removeLongerOfPairs(ArrayList<String> list) {
	  if(list.size()%2==1){
		 String lastOne=list.remove(list.size()-1);
		 removeLongerOfPairs(list);
		 list.add(lastOne);
	  }
	  else if(list.size()==0)
	  return;
	  else{
		  String string0=list.remove(list.size()-1);
		  String string1=list.remove(list.size()-1);
		  removeLongerOfPairs(list);
		  list.add((string0.length()>=string1.length())?string1:string0);
	  }  
  }

  /**
   * This method recursively removes all Nodes from a LinkedList whose data
   *   is exactly equal to the length parameter. All other Nodes should remain
   *   in their same relative positions.
   *
   * If there are no Nodes with data of length() length, this method should
   *   leave the list completely unchanged
   *
   *   THIS METHOD MUST BE RECURSIVE
   *
   * @param head
   * @param length
   * @return
   */
  public static Node removeAll(Node head, Integer length) {
	  if(head.next==null){
		  if(head.data.equals(Integer.toString(length))){
			  System.out.println("removed tail");
			  return null;
		  }
		  else
			  return head;
	  }
	  if(head.data.equals(Integer.toString(length))){
		  System.out.println("removed body");
		  head=removeAll(head.next,length);
		  return head;
	  }
		
	  else
		  head.next=removeAll(head.next,length);
		  return head;
	  }

  /**
   * Use the main method to write your tests
   */
  public static void main(String args[]) {
	  /*ArrayList<String> stringList = new ArrayList<String>();
	  stringList.add("fad");
	  stringList.add("fod");
	  stringList.add("zips");
	  stringList.add("zaps");
	  stringList.add("end");
	  for(String s:stringList)
		  System.out.println(s);
	  
	  Recursion.removeLongerOfPairs(stringList);
	  for(String s:stringList)
		  System.out.println("After: "+s);
	  */
	  
	  
	  LinkedList newList = new LinkedList();
	  newList.add("123");
	  newList.add("123");
	  newList.add("123");
	  newList.add("1234");
	  newList.add("123");
	  newList.add("123");
	  System.out.println(newList.toString());
	  
	  newList.head=Recursion.removeAll(newList.head, 123);
	  
	  System.out.println(newList.toString());
	  
	  //Recursion.insertAfter(newList.head, "new", "12345");
	  //System.out.println(newList.toString());
	  //System.out.println(Recursion.count(newList.head, "123"));
	  //System.out.println(Recursion.isReverse("1345", "5431"));
	  /*ArrayList<Integer> intList = new ArrayList<Integer>(0);
	  intList.add(0);
	  intList.add(3);
	  intList.add(12);
	  intList.add(2);
	  System.out.println(Recursion.itAddsUp(intList, 17));
	  */
	  
	  //System.out.println(Recursion.removeDuplicates("aaabbbbbbccdddddd"));
	  //System.out.println(stringNumbers(7));
	  assert(Recursion.count(null, "foo") == 0);
  }
}