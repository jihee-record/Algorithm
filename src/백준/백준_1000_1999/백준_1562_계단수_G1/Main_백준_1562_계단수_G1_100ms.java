package 백준.백준_1000_1999.백준_1562_계단수_G1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_1562_계단수_G1_100ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long[][][] dp = new long[N+1][10][4]; //0-9: 0:(0, 0), 1:(1, 0), 2:(0, 1), 3:(1, 1) 
		for(int i=1; i<9; i++) dp[1][i][0] = 1;
		dp[1][9][2] = 1;
		
		for(int n=2; n<=N; n++) {
			dp[n][0][1] = (dp[n-1][1][0] + dp[n-1][1][1]) % 1000000000;
			dp[n][0][3] = (dp[n-1][1][2] + dp[n-1][1][3]) % 1000000000;
			
			dp[n][9][2] = (dp[n-1][8][0] + dp[n-1][8][2]) % 1000000000;
			dp[n][9][3] = (dp[n-1][8][1] + dp[n-1][8][3]) % 1000000000;
			
			for(int i=1; i<9; i++) { // i != 0, 9
				dp[n][i][0] = (dp[n-1][i-1][0] + dp[n-1][i+1][0]) % 1000000000;
				dp[n][i][1] = (dp[n-1][i-1][1] + dp[n-1][i+1][1]) % 1000000000;
				dp[n][i][2] = (dp[n-1][i-1][2] + dp[n-1][i+1][2]) % 1000000000;
				dp[n][i][3] = (dp[n-1][i-1][3] + dp[n-1][i+1][3]) % 1000000000;
			}
		}
		
		long ans = 0;
		for(int i=0; i<10; i++) {
			ans = (ans + dp[N][i][3]) % 1000000000;
		}
		
		System.out.println(ans);
		br.close();
	}

}
