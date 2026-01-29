package 백준.백준_1000_1999.백준_1939_중량제한_G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_백준_1939_중량제한_G3_448ms {
	static class Bridge {
		int B, C;
		Bridge(int B, int C) {this.B = B; this.C = C;}
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Bridge>[] adj = new ArrayList[N+1];
		for(int n=1; n<=N; n++) adj[n] = new ArrayList<>();
		
		int max = 0; // 중량 최대
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			adj[A].add(new Bridge(B, C));
			adj[B].add(new Bridge(A, C));
			
			max = Math.max(max, C); 
		}
		
		st = new StringTokenizer(br.readLine());
		int depart = Integer.parseInt(st.nextToken());
		int arrive = Integer.parseInt(st.nextToken());
		
		int l = 1, r = max, ans = 0;
		while(l <= r) {
			int mid = l + (r - l) / 2;
			
			boolean[] visited = new boolean[N+1];
			ArrayDeque<Integer> queue = new ArrayDeque<>(); 
			visited[depart] = true;
			queue.offer(depart);
			
			boolean flag = false;
			while(!queue.isEmpty()) {
				int now = queue.poll();
				if(now == arrive) {
					flag = true;
					break;
				}
				
				for(Bridge u: adj[now]) {
					if(visited[u.B]) continue;
					if(mid > u.C) continue; // mid : 중량, C : 제한
					
					visited[u.B] = true;
					queue.offer(u.B);
				}
			}
			
			if(flag) {
				ans = mid;
				l = mid + 1;
			}else {
				r = mid - 1;
			}
		}
		
		System.out.println(ans);
		br.close();
	}

}
