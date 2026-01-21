package 백준.백준_11000_11999.백준_11404_플로이드_G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_11404_플로이드_G4 {
	static class Bus {
		int depart, arrive, cost;
		
		Bus() {}
		Bus(int depart, int arrive, int cost) {
			this.depart = depart;
			this.arrive = arrive;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 도시
		int M = Integer.parseInt(br.readLine()); // 버스
		
		int[][] dp = new int[N+1][N+1];
		for(int n=1; n<=N; n++) {
			Arrays.fill(dp[n], 10000001);
			dp[n][n] = 0;
		}
		
		for(int m=1; m<=M; m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken()); // cost
			
			dp[a][b] = Math.min(dp[a][b], c);
		}
		
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
				}
			}
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				sb.append((dp[i][j] == 10000001) ?  0 : dp[i][j]).append(' ');
			}
			sb.append('\n');
		}

		System.out.println(sb);
		br.close();
	}

}
