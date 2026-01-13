package 백준.백준_1000_1999.백준_1922_네트워크연결_G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// mst prim
@SuppressWarnings("unchecked")
public class Main_백준_1922_네트워크연결_G4_396ms_prim {
	static class Edge {
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
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // vertex
		int M = Integer.parseInt(br.readLine()); // edge
		
		ArrayList<Edge>[] adj = new ArrayList[N+1]; 
		for(int n=1; n<=N; n++) {
			adj[n] = new ArrayList<>();
		}
		
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a == b) continue;
			
			adj[a].add(new Edge(b, c));
			adj[b].add(new Edge(a, c));
		}
		
		boolean[] visited = new boolean[N+1];
		
		PriorityQueue<Edge> pq = new PriorityQueue<>((e, f) -> {
			return Integer.compare(e.value, f.value);
		});
		pq.add(new Edge(1, 0));
		
		int cost = 0;
		int cnt = 0;
		while(cnt < N) {
			Edge e = pq.poll();
			
			if(visited[e.x]) continue;
			
			visited[e.x] = true;
			cost += e.value;
			cnt++;
			
			for(Edge f: adj[e.x]) {
				if(visited[f.x]) continue;
				
				pq.add(f);
			}
		}
		
		System.out.println(cost);
		br.close();
	}

}
