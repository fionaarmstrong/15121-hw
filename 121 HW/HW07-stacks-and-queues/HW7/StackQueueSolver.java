package HW7;

/**
 * 
 * @author Guoguo Lu <guoguol>
 * @section AAA
 */

public class StackQueueSolver {

	public static int lastCustomer(int numPersons, int numToBack) {
		//write your code for the lastCustomer method here
		return -1; // remove this line when you are done
	}

	// Runtime O(n)
	public static boolean areEqual(MyStack<String> stack1, MyStack<String> stack2) {
		MyStack<String> stack = new ArrayStack<String>();
		if(stack1.isEmpty() && stack2.isEmpty()) return true;
		else if(stack1.isEmpty() || stack2.isEmpty()) return false;
		while(!stack1.isEmpty() && !stack2.isEmpty() &&
				stack1.peek()==stack2.peek()){
			stack.push(stack1.pop());
			stack2.pop();
		}
		if(stack1.isEmpty() && stack2.isEmpty()){
			while(!stack.isEmpty()){
				stack1.push(stack.peek());
				stack2.push(stack.pop());
			}
			
			return true;
		}
		else{
			while(!stack.isEmpty()){
				stack1.push(stack.peek());
				stack2.push(stack.pop());
			}
			return false;
		}
		
	}

	// Runtime O(n)
	public static MyStack<Integer> duplicateStack(MyStack<Integer> original) {
		ArrayStack<Integer> dupe = new ArrayStack<Integer>();
		ArrayStack<Integer> copy = new ArrayStack<Integer>();
		while(!original.isEmpty()){
			copy.push(original.pop());
		}
		while(!copy.isEmpty()){
			dupe.push(copy.peek());
			original.push(copy.pop());
		}
		return dupe;
	}

	public static void main(String[] args) {
		//TwoStackQueue<String> tester = new TwoStackQueue<String>();
		//tester.push("a");
		//tester.push("b");
		//tester.push("c");
		
		//System.out.println(tester.pop());
		//System.out.println(tester.pop());
		//System.out.println(tester.pop());
		/*for(int i=0; i<8; i++)
			tester.enqueue(Integer.valueOf(i).toString());
		System.out.println(tester.toString());
		for(int i=0; i<6; i++)
			tester.dequeue();
		System.out.println(tester.toString());
		for(int i=8; i<15; i++)
			tester.enqueue(Integer.valueOf(i).toString());
		System.out.println(tester.toString());
		*/
		//System.out.println("Empty? "+tester.isEmpty());
		//System.out.println("Peek: "+tester.peek());
		/*StackQueueSolver solver = new StackQueueSolver();
		ArrayStack<String> s1 = new ArrayStack<String>();
		ArrayStack<String> s2 = new ArrayStack<String>();
		s1.push("123");
		s2.push("123");
		s1.push("123");
		s2.push("123");
		s1.push("111");
		s2.push("111");
		System.out.println(solver.areEqual(s1, s2));*/
		
		/*StackQueueSolver solver = new StackQueueSolver();
		ArrayStack<Integer> org = new ArrayStack<Integer>();
		for(int i=0; i<300; i++){
			org.push(Integer.valueOf(i));
		}
		System.out.println(org.toString());
		System.out.println(solver.duplicateStack(org).toString());*/
	}

}