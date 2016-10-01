import java.util.*;
import java.io.*;

public class War_Card_Game {
	static final int NCARDS = 52;
	static final int NSUITS = 4;
	static final int MAX_STEPS = 1000000;

	static final char[] values = "23456789TJQKA".toCharArray();
	static final char[] suits = "cdhs".toCharArray();

	private static int getRank(char value, char suite) {
		int rank = 0;
		for (int i = 0; i < NCARDS / NSUITS; i++) {
			if (values[i] == value) {
				for (int j = 0; j < NSUITS; j++) {
					if (suits[j] == suite) {
						rank = i * NSUITS + j;
						return rank;
					}
				}
			}
		}
		return rank;
	}

	private static char getValue(int rank) {
		return values[rank / NSUITS];
	}

	private static char getSuit(int rank) {
		return suits[rank % NSUITS];
	}

	public static void main(String[] args) {
		
		Queue<Integer> deckA = new LinkedList<Integer>();
		Queue<Integer> deckB = new LinkedList<>();

		Scanner scanner = new Scanner(System.in);
		int N_TEST_CASES = scanner.nextInt();
		char value, suit;
		String c;

		// Need a for loop to go through each test case.
		
		// Read Input and Enqueue
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < NCARDS / 2; j++) {

				c = scanner.next();
				System.out.println("c= " + c);
				
				while (c != "\n") {
					value = c.charAt(0);	
					suit = c.charAt(1);		
					System.out.printf("value=%s suit=%s \n", value, suit); /* Debugging */
					if (i == 0)
						deckA.add(getRank(value, suit));
					else
						deckB.add(getRank(value, suit));
					c = scanner.next();
				}
			}
			scanner.nextLine();
			System.out.println("Reading this line");
		}
		war(deckA, deckB);
	}

	private static void war(Queue a, Queue b) {
		int steps = 0; /* step counter */
		int x, y; /* top cards */
		Queue<Integer> c = new LinkedList<>(); /* cards involved in the war */
		boolean inwar = false; /* are we involved in a war */

		while ((!a.isEmpty() && !b.isEmpty()) && steps < MAX_STEPS) {
			steps++;
			x = (Integer) a.remove();
			y = (Integer) b.remove();
			c.add(x);
			c.add(y);
			if (inwar) {
				inwar = false;
			} else {
				if (getValue(x) > getValue(y))
					clear_queue(c, a);
				else if (getValue(x) < getValue(y))
					clear_queue(c, b);
				else if (getValue(x) == getValue(y))
					inwar = true;
			}
		}

		if (!a.isEmpty() && b.isEmpty()) {
			System.out.printf("a wins in %d steps \n", steps);
		} else if (a.isEmpty() && !b.isEmpty()) {
			System.out.printf("b wins in %d steps ]n", steps);
		} else if (!a.isEmpty() && b.isEmpty()) {
			System.out.printf("game tied after %d steps, |a|=%d |b|=%d \n", steps, a.size(), b.size());
		} else {
			System.out.printf("a and b tied in %d steps", steps);
		}
	}

	private static void clear_queue(Queue<Integer> a, Queue<Integer> b) {
		while (!a.isEmpty()) {
			b.add(a.remove());
		}
	}

}
