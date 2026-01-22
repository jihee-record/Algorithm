package 백준.백준_1000_1999.백준_1368_물대기_G2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 완전 연결 그래프 - 연결 불가능한 경우 없음
// mst - prim 
@SuppressWarnings("unchecked")
public class Main_백준_1368_물대기_G2 {
	
	static class Edge {
		int j;
		int cost;
		
		Edge(){}
		Edge(int j, int cost){
			this.j = j;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int minSelf = 100001;
		int start = 0;
		
		int[] self = new int[N+1];
		ArrayList<Edge>[] adj = new ArrayList[N+1]; // 인접리트스
		for(int n=1; n<=N; n++) {
			adj[n] = new ArrayList<>();
			
			self[n] = Integer.parseInt(br.readLine());
			
			if(self[n] < minSelf) { // 어차피 한 곳은 반드시 뚫어야 하니까 비용이 적은 곳부터 팜
				minSelf = self[n];
				start = n;
			}
		}
		
		// 원래는 트라이앵글만 받으면 되는데..
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				int k = Integer.parseInt(st.nextToken());
				
				if(i == j) continue;
				
				adj[i].add(new Edge(j, k));
				adj[j].add(new Edge(i, k));
			}
		}
		
		boolean[] visited = new boolean[N+1];
		PriorityQueue<Edge> pq = new PriorityQueue<>((e, f) -> Integer.compare(e.cost, f.cost));
		pq.add(new Edge(start, self[start]));
		
		int total = 0; // total cost
		int cnt = 0; // place count
		while(cnt < N) {
			Edge e = pq.poll();
			int j = e.j;
			
			System.out.println(e.j + ". cost:" + e.cost);
			if(visited[j]) continue;
			
			visited[j] = true;
			total += Math.min(e.cost, self[j]);
			cnt++;
			System.out.println("total:" + total + ", cnt: " + cnt);
			System.out.println();
			for(Edge f: adj[j]) {
				System.out.println("간선 체크");
				System.out.println(f.j + ". cost:" + f.cost);
				if(visited[f.j]) continue;
				System.out.println(e.j + "-" + f.j + " 추가");
				pq.add(f);
			}
			
		}
		
		System.out.println(total);
		br.close();
		
	}

}
