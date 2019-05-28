
/*	Daniel Fishel
 *  df0450748@swccd.edu
    0450748	
*/

public class GuitarString implements StringringBufferInterface{
	
	public double frequency;
	public int Note;
	public int tics;
	public ringBuffer guitarStringN;
	
	GuitarString(double frequency) {
		Note = (int) ( Math.ceil(44100 / frequency));
		guitarStringN = new ringBuffer( Note );
		for(int i = 0; i < Note - 1; i++)
			guitarStringN.enqueue(0);
			tics = 0;
				
	}
	
	public GuitarString(double[] init) {
		
		ringBuffer guitarStringNote = new ringBuffer(init.length);
		
	}
	
	public void pluck() {
		for (int i = 0; i < this.Note; i++) 
		{
		
		double rand = Math.random() - 0.5;
	
		guitarStringN.dequeue();
		guitarStringN.enqueue( rand );
		}

	}
	
	public void tic() {
		
		guitarStringN.enqueue(  (guitarStringN.dequeue() + guitarStringN.peek() ) * 0.5 * .994);
		tics++;
	}
	
	public double sample() {
		
		return guitarStringN.peek();
		
	}
	
	public int time() {
		
		return tics;
	}

}
