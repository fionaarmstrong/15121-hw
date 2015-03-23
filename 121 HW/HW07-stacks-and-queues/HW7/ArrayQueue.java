package HW7;

/**
 * 
 * @author Guoguo Lu <guoguol>
 * @section AAA
 */

import java.util.*;

public class ArrayQueue<E> implements MyQueue<E> {

	private E[] dataArray;
	private int front; //index of first item to remove
	private int back;  //index of last item to remove
	private int numOfElements; // for convenience

	@SuppressWarnings("unchecked")
	public ArrayQueue() {
		front=-1;
		back=-1;
		dataArray = (E[]) new Object[2];
		numOfElements=0;
	}

	/**
	 * Returns true if this queue no elements.
	 * 
	 * @return true if this queue is empty, false otherwise.
	 * 
	 */
	public boolean isEmpty() {
		return (numOfElements==0)?true:false;
	}
	
	

	/**
	 * Returns, but does not remove, the element at the front of this queue.
	 * 
	 * @return The element at the front of this queue.
	 * @throws NoSuchElementException
	 *           if the queue is empty.
	 *           
	 */
	public E peek() {
		if(numOfElements==0) throw new NoSuchElementException();
		return dataArray[front];
	}
	
	
	/**
	 * Adds the specified element to the back of this queue.
	 * 
	 * @param element
	 *          to add on to the back of this queue.
	 *          
	 */
	public void enqueue(E element) {
		if(numOfElements==0){
			dataArray[++back]=element;
			front++;
			numOfElements++;
			//System.out.println("Adding first element "+element+" current numOfE:"+numOfElements+" front:"+front+" back:"+back +"  Array Size:"+dataArray.length);
			return;
		}
		if(back+1==dataArray.length){
			E[] newArray = (E[]) new Object[numOfElements*2];
			for(int i=0; i<numOfElements; i++){
				newArray[i]=dataArray[front+i];
			}
			dataArray=newArray;
			front=0;
			back=front+numOfElements-1;
		}
		numOfElements++;
		dataArray[++back] = element;
		//System.out.println("Adding element "+element+" current numOfE:"+numOfElements+" front:"+front+" back:"+back+"  Array Size:"+dataArray.length);
	}
	
	

	/**
	 * Removes and returns the element at the front of this queue.
	 * 
	 * @return The element removed from the front of this queue.
	 * @throws NoSuchElementException
	 *           if the queue is empty.
	 *           
	 */
	public E dequeue() {
		if(front==-1) throw new NoSuchElementException();
		if(front==back){
			int temp=front;
			front=-1;
			back=-1;
			numOfElements=0;
			//System.out.println("Dequeued last element "+dataArray[temp]+" current numOfE:"+numOfElements+" front:"+front+" back:"+back);
			return dataArray[temp];
		}
		numOfElements--;
		
		//System.out.println("Dequeued element "+dataArray[front]+" current numOfE:"+numOfElements+" front:"+(front+1)+" back:"+back);
		return dataArray[front++];
	}


	/**
	 * Returns a String representation of this queue in the format described in
	 * the writeup
	 * 
	 */
	public String toString() {
		if(numOfElements==0) return "[ ]";
		StringBuffer dataString = new StringBuffer("[ ");
		for(int i=front; i<=back; i++){
			dataString.append(dataArray[i]+" ");
		}
		dataString.append("]");//       " + "numOfElements:"+numOfElements);
		return dataString.toString();
	}

}
