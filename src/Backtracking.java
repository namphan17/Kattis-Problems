
public abstract class Backtracking {
	public static boolean finished = false;
	
	protected abstract boolean isAsolution(int[] a, int k, Object dataInput);
	
	protected abstract void processSolution(int[]a, int k, Object dataInput);
	
	protected abstract void constructCandidate(int[] a, int k, Object dataInput, 
												int[] c, int nCandidates);
	
	protected void backtrack(int[] a, int k , Object dataInput) {
		int nCandidates = 10000;
		int[] c = new int[nCandidates];
		
		if (isAsolution(a, k, dataInput)) {
			processSolution(a, k, dataInput);
		} else {
			k = k+1;
			constructCandidate(a, k, dataInput, c, nCandidates);
			for (int i = 1; i < nCandidates; i++) {
				a[k] = c[k];
				backtrack(a, k, dataInput);
				if (finished) return;
			}
		}
	}
	
}
