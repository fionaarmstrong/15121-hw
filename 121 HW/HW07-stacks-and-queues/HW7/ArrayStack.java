package HW7;

/**
 * 
 * @author Guoguo Lu <guoguol>
 * @section AAA
 */
import java.util.*;

public class ArrayStack<E> implements MyStack<E> {

	private E[] dataArray;
	private int top;

	/**
	 * Creates an empty stack.
	 * 
	 */
	public ArrayStack() {
		top=-1;
		dataArray = (E[]) new Object[2];
	}

	/**
	 * Determines if the stack is empty or not.
	 * 
	 * @return true if the stack is empty or false otherwise
	 * 
	 */
	public boolean isEmpty() {
		return (top==-1)?true:false; 
	}
	
	/**
	 * Returns but does not remove the top element of the stack if the stack is
	 * not empty.
	 * 
	 * @return The top element of the stack
	 * @throws NoSuchElementException
	 *           if the stack is empty
	 *           
	 */
	public E peek() {
		if(top!=-1)
			return dataArray[top];
		else
			throw new NoSuchElementException();
	}
	

	/**
	 * Pushes the given element on this stack
	 * 
	 * @param element
	 *          The element of type E to push on the stack.
	 *          
	 */
	public void push(E element) {
		if(top==dataArray.length-1){
			E[] newArray = (E[]) new Object[2*dataArray.length];
			for(int i=0; i<=top; i++){
				newArray[i] = dataArray[i];
			}
			dataArray=newArray;
			//System.out.println("Incremented array length to "+ dataArray.length);
		}
		dataArray[++top]=element;
		//System.out.println("Pushed "+element+"   At Top="+top+"   "+this.toString());
	}

	

	/**
	 * Returns and removes the top element of the stack if the stack is not empty.
	 * 
	 * @return The top element of the stack
	 * @throws NoSuchElementException
	 *           if the stack is empty
	 *           
	 */
	public E pop() {
		if(top==-1) throw new NoSuchElementException();
		//System.out.println("Top="+top+", peek: "+peek());
		return dataArray[top--];
	}

	/**
	 * Returns a String representation of the stack in the following format top [
	 * 3 5 ] bottom
	 * 
	 */
	public String toString() {
		StringBuffer dataString = new StringBuffer("[ ");
		
		for(int i=0; i<=top; i++)
			dataString.append(dataArray[i].toString()+" ");
		dataString.append("]");
		return dataString.toString();
	}

}
