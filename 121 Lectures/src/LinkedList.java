/**
 * 
 * @author Guoguo Lu <guoguol>
 * @section AAA
 */

// YOU MAY NOT IMPORT ANY ADDITIONAL
// CLASSES OR PACKAGES

import java.util.ArrayList;

public class LinkedList {

	private int numElements;
	public Node head;
	
	public LinkedList() {
		numElements = 0;
		head = null;
	}
	
	/**
	 * The add method takes one String parameter, creates a Node
	 *   from that String, and inserts the Node at the beginning
	 *   of the LinkedList
	 */
	public void add(String newData) {
		// DO NOT CHANGE THIS METHOD
		Node node = new Node(newData);
		node.next = head;
		head = node;
		numElements++;
	}
	
	/**
	 * The size method returns the number of elements in the
	 *   LinkedList in O(1) time
	 */
	public int size() {
		// DO NOT CHANGE THIS METHOD
		return numElements;
	}
	
	/**
	 * The concatenate method combines all the Nodes in the list
	 * 	 into a single String. DO NOT USE A SEPARATOR BETWEEN NODES
	 */
	public String concatenate() {
		Node pt = head;
		StringBuffer sb= new StringBuffer();
		while(pt.next!=null){
			sb.append(pt.data);
			pt=pt.next;
		}
		return sb.toString();
	}
	
	/**
	 * The insertAfter method searches through the LinkedList looking
	 *   for Nodes whose data (String) matches the findData parameter.
	 *   It then creates a new Node and inserts the newly created node
	 *   AFTER the FIRST occurrence of findData
	 * 
	 * If there are multiple occurrences of findData, ONLY THE CLOSEST
	 *   TO THE FRONT will be used
	 * 
	 * If there are no occurrences of findData, the LinkedList should
	 *   remain unchanged
	 */
	public void insertAfter(String insertData, String findData) {
		Node pt = head;
		while(pt!=null){
			if(pt.data==findData){
				Node newNode = new Node(insertData);
				newNode.next=pt.next;
				pt.next=newNode;
				numElements++;
				pt=null;
			}
			pt=pt.next;
		}
	}
	
	/**
	 * Similar to insertAfter, the insertAt method loops through the
	 *   LinkedList to the specified index and inserts AFTER the node
	 *   at that index.
	 * 
	 * If the index is greater than the number of nodes in the list, 
	 *   this method should do nothing
	 * 
	 * You may assume that index is a positive whole number
	 * 
	 * Remember that in Computer Science, we begin counting from 0
	 */
	public void insertAt(String insertData, int index) {
		if(index<0) return;
		Node pt = head;
		while(pt!=null){
			if(index--==0){
				Node newNode = new Node(insertData);
				newNode.next=pt.next;
				pt.next=newNode;
				numElements++;
				pt=null;
			}
			pt=pt.next;
		}
	}
	
	/**
	 * The buildList method constructs a LinkedList from the given
	 *   ArrayList. The LinkedList's data MUST BE IN THE SAME ORDER
	 *   AS THE ORIGINAL ArrayList
	 * 
	 * You must use the add method defined for this Class.
	 */
	public void buildList(ArrayList<String> arrayList) {
		for(int i=arrayList.size()-1; i>=0; i--){
			add(arrayList.get(i).toString());
		}
	}
	
	/**
	 * The equals method is a very important method in Java. Here, 
	 *   you will be constructing your own equals method. Two
	 *   LinkedLists are considered "equal" if they contain all the
	 *   same nodes, in the same order
	 * 
	 * Method stubs have been provided to help you code this method.
	 *   YOU MUST USE THE ALGORITHMS/PROCESSES DESCRIBED IN THE STUBS
	 *   OR YOU WILL RECEIVE A 0
	 */
	public boolean equals(LinkedList otherList) {
		// compare the sizes of the two lists using the .size() method
		// (if two lists aren't the same size, can they be equal?)
		if(otherList.size()!=numElements)
			return false;
		// loop over each Node in each list simultaneously (because you
		// know the lists are the same size at this point, you don't need
		// to worry about NullPointerExceptions). If two Nodes are
		// different (their data is not equal), this method should
		// immediately return false
		Node pt = head;
		Node pt2 = otherList.head;
		for(int i=0; i<otherList.numElements; i++){
			if(pt.data!=pt2.data)
				return false;
			pt=pt.next;
			pt2=pt2.next;
		}
		return true;
	}
	
