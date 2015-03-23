/**
 *
 * @author Minglun Gu <mgu>
 * @section A
 */


import java.util.ArrayList;

public class mgu {

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
	  if (head == null) {
		  return 0;
	  } else {
		  Node nodeRef = head;
		  if (nodeRef.next == null) {
			  if (nodeRef.data.equals(findData)) {
				  return 1;
			  }
			  return 0;
		  } else {
			  if (nodeRef.data.equals(findData)) {
				  return count(nodeRef.next,findData) + 1;
			  }
			  return count(nodeRef.next,findData);
		  }
	  }
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
	  if (string1.length() != string2.length()) {
		  return false;
	  } else if (string1.length() == 0) {
		  return true;
	  } else {
		  if (1 == string1.length()) {
			  return string1.equals(string2);
		  } else if (2 == string1.length()) {
			  return (string1.charAt(0) == string2.charAt(1)) &&
					  (string1.charAt(1) == string2.charAt(0));
		  } else {
			  if (string1.charAt(0) != string2.charAt(string2.length()-1)) {
				  return false;
			  } else {
				  String newString1 = string1.substring(1,string1.length()-1) + string1.charAt(string1.length()-1);
				  String newString2 = string2.substring(0,string2.length()-1);
				  return isReverse(newString1, newString2);
			  }
		  }
	  }
  }

  public static int countStrings(Integer n) {
	  if (n == 1) {
		  return 3;
	  } else if (n == 2) {
		  return 8;
	  } else {
		  return countStrings((Integer)(n-1)) * 3 - 
				  (countStrings((Integer)(n-1)) - countStrings((Integer)(n-2)) * 2);
	  }
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
	  if (head == null) {
		  return;
	  } else {
		  Node nodeRef = head;
		  if (nodeRef.data.equals(findData)) {
			  Node node = new Node(insertData);
			  node.next = nodeRef.next;
			  nodeRef.next = node;
			  return;
		  } else {
			  insertAfter(nodeRef.next, insertData, findData);
		  }
	  }
  }

  /**
   * The itAddsUp method returns true if all the elements in the ArrayList
   *  list add up (sum) to the specified target
   */
  public static boolean itAddsUp(ArrayList<Integer> list, Integer target) {
	  if (list.size() == 0) {
		  return false;
	  } else if(list.size() == 1) {
		  return target - list.get(0) == 0;
	  } else {
		  Integer element = list.remove(list.size()-1);
		  return itAddsUp(list, Integer.valueOf(target-element));
	  }
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
	  if (string.length() < 2) {
		  return string;
	  } else if (string.length() == 2) {
		  if (string.charAt(0) == string.charAt(1)) {
			  return string.substring(0,1);
		  } else {
			  return string;
		  }
	  } else {
		  if (string.charAt(0) == string.charAt(1)) {
			  string = string.substring(0,1) 
					  + string.substring(2,string.length()-1) 
					  + string.charAt(string.length()-1);
			  return removeDuplicates(string);
		  } else {
			  String newString = string.substring(1,string.length()-1) 
					  + string.charAt(string.length()-1);
			  return string.substring(0,1) + removeDuplicates(newString);
		  }
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
	  if (n == 1) {
		  return "" + n;
	  } else {
		  if (n%2 == 1) {
			  return "" + stringNumbers(n-1) + "-" + n%(n+1); 
		  } else {
			  return "" + n%(n+1) + "-" + stringNumbers(n-1);
		  }
	  }
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
	  if (list.size() < 2) {
		  // do nothing
	  } else if (list.size() == 2) {
		  if (list.get(0).length() < list.get(1).length()) {
			  list.remove(1); 
		  } else {
			  list.remove(0);
		  }
	  } else if (list.size()%2 == 1) {
		  String lastE = list.get(list.size()-1);
		  list.remove(list.size()-1);
		  removeLongerOfPairs(list);
		  list.add(lastE);
	  } else {
		  if (list.get(list.size()-2).length() < list.get(list.size()-1).length()) {
			  list.remove(list.size()-1); 
		  } else {
			  list.remove(list.size()-2);
		  }
		  removeLongerOfPairs(list);
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
	  if (head == null) {
		  return head;
	  } else if (head != null && head.next == null) {
		  if (head.data.length() == length) {
			  return head = null;
		  } else {
			  return head;
		  } 
	  } else {
			  if (head.data.length() == length) {
				  head = head.next;
				  return removeAll(head, length);
			  } else {
				  Node nodeRef = head.next;
				  nodeRef = removeAll(nodeRef, length);
				  head.next = nodeRef;
				  return head;
			  }
		}
  }

  /**
   * Use the main method to write your tests
   */
  public static void main(String args[]) {		
	  
	    assert(Recursion.count(null, "foo") == 0);

  }
}