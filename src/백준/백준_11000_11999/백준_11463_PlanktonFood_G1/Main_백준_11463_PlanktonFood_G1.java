package 백준.백준_11000_11999.백준_11463_PlanktonFood_G1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_11463_PlanktonFood_G1 {
	static class Edge {
		int u, v;
		double w;
		
		Edge() {}
		
		Edge(int u, int v, double w){
			this.u = u;
			this.v = v;
			this.w = w;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			int T = Integer.parseInt(st.nextToken()); // edge
			int F = Integer.parseInt(st.nextToken()); // vertex
			int U = Integer.parseInt(st.nextToken()); // start - 줄 것
			int N = Integer.parseInt(st.nextToken()); // end - 받을 것
			
			if(T == 0) break;
			
			Edge[] edges = new Edge[T];
			ArrayList<Integer>[] rev = new ArrayList[F+1];
			for(int f=1; f<=F; f++) rev[f] = new ArrayList<>();
			
			for(int i=0; i<T; i++) {
				st = new StringTokenizer(br.readLine());
				
				int R = Integer.parseInt(st.nextToken());
				int G = Integer.parseInt(st.nextToken());
				double W = Double.parseDouble(st.nextToken()); // r을 주고 g을 받을 때 양
				
				edges[i] = new Edge(R, G, -W); // 벨만 포드를 이용해서 음수사이클 체크를 하기 위해 -W로 저장 (음수 : 먹이 생산)
				rev[G].add(R);
			}
			
			double[] dp = new double[F+1];
			Arrays.fill(dp, Double.MAX_VALUE);
			dp[U] = 0.0;
			

			for(int f=1; f<F; f++) {
				boolean updated = false;
				
				for(Edge e : edges) {
					if(dp[e.u] != Double.MAX_VALUE && dp[e.v] > dp[e.u] + e.w) {
						dp[e.v] = dp[e.u] + e.w;
						updated = true;
					}
				}
				
				if(!updated) break;
			}
			
			boolean[] neg = new boolean[F+1]; // 갱신되는 음수 사이클 영향권
			for(Edge e : edges) {
				if(dp[e.u] != Double.MAX_VALUE && dp[e.v] > dp[e.u] + e.w) {
					dp[e.v] = dp[e.u] + e.w;
					neg[e.v] = true;
				}
			}
			
			boolean[] canReachN = new boolean[F+1]; // N까지 갈수있는 정점
			ArrayDeque<Integer> queue = new ArrayDeque<>();
			queue.add(N);
			canReachN[N] = true;
			
			while(!queue.isEmpty()) {
				int now = queue.poll();
				
				for(int prev : rev[now]) {
					if(!canReachN[prev]) {
						canReachN[prev] = true;
						queue.add(prev);
					}
				}
			}
			
			// 교집합 체크
			boolean ok = false;
			for(int f=1; f<=F; f++) {
				if(neg[f] && canReachN[f]) {
					ok = true;
					break;
				}
			}
			
			sb.append(ok ? "TRUE\n" : "FALSE\n");
		}
		
		System.out.println(sb);
		br.close();
		
	}

}
