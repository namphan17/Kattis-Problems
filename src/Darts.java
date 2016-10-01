import java.util.*;

public class Darts {

	private static class Point {
		double x, y;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StringTokenizer st;
		
		while (scanner.hasNextLine()) {
			List<Point> points = new ArrayList<Point>();
			st = new StringTokenizer(scanner.nextLine());
			while (st.hasMoreTokens()) {
				Point p = new Point();
				p.x = Double.parseDouble(st.nextToken());
				p.y = Double.parseDouble(st.nextToken());

				// Debugger
				// System.out.println("x:" + p.x + " y:" + p.y);

				points.add(p);
//				System.out.println("Adding point: x=" + p.x + ", y=" + p.y);
			}
			Queue<Point> boundaries = convexHull(points);
			

//			System.out.println("Boundaries #points:" + boundaries.size());			// Debugging
			
			/** Debugging **/
			int num = points.size();
			double perimeter = perimeter(boundaries);

//			System.out.println("perimeter of boundary: " + perimeter);
			double dVal = 100 * num / (perimeter + 1);
			double result = Math.round (dVal * 10000000000.0) / 10000000000.0;  ;
			System.out.println(result);
		}
		scanner.close();
//		System.out.println("Size of input: #points=" + points.size() + "\n"); // Debugging
		

		// for(int i = 0; i < boundaries.size(); i++) {
		// System.out.println("x:" + boundaries.get(i).x + ", y:" +
		// boundaries.get(i).y);
		// }
	}

	/** Return perimeter of the convex hull **/
	private static double perimeter(Queue<Point> points) {
//		// Debugging
//		System.out.println("\nThis boundary contains:");
		if (points.size() == 1) {
			return 0;
		} else {
			double perimeter = 0;
			Point first = points.remove();
			Point origin = first;
			Point next;
			do {
				next = points.remove();
				double x = next.x - first.x;
				double y = next.y - first.y;
//				// Debugging
//				System.out.println("x_first="+first.x+", y_first=" + first.y + "; x_next=" + next.x + ", y_next=" + next.y);
//				System.out.println("Adding to the perimeter: "+Math.sqrt(x * x + y * y));
				
				perimeter = perimeter + Math.sqrt(x * x + y * y);
				first = next;
			} while (!points.isEmpty());
			double x = origin.x - first.x;
			double y = origin.y - first.y;
//			System.out.println("Adding to the perimeter: "+Math.sqrt(x * x + y * y));
			perimeter = perimeter + Math.sqrt(x * x + y * y);
			return perimeter;
		}
	}

	/*
	 * Orientation Test Return true if p, q, r <=> val < 0 then these 3 points
	 * are clockwise
	 */
	private static boolean orientationTest(Point p, Point q, Point r) {
		double val;
		val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
		return val < 0;
	}

	private static Queue<Point> convexHull(List<Point> points) {
		int n = points.size(); // return the size of the list
		/** If there are less than 3 points then return **/

		Queue<Point> convexHull = new LinkedList<Point>();
		if (n < 3) {
//			System.out.println("n is less than 3"); 					// Debugging
			
			convexHull.add(points.get(0));
			if (n == 2) {
				convexHull.add(points.get(1));
			}
			return convexHull;
		} else {
//			System.out.println("n >= 3"); 					// Debugging
			/** Find the leftmost point **/
			int leftMost = 0;
			for (int i = 1; i < n; i++) {
				if (points.get(leftMost).x > points.get(i).x) {
					leftMost = i;
				}
			}
			
			int p = leftMost, q;
			
//			// Debugging
//			System.out.println("Adding leftmost=" +leftMost+ "point to the hull: x=" + points.get(p).x + ", y=" + points.get(p).y);
			
			convexHull.add(points.get(p));
			do {
				q = (p + 1) % n;
				for (int i = 0; i < n; i++) {
					if (orientationTest(points.get(p), points.get(i), points.get(q))) {
						q = i;
					}
				}
				p = q;
//				// Debugging
//				System.out.println("Adding this point=" +p+ "to the hull: x=" + points.get(p).x + ", y=" + points.get(p).y);
				if (p != leftMost)
					convexHull.add(points.get(p));

			} while (p != leftMost);
//			System.out.println("Size of this convexHull=" + convexHull.size());
			return convexHull;
		}
	}

}
