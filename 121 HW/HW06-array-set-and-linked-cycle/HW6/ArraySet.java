package HW6;

/**
 * 
 * @author Guoguo Lu <guoguol>
 * @section AAA
 */

public class ArraySet<E extends Comparable<? super E>> {
	// leave these fields public so that we can test your code
	public E[] data;
	public int numElements;

	/**
	 * The constructor creates a new Generic Array and ensures each
	 * Object in the array is of the same type.
	 */
	@SuppressWarnings("unchecked")
	public ArraySet() {
		data = (E[])new Comparable<?>[2];
		numElements = 0;
	}

	/**
	 * This method returns the total number of elements that are 
	 * current in the ArraySet.
	 */
	public int size() {
		return numElements;
	}

	/**
	 * This method adds an object to the ArraySet if and only if 
	 * the item is not already contained in the set. If necessary, this 
	 * method will (delegate) the doubling of the size of the array.
	 * 
	 * When inserting, all values must be inserted in ascending order
	 * 
	 * If adding was successful, this method should return true. If not, 
	 * or if the item was already in the list, this method should return false.
	 */
	public boolean add(E item) {
		if(numElements == 0){
			data[0]=item;
			numElements++;
			return true;
		}
		
		if(contains(item)){
			return false;
		}

		if(data.length == numElements){
			doubleArray();
			System.out.println("Doubling array to length "+data.length);
		}
		
		numElements++;
		data[numElements-1]=item;
		//System.out.println(this+" add item to the end for now");
		int i=0;
		while(i<numElements){
			if(data[i].compareTo(item)>0){  //Insert at data[i]
				for(int j=numElements-1; j>i; j--){ //After move everyone after one place behind
					//System.out.println("Current j:"+j+"   data[j-1]:"+data[j-1]);
					data[j]=data[j-1];
				}
				data[i]=item;
				break;
			}
			i++;
		}
		System.out.println(this);
		return true;
		
	}

	/**
	 * The contains method determines if a given value exists in the ArraySet. 
	 * It must run in O(log n) time.
	 */
	public boolean contains(E item) {
		
		int start=0;
		int end=numElements-1;
		
		while(start<end){
			if(data[start].equals(item) || data[end].equals(item)){
				System.out.println("Item already included:"+item);
				return true;
			}
			int mid=(start+end)/2;
			//System.out.println("mid="+mid+" s="+start+" e="+end);
			
			if(data[mid].compareTo(item)>0){
				//System.out.println("data[mid]="+data[mid]+" item="+item+" set end="+(mid-1));
				end=mid-1;
			}else if(data[mid].compareTo(item)<0){
				//System.out.println("data[mid]="+data[mid]+" item="+item+" set start="+(mid+1));
				start=mid+1;
			}else{
				System.out.println("Item already included:"+item);
				return true;
			}
		}
		//System.out.println("Item not included:"+item);
		return false; 
	}

	/**
	 * The remove method behaves opposite of the add method. It will remove a value 
	 * from the ArraySet if and only if the value exists in the ArraySet. 
	 * 
	 * This method should NOT decrease the size of the Array!
	 * 
	 * If removal was successful, this method should return true. Otherwise, false.
	 */
	public boolean remove(E item) {
		if(!contains(item))	return false;
			
		for(int i=0; i<numElements; i++){
			if(data[i].equals(item)){				
				for(int j=i; j<numElements; j++){
					data[j]=data[j+1];
				}
				numElements--;
				break;
			}
		}
		System.out.println(this);
		return true; //remove this line when you are done
	}

	// DO NOT TOUCH THIS METHOD
	// THIS IS PROVIDED FOR YOUR DEBUGGING
	public String toString() {
		String s = "[";
		for (int i = 0; i < numElements - 1; i++)
			s += data[i] + ", ";
		if (numElements > 0)
			s += data[numElements - 1];
		return s + "]";
	}
	
	/**
	 * This method doubles the size of the array. You should 
	 * consider using it in your code...
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	private void doubleArray() {
		E[] bigger = (E[])new Comparable<?>[2 * data.length];
		for(int i = 0; i < data.length; i++)
			bigger[i] = data[i];
		data = bigger;
	}
}