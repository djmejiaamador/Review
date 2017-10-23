
public class Driver {
	public static void main(String[] args){

		System.out.println("Getting bit: " + BitManipulator.getBit(23, 3));
		System.out.println("Setting bit: " + (BitManipulator.setBit(5, 2)));
		System.out.println("Clear bit: " + BitManipulator.clearBit(23, 3));
		System.out.println("Clear msb to i: " + BitManipulator.clearMSBtoI(23, 1));
		System.out.println("Clear i to 0: " + BitManipulator.clearIthrough0(23,3));
		System.out.println("as Binary: " + BitManipulator.asBinary(43));
		
	}

}
