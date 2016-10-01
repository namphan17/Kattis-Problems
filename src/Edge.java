
public class Edge{
	private final int v; // one vertex
	private final int w; // the other vertex
	private final int weight; // weight of the edge

	public Edge(int v, int w, int weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	public int either() {
		return v;
	}

	public int other(int vertex) {
		if (vertex == v)
			return w;
		else if (vertex == w)
			return v;
		else
			throw new RuntimeException("Inconsistent edge");
	}

	public String toString() {
		return String.format("%d-%d", v, w);
	}
}
