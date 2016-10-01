import java.math.BigInteger;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Cube_Root {
	private static BigInteger factorial(long num) {
		BigInteger fact = BigInteger.ONE;
		for (int i=2; i<=num ; i++){
	        fact= fact.multiply(BigInteger.valueOf(i));
	    }
		return fact;
	}
	
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		
		while (scanner.hasNextLine()) {
			BigInteger input = new BigInteger(scanner.nextLine());
			BigInteger start = BigInteger.ZERO;
			BigInteger end = input.add(BigInteger.ONE);
			BigInteger mid;
//			System.out.println("comparing: " + start.compareTo(end.subtract(BigInteger.ONE)));
			while (start.compareTo(end.subtract(BigInteger.ONE)) == -1) {
				mid = (start.add(end)).divide(BigInteger.valueOf((long) 2));
				
				/**
				 * Debugging
				 * */
//				System.out.println("start: " + start);
//				System.out.println("end: " + end);
//				System.out.println("mid: " + mid);
//				
//				System.out.println("x: " + mid.multiply(mid.multiply(mid)));
//				System.out.println("y: " + input + "\n");
				
				
				if (mid.multiply(mid.multiply(mid)).compareTo(input) == 1) {
					end = mid;
				} else {
					start = mid;
				}
			}
			BigInteger differenceLow = input.subtract(start.multiply(start.multiply(start)));
			BigInteger differenceHigh = end.multiply(end.multiply(end)).subtract(input);
			
			/**
			 * Debugging
			 * */
//			System.out.println("High: " + end);
//			System.out.println("Start: " + start);
//			
//			System.out.println("Difference High: " + differenceHigh);
//			System.out.println("Difference Low: " + differenceLow);
			
			if (differenceLow.compareTo(differenceHigh) == -1) {
				System.out.println(start);
			} else {
				System.out.println(end);
			}
			
			
		}
		
	}
}
