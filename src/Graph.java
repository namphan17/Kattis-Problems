import java.util.*;


public class Graph {
	
	private final int V; // number of vertices
	private int E; // number of edges
	private ArrayList<Edge>[] adjE; // adjacency lists of edges
	private ArrayList<Integer>[] adjV; // adjacency lists vertices.

	public Graph(int V) {
		this.V = V;
		this.E = 0;
		adjE = (ArrayList<Edge>[]) new ArrayList[V];
		adjV = (ArrayList<Integer>[]) new ArrayList[V]; // Create array of lists.
		for (int v = 0; v < V; v++) {
			// Initialize all lists
			adjV[v] = new ArrayList<Integer>(); // to empty.
		}
		for (int v = 0; v < V; v++) {
			adjE[v] = new ArrayList<Edge>();
		}
	}

//	public EdgeWeightedGraph(In in) {
//		this(in.readInt());
//		int N = in.readInt();
//		for (int i = 0; i < N; i++) {
//		Edge e = new Edge(in.readInt(), in.readInt());
//		this.addEdge(e);
//		}
//	}
	
	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	public void addEdge(Edge e) {
		int v = e.either(), w = e.other(v);
		adjE[v].add(e);
		adjE[w].add(e);
		
		adjV[v].add(w);
		adjV[w].add(v);
		
		E++;
	}

	public Iterable<Edge> adjE(int v) {
		return adjE[v];
	}

	public Iterable<Integer> adjV(int v) {
		return adjV[v];
	}
	
	public Iterable<Edge> edges() {
		ArrayList<Edge> b = new ArrayList<Edge>();
		for (int v = 0; v < V; v++)
			for (Edge e : adjE[v])
				if (e.other(v) > v)
					b.add(e);
		return b;
	}
}