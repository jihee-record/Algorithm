package 백준.백준_1000_1999.백준_1238_파티_G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main_백준_1238_파티_G3_168ms {
	static class Edge {
		int to, time;
		Edge(int to, int time) {this.to = to; this.time = time;}
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 마을 수(= 학생 수)
		int M = Integer.parseInt(st.nextToken()); // 단방향 도로 개수
		int X = Integer.parseInt(st.nextToken()); // 파티 마을
		
		ArrayList<Edge> [] adj = new ArrayList[N + 1];
		ArrayList<Edge> [] adjr = new ArrayList[N + 1]; // reverse
		for(int n=1; n<=N; n++) {
			adj[n] = new ArrayList<>();
			adjr[n] = new ArrayList<>();
		}
		
		while(M --> 0) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			adj[from].add(new Edge(to, time));
			adjr[to].add(new Edge(from, time));
		}
		
		int INF = 1_000_000_000;
		int max = 0; // max 소요 시간
		
		int[] comebackhome = new int[N + 1]; // 왕복 시간
		Arrays.fill(comebackhome, INF);
		comebackhome[X] = 0;
		
		// 출발지 : 파티 장소 -> 집으로
		PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.time, b.time));
		pq.add(new Edge(X, 0));
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			if(comebackhome[e.to] < e.time) continue;
			
			for(Edge f : adj[e.to]) {
				int time = e.time + f.time;
				if(comebackhome[f.to] <= time) continue;
				comebackhome[f.to] = time;
				pq.add(new Edge(f.to, time));
			}
		}
		
		// 출발지 : 집 -> 파티 장소로
		int[] party = new int[N + 1]; 
		Arrays.fill(party, INF);
		party[X] = 0;
		
		pq = new PriorityQueue<>((a, b) -> Integer.compare(a.time, b.time));
		pq.add(new Edge(X, 0));
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			if(party[e.to] < e.time) continue;
			
			for(Edge f : adjr[e.to]) {
				int time = e.time + f.time;
				if(party[f.to] <= time) continue;
				party[f.to] = time;
				pq.add(new Edge(f.to, time));
			}
		}
			
		// N이 파티에 참석했다가 + 집에 돌아가는 거리
		for(int n=1; n<=N; n++)
		max = Math.max(max, party[n] + comebackhome[n]);
		
		System.out.println(max);
		br.close();
	}

}
