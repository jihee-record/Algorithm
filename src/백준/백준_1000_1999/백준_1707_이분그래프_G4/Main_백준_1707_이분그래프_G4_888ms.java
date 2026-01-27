package 백준.백준_1000_1999.백준_1707_이분그래프_G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

// dfs, 2-coloring
@SuppressWarnings("unchecked")
public class Main_백준_1707_이분그래프_G4_888ms {
	
	static class Graph {
		int V; 
		LinkedList<Integer>[] adj;
		
		Graph(){};

		Graph(int v){
			this.V = v;
			this.adj = new LinkedList[v+1];
			
			for(int i=1; i<=v; i++) {
				adj[i] = new LinkedList<>();
			}
		}
		
		void addEdge(int u, int v) {
			adj[u].add(v);
			adj[v].add(u);
		}
		
		boolean isBipartie() { // start
			int[] color = new int[V+1]; // -1: not visited / 0, 1:color
			Arrays.fill(color, -1);
			Stack<Integer> stack = new Stack<>();
			
			for(int v=1; v<=V; v++) { // 비연결그래프 대비
				if(color[v] != -1) continue;
				color[v] = 0;
				// color[s] = false;
				stack.add(v);
			
				while(!stack.isEmpty()) {
					v = stack.pop();
					int next = 1 - color[v]; 
					
					for(int n : adj[v]) {
						if(color[n] == -1) { // 방문 전이면 연결된 점과 다른 색으로 컬러링
							color[n] = next;
							stack.add(n);
						} else if(color[n] != next){ // 이미 방문 상태면 지금 칠해야 하는 색과 동일한지 체크 달라지는 순간 false
							return false;
						}
					}
				}
			}
			
			// 컬러링이 정상적으로 끝났으면 이분그래프
			return true;
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st;
		
		int K = Integer.parseInt(br.readLine()); // 테케
		for(int k=0; k<K; k++) {
			st = new StringTokenizer(br.readLine());
			
			int V = Integer.parseInt(st.nextToken()); // vertex
			int E = Integer.parseInt(st.nextToken()); // edge
			
			Graph g = new Graph(V);
			
			for(int e=0; e<E; e++) {
				st = new StringTokenizer(br.readLine());
				
				int u = Integer.parseInt(st.nextToken()); // v1
				int v = Integer.parseInt(st.nextToken()); // v2
				
				g.addEdge(u, v);
			}
			
			if(g.isBipartie()) sb.append("YES\n");
			else sb.append("NO\n");
		}
		
		System.out.println(sb.toString());
		br.close();
	}
}
