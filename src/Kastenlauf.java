import java.util.*;

public class Kastenlauf {
	private static class Point {
		int x, y;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StringTokenizer st;
		st = new StringTokenizer(scanner.nextLine());
		final int TEST_CASE = Integer.parseInt(st.nextToken());

		for (int i = 0; i < TEST_CASE; i++) {
			Queue<Point> route = new LinkedList<Point>();
			st = new StringTokenizer(scanner.nextLine());
			int beers = 20;
			int stores = Integer.parseInt(st.nextToken());
			for (int j = 0; j < stores + 2; j++) {
				st = new StringTokenizer(scanner.nextLine());
				Point p = new Point();
				p.x = Integer.parseInt(st.nextToken());
				p.y = Integer.parseInt(st.nextToken());
				route.add(p);
			}
			Point current = route.remove();
			int refill = 0; // Number of beers just ran out.
			boolean sad = false;
			loop: for (int k = 0; k < stores; k++) {
				Point store = route.remove();
				int distanceMoved = store.x - current.x + store.y - current.y;
				int beerDecrement = distanceMoved / 50;
				beers += refill;
				refill = beerDecrement;

				if ( beerDecrement > 20 || ( beerDecrement==20 && distanceMoved%50!=0 ) ) {
					// System.out.println("Beer decrement: " + beerDecrement);
					// // Debugging
					System.out.println("sad");
					sad = true;
					break loop;
				}
				beers -= beerDecrement;
				current = store;
			}
			if (!sad) {
				beers += refill;
				Point end = route.remove();
				int distanceMoved = end.x - current.x + end.y - current.y;
				int beerDecrement = distanceMoved / 50;
//				System.out.println("Beer_Drunk=" + beerDecrement);
				beers -= beerDecrement;
				if (route.isEmpty()) {
					// System.out.println("beers=" + beers);
					if (beers > 0) {
						System.out.println("happy");
					} else if (beers < 0) {
						System.out.println("sad");
					} else {
						if (distanceMoved % 50 == 0) {
							System.out.println("happy");
						} else {
							System.out.println("sad");
						}
					}
				}
			}
		}

		scanner.close();
	}
}
