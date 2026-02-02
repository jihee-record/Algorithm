package 백준.백준_1000_1999.백준_1753_최단경로_G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_백준_1753_최단경로_G4_548ms {
	static class Edge {
		int to; 
		long cost;
		Edge(int to, long cost) {this.to = to; this.cost = cost;}
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken()); // vertex
		int E = Integer.parseInt(st.nextToken()); // edge
		int K = Integer.parseInt(br.readLine()); // start
		
		ArrayList<Edge>[] adj = new ArrayList[V + 1];
		for(int v=1; v<=V; v++) adj[v] = new ArrayList<>();
		
		while(E --> 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[u].add(new Edge(v, w));
		}
		
		long[] cost = new long[V + 1];
		long INF = Long.MAX_VALUE;
		Arrays.fill(cost, INF);
		cost[K] = 0;
		
		PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> Long.compare(a.cost, b.cost));
		pq.add(new Edge(K, 0)); // 시작점
		
		while(!pq.isEmpty()) {
			Edge e = pq.poll(); // 출발지
			if(e.cost > cost[e.to]) continue;
			
			for(Edge f : adj[e.to]) {
				long sum = e.cost + f.cost;
				if(sum >= cost[f.to]) continue;
				cost[f.to] = sum;
				pq.add(new Edge(f.to, sum));
				
			}
		}
		
		for(int v=1; v<=V; v++) {
			sb.append(cost[v] == INF ? "INF" : cost[v]).append('\n');
		}
		
		System.out.println(sb);
		br.close();
	}

}
