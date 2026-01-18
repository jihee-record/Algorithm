package 백준.백준_14000_14999.백준_14588_LineFriends_G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_14588_LineFriends_G5 {
	static class Coordi {
		int l, r, n;
		
		Coordi(){}
		Coordi(int n, int l, int r) {
			this.n = n;
			this.l = l;
			this.r = r;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); 
		Coordi[] lines = new Coordi[N];
		
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			lines[n] = new Coordi(n+1, l, r); 
		}
		
		Arrays.sort(lines, (a, b) -> {
			if(a.l != b.l) return Integer.compare(a.l, b.l);
			return Integer.compare(a.r, b.r);
		});
		
		int[][] dp = new int[N+1][N+1];
		for(int n=1; n<=N; n++) Arrays.fill(dp[n], Integer.MAX_VALUE);

		for(int n=0; n<N; n++) {
			Coordi u = lines[n];

			int r = u.r; 
			int cnt = 1;
			for(int k=n+1; k<N; k++) {
				Coordi v = lines[k];
				if(r < v.l) break; // 이제 친구 못됨
				if(u.r >= v.l) {
					dp[u.n][v.n] = 1;
					dp[v.n][u.n] = 1;
				} else {
					// 친구의 친구
					if(r < v.r) cnt++;
					dp[u.n][v.n] = cnt;
					dp[v.n][u.n] = cnt;
				}
				
				if(r < v.r) r = v.r;
			}
		}

		int Q = Integer.parseInt(br.readLine());
		for(int q=0; q<Q; q++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			sb.append(dp[a][b] == Integer.MAX_VALUE ? -1 : dp[a][b]).append('\n');
		}
		
		System.out.println(sb);
		br.close();
	}

}
