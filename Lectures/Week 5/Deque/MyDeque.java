/* MyDeque.java */

/**
 *  MyDeque is a class for deque implemented by circular array.  
 *  
 *  @author Maryam Siahbani
 **/

import java.util.NoSuchElementException;

public class MyDeque {

	private static int INITSIZE = 1000;  // initial array size
    private Object[] items; // array to keep items in the deque
    private int size;   // the number of items in the deque
    private int rearIndex;  
    private int frontIndex;
    
    /**
	 *  MyDeque() constructs an empty deque.
	 **/

	public MyDeque() {
		items = new Object[INITSIZE];
		size = 0;	
		frontIndex = 0;
		rearIndex = 0;   //initialize the rearIndex to 0 (unlike in Queue)
						  // rearIndex always refer to index that we can 
						  // inject the next item
	}

	/**
	 * isEmpty() indicates whether the deque is empty.
	 *  @return true if the deque is empty, false otherwise.
	 **/
	public boolean isEmpty() {
		return size == 0;
	}
	 
	/**
	 *  length() returns the number of items in this deque.
	 *  @return the length of this deque.
	 **/

	public int length() {
	    return size;
	}

	/**
	 *  inject() inserts item "obj" to the rear of deque.
	 *  @param obj the item to be inject to deque.
	 **/
	public void inject(Object obj) {
		// check for full array and expand if necessary
	    if (items.length == size) {
	       expandArray();
	    }
	    // use auxiliary method to increment rear index with wrap-around
	    rearIndex = incrementIndex(rearIndex);

	  // insert new item at rear of deque
	    items[rearIndex] = obj;
	    size++;
	}
	
	/**
	 *  expandArray() create a new array with larger size (twice)
	 *  make sure you update all class fields that should be updated!
	 */
	private void expandArray() {
		int i, j;
		INITSIZE *= 2;
		
		// temporary array 
		Object[] new_items = new Object[INITSIZE];
		
		// copy all the items in the deque (the first one is in index frontIndex)
		// to the new array (this is a new array we can put the items starting from 
		// index 0
        i = frontIndex;
        j = 0;
        while (j<size) {
        	new_items[j] = items[i];
        	j++;
        	i = incrementIndex(i);  // we need to use incrementIndex to iterate through the deque
        }
        
        // update the frontIndex and rearIndex 
        frontIndex = 0;
        rearIndex = j-1;
        items = new_items;
    }
	
	/**
	 *  incrementIndex() is an auxiliary method to increment 
	 *  the rear index while maintain the circular array
	 *  so if we have reached to the end of array, the index 
	 *  should be reset to 0!
	 *  
	 *  @param index the rear index to be increased
	 **/
	private int incrementIndex(int index) {
	    if (index == items.length-1) return 0;
	    else return index + 1;
	}

	/**
	 *  pop() removes and returns an item from the front of deque.
	 *  
	 *  @return an obj which is the item on front of the deque.
	 **/
	public Object pop() {
		// check if the queue is empty 
		if (size == 0) throw new NoSuchElementException("Queue underflow"); 
	  	
	    // use auxiliary method to increment front index with wrap-around
	  	// so that front index refer to the correct index after removing
	  	// the object
	    frontIndex = incrementIndex(frontIndex);
	    
	    Object obj = items[frontIndex];
	    size--;
	    return obj;
	}

	/**
	 *  eject() removes and returns an item from the rear of deque.
	 *  
	 *  @return an obj which is the item on rear of the deque.
	 **/
	public Object eject() {
		// check if the queue is empty 
		if (size == 0) throw new NoSuchElementException("Queue underflow"); 

		Object obj = items[rearIndex];
	  	
	    // use auxiliary method to increment front index with wrap-around
	  	// so that front index refer to the correct index after removing
	  	// the object
	    rearIndex = decrementIndex(rearIndex);
	    size--;
	    return obj;
	}
	
	/**
	 *  decrementIndex() is an auxiliary method to decrement 
	 *  the rear index while maintain the circular array
	 *  so if we have reached to the index 0 of array, the index 
	 *  should be reset to length-1!
	 *  
	 *  @param index the rear index to be increased
	 **/
	private int decrementIndex(int index) {
	    if (index == 0) return items.length-1;
	    else return index - 1;
	}
	
	/**
	 *  push() inserts item "obj" to the front of deque.
	 *  @param obj the item to be pushed to deque.
	 **/
	public void push(Object obj) {
		// check for full array and expand if necessary
	    if (items.length == size) {
	       expandArray();
	    }

	    // insert new item at front of deque
		items[frontIndex] = obj;
	    // use auxiliary method to decrement front index with wrap-around
	    frontIndex = decrementIndex(frontIndex);

	    size++;
	}

	
	/**
	 *  front() returns the item least recently added to this deque.
     *
     * @return the item least recently added to this deque
     * @throws NoSuchElementException if this deque is empty
	 **/

	public Object front() throws NoSuchElementException {
	    if (size == 0) throw new NoSuchElementException("Queue underflow");  
	    return items[frontIndex];   //constant time because it is always the first item
	}
	
	/**
	 *  toString() converts the deque to a String.
	 *  @return a String representation of the deque.
	 **/
	public String toString() {
		if (size == 0) return "[  ]";
		int i;
		Object obj;
		String result = "[  ";
		  
        i = this.incrementIndex(frontIndex);
        int j = 0;
        while (j < size) {
        	obj = items[i];
            result = result + obj + "  ";
        	i = this.incrementIndex(i);
        	j++;
        } 
        
        result = result + "]";
        return result;
	}
	
	/**
	 *  main() runs test cases on the MyDeque class.  Prints summary
     *  information on basic operations and halts with an error (and a
	 *  trace) if any of the tests fail.
     **/

	  public static void main (String[] args) {
		
	    //test();
	    //testExpandArray();
	  }
	    
}
