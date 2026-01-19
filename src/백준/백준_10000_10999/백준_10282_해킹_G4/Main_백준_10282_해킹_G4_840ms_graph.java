package 백준.백준_10000_10999.백준_10282_해킹_G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// pq ,  visited x
@SuppressWarnings("unchecked")
public class Main_백준_10282_해킹_G4_840ms_graph {
	
	static class Edge {
		int a; // to
		int t; // time
		
		Edge(){}
		Edge(int a, int t){
			this.a = a;
			this.t = t;
		}
	}
	
	static class Graph {
		int N;
		ArrayList<Edge>[] linked; 
		
		Graph(){}
		Graph(int N){
			this.N = N;
			linked = new ArrayList[N+1];
			
			for(int n=1; n<=N; n++) {
				linked[n] = new ArrayList<>();
			}
		}
		
		void addEdge(int b, Edge edge){
			this.linked[b].add(edge);
		}
	}
	
	 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st ;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			Graph graph = new Graph(N);
			
			for(int d=0; d<D; d++) {
				st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				
				graph.addEdge(b, new Edge(a, s));
			}
			
			int[] dist = new int[N+1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			
			PriorityQueue<Edge> pq = new PriorityQueue<>((x, y) ->{
				if(x.t != y.t) {
					return Integer.compare(x.t, y.t);
				}else {
					return Integer.compare(x.a, y.a);
				}
			});
			
			dist[C] = 0;
			pq.add(new Edge(C, 0));
			int cnt = 0;
			int result = 0;
			
			while(!pq.isEmpty()) {
				Edge v = pq.poll(); // 시작점
				
				if(dist[v.a] < v.t) {
					continue;
				}
				
				cnt++;
				result = v.t;
				
				for(Edge u: graph.linked[v.a]) {
					int cu = dist[v.a] + u.t;
					if(dist[u.a] <= cu) continue;
					dist[u.a] = cu;
					pq.add(new Edge (u.a, cu));
				}
			}
			
			sb.append(cnt).append(" ").append(result).append("\n");
		}
		
		System.out.println(sb.toString());
		br.close();
	}
}
