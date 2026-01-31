package 백준.백준_5000_5999.백준_5972_택배배송_G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_백준_5972_택배배송_G5_344ms {
	static class Edge {
		int to, dist;
		Edge(int to, int dist){
			this.to = to;
			this.dist = dist;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 헛간 개수
		int M = Integer.parseInt(st.nextToken()); // 
		
		ArrayList<Edge>[] edges = new ArrayList[N+1];
		for(int n=1; n<=N; n++) edges[n] = new ArrayList<>();
		
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()); // A 헛간
			int B = Integer.parseInt(st.nextToken()); // B 헛간
			int C = Integer.parseInt(st.nextToken()); // 소의 수
			
			edges[A].add(new Edge(B, C));
			edges[B].add(new Edge(A, C));
		}
		
		int[] dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[1] = 0;
		
		PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.dist, b.dist));
		pq.add(new Edge(1, 0));
		
		while(!pq.isEmpty()) {
			Edge e = pq.poll(); 
			
			if(e.dist > dist[e.to]) continue; // 
			
			for(Edge f : edges[e.to]) { // e.to : 출발지
				int total = e.dist + f.dist;
				if(dist[f.to] <= total) continue; 
				dist[f.to] = total;
				pq.add(new Edge(f.to, total));
			}
			
		}
		
		System.out.println(dist[N]);
		br.close();
	}

}
