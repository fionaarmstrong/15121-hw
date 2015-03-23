package HW6;

/**
 * 
 * @author Guoguo Lu <guoguol>
 * @section AAA
 */



import java.util.*;

public class LinkedCycle<E> {
	// DO NOT CHANGE THESE FIELDS
	public Node<E> currNode;
	public int numElements;

	public LinkedCycle() {
		currNode = null;
		numElements = 0;
	}

	public int size() {
		return numElements;
	}

	public E get() {
		if(currNode!=null)
			return currNode.data;
		else throw new NoSuchElementException(); //remove this line when you are done
	}

	public void add(E item) {
		Node<E> newNode = new Node<E>(item);
		if(currNode == null){ //When the list is blank
			currNode = newNode;
		}
		else if(currNode.next == null){ //When there's one one node
			currNode.next=newNode;
			currNode.prev=newNode;
			newNode.next=currNode;
			newNode.prev=currNode;
			currNode=newNode;
		}
		else{
			newNode.next=currNode.next;
			newNode.prev=currNode;
			currNode.next.prev=newNode;
			currNode.next=newNode;
			currNode=newNode;
		}
		numElements++;
	}

	public List<E> toList() {
		List<E> newList = new ArrayList<E>();
		if(currNode==null)
			return newList;
		else if(currNode.next==null){
			newList.add(currNode.data);
			return newList;
		}
		Node<E> ptr = currNode;
		do{
			newList.add(ptr.data);
			//System.out.println("Just add:"+ptr.data);
			ptr=ptr.next;
		}while(ptr!=currNode);
		
		return newList; //remove this line when you are done
	}

	public boolean contains(E item) {
		if(currNode==null)
			return false;
		else if(currNode.next==null){
			if(currNode.data.equals(item)) return true;
			else return false;
		}
		Node<E> ptr = currNode;
		do{
			if(ptr.data.equals(item))
				return true;
			ptr=ptr.next;
		}while(ptr!=currNode);
		return false; //remove this line when you are done
	}

	public void scroll(Integer n) {
		if(currNode==null || currNode.next==null) return;
		for(int i=0; i<n; i++)
			currNode=currNode.prev;
	}

	public E remove() {
		E nodeData;
		
		if(currNode==null) return null;
		
		else if(currNode.next==null){
			nodeData=currNode.data;
			currNode=null;
		}
		
		else{
			nodeData=currNode.data;
			currNode.next.prev=currNode.prev;
			currNode.prev.next=currNode.next;
			currNode=currNode.next;
		}
		return nodeData; //remove this line when you are done
	}
}