import java.util.*;
public class Bachet {
	
	public static void main(String[] args) {
		boolean[] winningState = new boolean[10000001];
		
		Scanner scanner = new Scanner(System.in);
		
		while (scanner.hasNextInt()) {
			int size = scanner.nextInt(); 
			int N = scanner.nextInt();		
			int[] moves = new int[N];
			for (int i = 0; i < N; i++) {
				moves[i] = scanner.nextInt();
			}
			for (int i = 0; i <= size; i++) {
				winningState[i] = false;
				loop1:
				for (int j = 0; j < N; j++) {
					if (i - moves[j]>=0 && !winningState[i-moves[j]]) {
						winningState[i] = true;
						break loop1;
					}
				}
			}
			if (winningState[size]) {
				System.out.println("Stan wins");
			} else {
				System.out.println("Ollie wins");
			}
		}
		
		scanner.close();
	}
}
