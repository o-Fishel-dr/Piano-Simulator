
/*
 *  Daniel Fishel   
 *  df0450748@swccd.edu
 *  0450748
 */


public class GuitarHero {
	  
	
	  
	public static void main(String[] args) {
		
		String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
		GuitarString[] piano;
		piano = new GuitarString[37];
		for (int i = 0; i < 37; i++) {
			piano[i] = new GuitarString(440 * Math.pow (1.05956, (i - 24) ));
		}
		
	    while (true) {

	            // check if the user has typed a key, and, if so, process it
	            if (StdDraw.hasNextKeyTyped()) {
	 
	                // the user types this character
	                char key = StdDraw.nextKeyTyped();

	                // pluck the corresponding string
	                if (!(keyboard.indexOf(key) == -1)) { 
	                	piano[keyboard.indexOf(key)].pluck(); 
	                }
	            }
	            // compute the superposition of the samples
	            double sample = 0.5;
	            for (int i = 0;i < 37; i++) {
	            	double guitarStringsample = sample;
	            	sample = guitarStringsample + piano[i].sample();
	            }

	            // send the result to standard audio
	            StdAudio.play(sample);
	            
	            // advance the simulation of each guitar string by one step
	            for (int i = 0 ; i < 37; i++) {
	            	piano[i].tic();
	            }
	           
	            
	        }
	   }

	}


