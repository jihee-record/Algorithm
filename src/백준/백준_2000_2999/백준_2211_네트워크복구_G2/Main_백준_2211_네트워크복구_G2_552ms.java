package 백준.백준_2000_2999.백준_2211_네트워크복구_G2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


// 슈퍼컴퓨터가 임의인가?
public class Main_백준_2211_네트워크복구_G2_552ms {
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
		
		int[] time = new int[N + 1];
		Arrays.fill(time, 1_000_000);
		time[1] = 0; // 1 : 슈퍼컴퓨터 임의 지정
		
		PriorityQueue<Link> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.time, b.time));
		pq.add(new Link(1, 0));
		
		while(!pq.isEmpty()) {
			Link l = pq.poll();
			if(l.time > time[l.to]) continue;
			
			for(Link k : adj[l.to]) {
				int t = l.time + k.time;
				if(t >= time[k.to]) continue;
				time[k.to] = t;
				pq.add(new Link(k.to, t));
			}
		}
		
		int[] trace = new int[N + 1];
		Arrays.fill(trace, 1_000_000);
		trace[1] = 0; 
		
		pq = new PriorityQueue<>((a, b) -> Integer.compare(a.time, b.time));
		pq.add(new Link(1, 0));
		
		HashSet<Integer>[] recover = new HashSet[N + 1]; //복구할 회선 ( A < B : [A] 에만 기록)
		for(int n=1; n<=N; n++) recover[n] = new HashSet<>();
		
		while(!pq.isEmpty()) {
			Link l = pq.poll();
			if(l.time > trace[l.to]) continue;
			
			for(Link k : adj[l.to]) {
				int t = l.time + k.time;
				if(t >= trace[k.to]) continue;
				trace[k.to] = t;
				
				if(t == time[k.to]) { // 복구할 회선
					if(k.to < l.to) recover[k.to].add(l.to);
					else recover[l.to].add(k.to);
				}
				
				pq.add(new Link(k.to, t));
			}
		}
		
		sb.append(N-1).append('\n');
		for(int n=1; n<=N; n++) {
			if(recover[n].isEmpty()) continue;
			for(int a : recover[n]) {
				sb.append(n).append(' ').append(a).append('\n');
			}
		}
		
		System.out.println(sb);
		br.close();
	}

}
