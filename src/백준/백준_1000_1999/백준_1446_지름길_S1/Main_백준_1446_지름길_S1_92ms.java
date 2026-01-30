package 백준.백준_1000_1999.백준_1446_지름길_S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_1446_지름길_S1_92ms {
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
		int N = Integer.parseInt(st.nextToken()); // 지름길 개수
		int D = Integer.parseInt(st.nextToken()); // 고속도로 길이
		
		ArrayList<Edge>[] edges = new ArrayList[D]; // 출발점
		for(int d=0; d<D; d++) edges[d] = new ArrayList<>();
		
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			if(to > D) continue; // 딱 D에 도착해야하고 역주행 불가
			if(dist > to - from) continue; // 기본 거리보다 긴 지름길
			edges[from].add(new Edge(to, dist));
		}
		
		int[] dp = new int[D+1];
		Arrays.fill(dp, 10000);
		dp[0] = 0;
		
		for(int i=0; i<D; i++) { // 출발점
			dp[i+1] = Math.min(dp[i+1], dp[i] + 1);
			for(Edge e : edges[i]) {
				dp[e.to] = Math.min(dp[e.to], dp[i] + e.dist);
			}
		}
		
		System.out.println(dp[D]);
		br.close();
	}

}
