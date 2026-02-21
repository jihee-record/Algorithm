package 백준.백준_1000_1999.백준_1167_트리의지름_G2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static class Edge {
		int to, cost;
		Edge(int to, int cost) {
			this.to = to; 
			this.cost = cost;
		}
	}
	
	static int V, ans;
	static ArrayList<Edge>[] adj;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		V = Integer.parseInt(br.readLine());
		adj = new ArrayList[V+1];
		for(int v=0; v<=V; v++) adj[v] = new ArrayList<>();
		
		for(int v=1; v<=V; v++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			while(st.hasMoreTokens()) {
				int to = Integer.parseInt(st.nextToken());
				if(to == -1) break;
				int cost = Integer.parseInt(st.nextToken());
				adj[n].add(new Edge(to, cost));
			}
		}
		
		ans = 0;
		
		for(int v=1; v<=V; v++) {
			boolean[] visited = new boolean[V+1];
			ArrayDeque<Edge> stack= new ArrayDeque<>();
			stack.push(new Edge(v, 0));
			visited[v] = true;
			while(!stack.isEmpty()) {
				Edge e = stack.pop();
				for(Edge f : adj[e.to]) { // f.from = e.to 
					if(visited[f.to]) continue;
					visited[f.to] = true;
					int sum = e.cost + f.cost;
					ans = Math.max(sum, ans);
					stack.push(new Edge(f.to, sum));
				}
			}
		}
		
		System.out.println(ans);
		br.close();
	}

}
