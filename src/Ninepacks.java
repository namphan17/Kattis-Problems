import java.util.*;

public class Ninepacks {
	
	/*
	 * 
	 *  @params: hotdog/bun Type = different weight of pack
	 *  		hotdog/bun Packs = number of packs of each weight
	 */
	public static void balance(int hotdogTotal, int bunTotal, 
			ArrayList<Integer> hotdogType, ArrayList<Integer> bunType,
			ArrayList<Integer> hotdogPacks, ArrayList<Integer> bunPacks, int packCount) {
		System.out.println();
		System.out.println("Hotdog total = " + hotdogTotal);
		System.out.println("bun total = " + bunTotal);
		int difference = hotdogTotal - bunTotal;
		if (difference == 0) {
			System.out.println("Difference = 0 with packCount = " + packCount);
		} else {
			if (difference < 0) {
				for (int i = 0; i < hotdogType.size(); i++) {
					if (hotdogPacks.get(i) != 0) {
						hotdogTotal += hotdogType.get(i);
						packCount++;
						ArrayList<Integer> newHotdogPacks = new ArrayList<>();
						for (int j : hotdogPacks) {
							newHotdogPacks.add(j);
						}
						newHotdogPacks.add(i, hotdogPacks.get(i) - 1);
						balance(hotdogTotal, bunTotal, hotdogType, bunType, newHotdogPacks, bunPacks, packCount);
					} else {
						return;
					}
				}
			} else {
				for (int i = 0; i < bunType.size(); i++) {
					if (bunPacks.get(i) != 0) {
						bunTotal += bunType.get(i);
						bunPacks.add(i, bunPacks.get(i) - 1);
						ArrayList<Integer> newBunPacks = new ArrayList<>();
						for (int j : bunPacks) {
							newBunPacks.add(j);
						}
						newBunPacks.add(i, hotdogPacks.get(i) - 1);
						balance(hotdogTotal, bunTotal, hotdogType, bunType, hotdogPacks, newBunPacks, packCount);
					}
					else {
						return;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); 
		
		int hotdog = scanner.nextInt();
		List<Integer> HotdogInput = new ArrayList<>();
		for (int i = 0; i < hotdog; i++) {
			int val = scanner.nextInt();
			HotdogInput.add(val);
		}
		int bun = scanner.nextInt();
		List<Integer> BunInput = new ArrayList<>();
		for (int i = 0; i <bun; i++) {
			int val = scanner.nextInt();
			BunInput.add(val);
		}
		
		
		// Get the number of pack of different amount of hot dog and bun
		ArrayList<Integer> bunPack = new ArrayList<>();
		ArrayList<Integer> numberOfEachBunPack = new ArrayList<>();
		ArrayList<Integer> hotdogPack = new ArrayList<>();
		ArrayList<Integer> numberOfEachHotdogPack = new ArrayList<>();
		
		int currentBunPack = -1;
		for (int i : BunInput) {
			if (i != currentBunPack) {
				currentBunPack = i;
				int count = 0;
				for (int j : BunInput) {
					if (j == currentBunPack) {
						count++;
					}
					bunPack.add(currentBunPack);
					numberOfEachBunPack.add(count);
				}
				
			}
		}
		
		int currentHotdogPack = -1;
		for (int i : HotdogInput) {
			if (i != currentHotdogPack) {
				currentHotdogPack = i;
				int count = 0;
				for (int j : HotdogInput) {
					if (j == currentHotdogPack) {
						count++;
					}
					hotdogPack.add(currentHotdogPack);
					numberOfEachHotdogPack.add(count);
				}
				
			}
		}
		balance(hotdogPack.get(0), 0, hotdogPack, bunPack, numberOfEachHotdogPack, numberOfEachBunPack, 1);
		
		
	
	}
}
