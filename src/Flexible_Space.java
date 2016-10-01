import java.util.*;
import java.io.*;

public class Flexible_Space {
	public static void main(String[] args) throws IOException{ 
		
		Scanner scanner = new Scanner(System.in);
		
		final int WIDTH = scanner.nextInt();	
		int partitions = scanner.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		while(scanner.hasNextInt()){
			list.add(scanner.nextInt());
		}
		list.add(WIDTH);
		
		// Computing possible space from the original partition. 
		for (int i = 0; i < partitions; i++) {
			for (int j = i + 1; j <= partitions; j++) {
				list.add(list.get(j) - list.get(i));
			}
		}
		
		Collections.sort(list);
		
		//Print to the output
		System.out.print(list.get(0) + " ");
		for(int i = 1; i < list.size(); i++) {
			if (list.get(i) != list.get(i - 1))
				System.out.print(list.get(i) + " ");
		}
		scanner.close();
	}
}
