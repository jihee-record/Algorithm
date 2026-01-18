package 백준.백준_14000_14999.백준_14588_LineFriends_G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_14588_LineFriends_G5_196ms {
	static class Coordi {
		int l, r;
		
		Coordi(){}
		Coordi(int l, int r) {
			this.l = l;
			this.r = r;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); 
		Coordi[] lines = new Coordi[N+1];
		
		for(int n=1; n<=N; n++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			lines[n] = new Coordi(l, r); 
		}
		
		int[][] dp = new int[N+1][N+1];

		for(int i=1; i<=N; i++) {
			Coordi u = lines[i];
			for(int j=i+1; j<=N; j++) {
				Coordi v = lines[j];
				
				if((u.l <= v.l && u.r >= v.l) || (u.l >= v.l && v.r >= u.l)) {
//				if(Math.max(u.l, v.l)  <= Math.min(u.r, v.r)) {
					dp[i][j] = 1;
					dp[j][i] = 1;
				
				}else {
					dp[i][j] = N; // Max Value 
					dp[j][i] = N;
				}
			}
		}
		
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++){
				if(dp[i][k] == N) continue;
				for(int j=1; j<=N; j++) {
//					System.out.println("BEFORE:" + i + ", " + j + ") " + dp[i][j] );
					dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
//					System.out.println("AFTER:" + i + ", " + j + ") " + dp[i][j] );
				}
			}
		}

		int Q = Integer.parseInt(br.readLine());
		for(int q=0; q<Q; q++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			sb.append(dp[a][b] == N ? -1 : dp[a][b]).append('\n');
		}
		
		System.out.println(sb);
		br.close();
	}

}
