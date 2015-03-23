package HW7;

/**
 * 
 * @author Guoguo Lu <guoguol>
 * @section AAA
 */
import java.util.*;

public class TwoStackQueue<E> implements MyQueue<E> {

	private MyStack<E> out;
	private MyStack<E> in;

	public TwoStackQueue() {
		out = new ArrayStack<E>();
		in = new ArrayStack<E>();
	}

	/**
	 * Returns true if this queue no elements.
	 * 
	 * @return true if this queue is empty, false otherwise.
	 * 
	 */
	public boolean isEmpty() {
		if(in.isEmpty()&&out.isEmpty())
			return true;
		else return false;
	}

	/**
	 * Adds the specified element to the end of the queue.
	 * 
	 * @param The
	 *          element to add on to the end of the queue.
	 *          
	 */
	public void enqueue(E element) {
		while(!out.isEmpty()){
			in.push(out.pop());
		}
		in.push(element);
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
		while(!in.isEmpty()){
			out.push(in.pop());
		}
		return out.pop();
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
		if(in.isEmpty()&&out.isEmpty()) throw new NoSuchElementException();
		while(!in.isEmpty()){
			out.push(in.pop());
		}
		return out.peek();
	}

	/**
	 * Returns a String representation of this queue. If the queue will dequeue
	 * values 5 7 8 in that order, and the out stack contains one value, the
	 * string will have following format.
	 * 
	 * front [ 5 | 7 8 ] back
	 * 
	 */
	public String toString() {
		StringBuffer dataString = new StringBuffer("[ ");
		while(!in.isEmpty())
			out.push(in.pop());
		while(!out.isEmpty()){
			dataString.append(out.peek().toString()+" ");
			in.push(out.pop());
		}
		dataString.append("]");
		return dataString.toString();
	}

}
