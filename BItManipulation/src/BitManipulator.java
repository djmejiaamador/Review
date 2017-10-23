import java.math.*;
public class BitManipulator {
	
	public BitManipulator() {}
	
	/**
	 * return the ith of number provided. Does this by
	 * taking the num AND (1 << i) 
	 * @param num: number entered
	 * @param i: index of bit to return
	 * @return
	 */
	public static boolean getBit(int num, int i){
		return (num & (1 << i )) != 0;
	}
	
	/**
	 * changes the ith of provided number ( flips the 
	 * value of ith bit  by ORinf it
	 * @param num: number entered.
	 * @param i: index of bit to change
	 */
	public static int setBit(int num, int i){
		return (num | (i<<i)); 
	}
	
	/**
	 * Clears the ith bit of provided num
	 * @param num
	 * @param i
	 * @return a number after num's  ith bit was cleared. 
	 */
	public static int clearBit(int num, int i){
		//Frirst create the mask to isolate which bit
		//you want to clear.
		int mask = 	~ (1 << i);
		return (num & mask);
	}
	
	/**
	 * Clears the all bits from MSB (most significant bit to ith bit
	 * @param num
	 * @param i
	 * @return a number after num's  ith bit was cleared. 
	 */
	public static int clearMSBtoI(int num, int i){
		/*-1 is equal to a sequence of 1s. a Left shifted 1
		 * say 1<<2 = 100. 100 - 1 is basically saying 100 -
		 *                                          -11111
		 *                                          -------
		 *                                          000011
		 */
		int mask = 	(1 << i) - 1;
		return (num & mask);
	}
	
	/**
	 * Clears the ith bit of provided num
	 * @param num
	 * @param i
	 * @return a number after num's  ith bit was cleared. 
	 */
	public static int clearIthrough0(int num, int i){
		/* -1 is equal to a sequence of 1s. A left-shifted -1
		 * say -1 << 2, will result in ...11100 if you want to make it
		 * inclusive of the I, then its i+1
		 */
		int mask = (-1 << (i+1));
		return (num & mask);
	}
	
	
	public static int update(int num, int i, boolean bitIs1){
		/*first figure out what value you want to change the Ith bit too
		 * 
		 */
		int value = bitIs1 ? 1: 0;
		//Then clear the bit you want to update.
		//start by isolating it with a mask
		int mask = ~(1<<i); // this is the same mask used in the Clearbit method
		//then you AND the mask and then  num (num & mask) then OR but the Value << i 
		return (num & mask) | (value << i);
	}
	
	/**
	 * This print any integer in bit form
	 * @param num: number to convert to binary
	 * @return num as binary
	 */
	public static String asBinary(int num){
		/* number of bits in a number's binary representation is found 
		 * with the following formula
		 *  nOfBits =⌊log2(n)⌋ + 1  
		 *  	(the  floor of the log_base2 of any n + 1
		 *  
		 *  java does not provide a log_base2 function but we can
		 *   calculate it knowing the identity:
		 *   			 logb(n) = loge(n) / loge(b)
		 *   			meaning the log_b of n = natural log(n) / natural log (b) 
		 *   			since we want base 2, b=2; n = number input 
		*/ 
		
		StringBuilder binRep = new StringBuilder();
		int totalBits = (int) (Math.floor( (Math.log(num)/Math.log(2))) + 1);
		for( int i = totalBits-1; i>=0; i--){
			boolean single_bit= ((num & (1 << i) )!= 0);
			binRep.append(single_bit ? "1":"0");
			//binRep.append( ( (  ((num & (1 << i) )!= 0) ? "1" : "0") ) ); 
			//works but hard to read
		}
		return binRep.toString();


	}
}
