package 백준.백준_1000_1999.백준_1916_최소비용구하기_G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_백준_1916_최소비용구하기_G5_472ms {
	static class Bus {
		int to, cost;
		Bus(int to, int cost) {this.to = to; this.cost = cost;}
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 도시 
		int M = Integer.parseInt(br.readLine()); // 버스
		
		ArrayList<Bus>[] townbus = new ArrayList[N + 1];
		for(int n=1; n<=N; n++) townbus[n] = new ArrayList<>();
		
		while(M --> 0) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			townbus[A].add(new Bus(B, C));
		}
		
		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken()); // 출발지
		int D = Integer.parseInt(st.nextToken()); // 도착지
		
		int[] cost = new int[N + 1];
		Arrays.fill(cost, Integer.MAX_VALUE);
		cost[S] = 0;
		
		PriorityQueue<Bus> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
		pq.add(new Bus(S, 0)); // 출발지, 총 비용 0
		
		while(!pq.isEmpty()) {
			Bus now = pq.poll();
			if(now.cost > cost[now.to]) continue;
			
			for(Bus next : townbus[now.to]) { // 현재위치(now.to)에서 출발하는 버스
				int total = now.cost + next.cost;
				if(total >= cost[next.to]) continue;
				cost[next.to] = total;
				pq.add(new Bus(next.to, total));
			}
			
		}
		
		System.out.println(cost[D]);
		br.close();
	}

}
