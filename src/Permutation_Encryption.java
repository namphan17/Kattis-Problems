import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Permutation_Encryption {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			
			System.out.println();
			System.out.print(n);
			System.out.println();
			
			int[] permutation = new int[n];
			for (int i = 1; i < n; i++) {
				permutation[i] = scanner.nextInt();
				// Debugging
//				System.out.print(permutation[i] + " ");
			}
			permutation[0] = scanner.nextInt();
			// Jump to the next line
			scanner.nextLine();
			
			String inputMessage = scanner.nextLine() + "";
			// Print out message
			char[] message = inputMessage.toCharArray();
			System.out.println(message);
			char[] hiddenMessage;
			
			int bufferMessage = message.length % n;
			
			if (bufferMessage != 0){
				hiddenMessage = new char[message.length + n - bufferMessage];
			}else {
				hiddenMessage = new char[message.length];
			}
			for (int i = 0; i < hiddenMessage.length; i++) {
				if (i < message.length)
					hiddenMessage[i] = message[i];
				else
					hiddenMessage[i] = ' ';
			}
			
			
			char[] encryptedMessage = new char[hiddenMessage.length];
			
			for (int i = 0; i < message.length; i++) {
				int index = i + 1;
				int multiplier = i/n;
				// Debugger
				int indexInHiddenMessage = (permutation[index%n] - 1) + (n * multiplier);
				System.out.println("index= " + index + "\t multiplier=  " + multiplier + "\t" + "\t indexInHiddenMessage= " + indexInHiddenMessage);
				
				encryptedMessage[i] = hiddenMessage[indexInHiddenMessage];
			}
			System.out.print('\'');
			for (int i = 0; i < encryptedMessage.length; i++){
				System.out.print(encryptedMessage[i]);
			}
			System.out.print('\'');
			System.out.println();
			
			scanner.nextLine();
		}
	}
}
