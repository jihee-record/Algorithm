package 백준.백준_1000_1999.백준_1197_최소스패닝트리_G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// mst prim
@SuppressWarnings("unchecked")
public class Main_백준_1197_최소스패닝트리_G4_532ms_prim {
	
	static class Edge{
		int x;
		int value;
		
		Edge(){}
		Edge(int x, int value){
			this.x = x;
			this.value = value;
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken()); // 정점의 개수
		int E = Integer.parseInt(st.nextToken()); // 간선의 개수
		
		ArrayList<Edge>[] adj = new ArrayList[V+1];
		for(int v=1; v<=V; v++) {
			adj[v] = new ArrayList<>();
		}
		
		// |AB| = C, |C| <= 1,000,000
		for(int e=0; e<E; e++) {
			st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			adj[A].add(new Edge(B, C));
			adj[B].add(new Edge(A, C));
		}
		
		int mst = 0;
		int cnt = 0;
		
		boolean[] visited = new boolean[V+1];
		
		PriorityQueue<Edge> pq = new PriorityQueue<>((e, f) -> Integer.compare(e.value, f.value));
		pq.add(new Edge(1, 0));
		
		while(cnt < V) {
			Edge e = pq.poll();
			
			if(visited[e.x]) continue;
			
			visited[e.x] = true;
			mst += e.value;
			cnt++;

			for(Edge f: adj[e.x]) {
				if(visited[f.x]) continue;
				pq.add(f);
			}
		}
		
		System.out.println(mst);
	}
	
}
