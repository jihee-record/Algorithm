
package 백준.백준_1000_1999.백준_1260_DFS와BFS_S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

@SuppressWarnings(value = {"unchecked", "unused", "rawtypes"})
public class Main_백준_1260_DFS와BFS_S2_212ms {
	static StringBuilder sb = new StringBuilder();
	static boolean visited[];
	static class Graph{
		private int V;
		private TreeSet<Integer>[] adj;
		
		Graph(){}
		
		Graph(int v){
			this.V = v;
			this.adj = new TreeSet[v+1];
			for(int i=1; i<=v; i++) {
				adj[i] = new TreeSet();
			}
		}
		
		void addEdge(int v, int w) {
			adj[v].add(w);
			adj[w].add(v);
		}

		StringBuilder BFS(int s) {
			Queue<Integer> queue = new LinkedList<>();
			visited[s] = true;
			queue.add(s);
			while (!queue.isEmpty()) {
                s = queue.poll();
                sb.append(s).append(" ");

                for (int n : adj[s]) {
                    if (!visited[n]) {
                        visited[n] = true;
                        queue.add(n);
                    }
                }
            }
			return sb;
		}
		
		StringBuilder DFS(int s) {
	        visited[s] = true; 
	        sb.append(s).append(" ");
	        
            for (int n : adj[s]) {
                if (!visited[n]) {
                    visited[n] = true; 
                    DFS(n);
                }
            }
			return sb;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		//N:정점의 개수, M:간선의 개수, V:탐색을 시작할 번호  
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		Graph graph = new Graph(N);
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph.addEdge(x, y);
		}
		
		visited = new boolean[N+1];
		
		graph.DFS(V);
		sb.append("\n");
		
		Arrays.fill(visited, false);
		graph.BFS(V);
		System.out.println(sb);
		br.close();
	}
}
