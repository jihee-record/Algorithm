package 백준.백준_1000_1999.백준_1562_계단수_G1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_1562_계단수_G1_184ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long[][][] dp = new long[N+1][10][1<<10];
		for(int i=1; i<=9; i++) dp[1][i][1<<i] = 1;
		
		for(int n=2; n<=N; n++) {
			for(int mask=0; mask<(1<<10); mask++) {
				dp[n][0][mask | (1<<0)] = (dp[n][0][mask | (1<<0)] + dp[n-1][1][mask]) % 1000000000;
				dp[n][9][mask | (1<<9)] = (dp[n][9][mask | (1<<9)] + dp[n-1][8][mask]) % 1000000000;
				
				for(int i=1; i<9; i++) {
					int nmask = mask | (1<<i);
					dp[n][i][nmask] = (dp[n][i][nmask] + dp[n-1][i-1][mask]) % 1000000000;
					dp[n][i][nmask] = (dp[n][i][nmask] + dp[n-1][i+1][mask]) % 1000000000;
				
				}
			}
		}
		
		long ans = 0;
		for(int i=0; i<10; i++) {
			ans = (ans + dp[N][i][(1<<10)-1]) % 1000000000;
		}
		
		System.out.println(ans);
		br.close();
	}

}
