//Daniel Fishel
//df0450748@swccd.edu
//0450748

import java.util.NoSuchElementException;


public class ringBuffer implements ringBufferInterface{

	
	private Double[] queue;
	private int first, last, size, maxCapacity;
		

	public ringBuffer(int Capacity){
		this.maxCapacity = Capacity;
		queue = new Double [Capacity + 1];
			first = 0;
			last = 0;
			size = 0;
			
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		
		return (size == 0);
		
	}
	
	public boolean isFull() {
		return (size() == this.maxCapacity);
	}
	
	public void enqueue(double item) {
		if ( isFull() ) {
			throw new NoSuchElementException(" Queue is Full!") ;
		}
		queue[last++] = item; 
		last = last % queue.length;
		size++;
		
	}
	
	public double dequeue() {
		if ( isEmpty() ) { 
			throw new NoSuchElementException(" Queue is Empty!"); 
		}
		first = first % queue.length;
		double data = queue[first]; // item to return
		queue[first++] = null;
		size--; 
		return data;
		
	}
		
	public double peek() {
		if (isEmpty()) { 
			throw new NoSuchElementException( "Queue underflow" );
		}
		first = first % queue.length;    
		return queue[first];
	}
	
	
	}

