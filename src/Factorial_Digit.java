import java.util.*;
import java.util.concurrent.TimeUnit;
import java.io.*;

public class Factorial_Digit {
	private static long factorial(long num) {
		long fact = 1;
		for (int i = 2; i <= num; i++) {
			fact = fact * i;
		}
		return fact;
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextInt()) {
			long startTime = System.currentTimeMillis();
			int input = scanner.nextInt();
			if (input == 0 || input == 1) {
				System.out.println(1);
			} else {
				double x = 0;
				for (int i = 1; i <= input; i++) {
					x = x + Math.log10(i);
				}
				int output = (int) Math.ceil(x);
				System.out.println(output);
			}
			long endTime = System.currentTimeMillis();
			long ellapsedTime = TimeUnit.SECONDS.convert(endTime - startTime, TimeUnit.SECONDS);
//			System.out.println((endTime - startTime) / 1000.0);
		}
	}
}
