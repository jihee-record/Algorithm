package 백준.백준_2000_2999.백준_2211_네트워크복구_G2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_백준_2211_네트워크복구_G2_492ms {
	static class Link {
		int to, time;
		Link(int to, int time){ this.to = to; this.time = time;}
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Link>[] adj = new ArrayList[N + 1];
		for(int n=1; n<=N; n++) adj[n] = new ArrayList<>();
		
		while(M --> 0) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			adj[A].add(new Link(B, C));
			adj[B].add(new Link(A, C));
		}
		
		int[] dist = new int[N + 1];
		Arrays.fill(dist, 1_000_000);
		dist[1] = 0; // 1 : 슈퍼컴퓨터 임의 지정

		int[] trace = new int[N + 1];
		
		PriorityQueue<Link> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.time, b.time));
		pq.add(new Link(1, 0));
		
		while(!pq.isEmpty()) {
			Link l = pq.poll();
			if(l.time > dist[l.to]) continue;
			
			for(Link k : adj[l.to]) {
				int t = l.time + k.time;
				if(t >= dist[k.to]) continue;
				
				dist[k.to] = t;
				trace[k.to] = l.to; // 갱신되면 연결해야하는 간선 조정
				pq.add(new Link(k.to, t));
			}
		}
		
		sb.append(N-1).append('\n'); // 반드시 N-1개 (최소 개수)
		for(int n=2; n<=N; n++) { // 1이 슈퍼컴퓨터 
			sb.append(n).append(' ').append(trace[n]);
		}
		
		System.out.println(sb);
		br.close();
	}

}