	/**
	 * Complete the bringToFront method which takes an index as a parameter.
	 *   The Node at that index is moved to the front (made the first item)
	 *   in the LinkedList. The rest of the Nodes should remain in their
	 *   same relative position
	 *   
	 * If the given index is larger than the number of Nodes in the
	 *   LinkedList, this method should do nothing.
	 */
	public void bringToFront(int index) {
		if(index>numElements||index<0)
			return;
		Node pt=head;
		int i=0;
		while(i<index-1){
			pt=pt.next;
			i++;
		}
		Node newNode = pt.next;
		pt.next=pt.next.next;
		newNode.next=head;
		head=newNode;
			
	}
	
	/**
	 * The makeCircular method points the last item in the LinkedList to
	 *   the HEAD of the LinkedList, making it circular
	 */
	public void makeCircular() {
		Node pt=head;
		for(int i=0; i<numElements-1; i++)
			pt=pt.next;
		pt.next=head;
	}
	
	/**
	 * The removeAll method removes all Nodes from the LinkedList whose 
	 *   String length (data) is exactly equal to the length parameter
	 * 
	 * If more than one occurrence of a String of length exist in the 
	 *   LinkedList, ALL OCCURRENCES SHOULD BE REMOVED
	 * 
	 * If no Strings of length exist, THE LINKED LIST SHOULD REMAIN
	 *   UNCHANGED
	 */
	public void removeAll(int length) {
		Node pt=head;
		while(pt!=null){
			if(pt.data.length()==length){
				while(pt!=null){
					Node pt1=pt;
					pt=pt.next;
					pt1.next=null;
					numElements--;
				}
			}
			pt=pt.next;
		}
	}
	
	/**
	 * The alphabetize method alphabetizes (0-9-A-Z) the order of the Nodes in 
	 *   the LinkedList IN PLACE. YOU MAY NOT CREATE ANY NEW LISTS!
	 */
	public void alphabetize() {
		Node pt1=new Node("");
		pt1.next=head;
		Node pt2=pt1.next;
		while(pt1.next!=null){
			pt2=pt1.next;
			while(pt2.next!=null){
				if(pt1.next.data.charAt(0)>pt2.next.data.charAt(0)){
					String temp=pt1.next.data;
					pt1.next.data=pt2.next.data;
					pt2.next.data=temp;

				}
				pt2=pt2.next;
			}
			pt1=pt1.next;
		}
	}
	
	
	/**
	 * The reverse method reverses the order of all the Nodes in the LinkedList
	 *   IN PLACE! YOU MAY NOT CREATE ANY NEW LISTS!
	 */
	public void reverse() {
		Node pt1=head;
		Node pt2=head;
		System.out.println("pt1:"+pt1.data+"   pt2:"+pt2.data);
		for(int i=0; i<numElements/2; i++){
			for(int j=0; j<numElements-i-1; j++)
				pt2=pt2.next;
			for(int k=0; k<i; k++){
				pt1=pt1.next;
				System.out.println("k="+k);
			}
			System.out.println("SB");
			String temp=pt1.data;
			pt1.data=pt2.data;
			pt2.data=temp;
			pt1=head;
			pt2=head;
		}
	}
	
	/**
	 * Pretty print LinkedLists
	 */
	public String toString() {
		// DO NOT MODIFY THIS METHOD
		StringBuffer sb = new StringBuffer();
		
		if(head == null) {
			sb.append("[HEAD] -> null -> [TAIL]");
		} else {
			Node nodeRef = head;
			sb.append("[HEAD] -> ");
			while(nodeRef != null) {
				sb.append(nodeRef.data);
				sb.append(" -> ");
				nodeRef = nodeRef.next;
			}
			sb.append("[TAIL]");
		}
		
		return sb.toString();
	}
}