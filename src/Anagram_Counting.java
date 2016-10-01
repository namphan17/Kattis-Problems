import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Anagram_Counting {
	
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
			String input = scanner.nextLine();
			long count = input.length();
			long distinctCounter = 0;
			Map<String, Long> container = new Hashtable();
			
			for (int i = 0; i < input.length(); i++) {
				if (!container.containsKey(input.charAt(i)+"")) {
					container.put(input.charAt(i)+"", (long) 1);
				} else {
					
					// Debugging
//					System.out.println("In else loop, input.charAt(i) = " + input.charAt(i));
//					System.out.println("c);
					
					long value = container.get(input.charAt(i)+"");
					value++;
					container.put(input.charAt(i)+"",  value);
				}
			}
			
			Iterator<Map.Entry<String, Long>> it = container.entrySet().iterator();
			
			BigInteger numerator = factorial(count);
			BigInteger denumerator = BigInteger.ONE;
			while (it.hasNext()) {
				Map.Entry<String, Long> entry = it.next();
				BigInteger mutiplier = factorial(entry.getValue());
				denumerator = denumerator.multiply(mutiplier);
			}
			
			System.out.println(numerator.divide(denumerator));
			
		}
		
	}
}
