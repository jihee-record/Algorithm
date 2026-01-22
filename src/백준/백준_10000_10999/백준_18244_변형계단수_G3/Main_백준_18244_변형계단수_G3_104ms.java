package 백준.백준_10000_10999.백준_18244_변형계단수_G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_18244_변형계단수_G3_104ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// 0르호 시작 가능
		long[][][] dp = new long[N+1][10][5]; // 0~9 // 0 : 길이1/ 1, 2 : increase 1,2 / 3, 4 : decrease 1,2   
		for(int i=0; i<10; i++) dp[1][i][0] = 1;

		if(N >= 2) {
			dp[2][0][3] = 1; // 1-0
			dp[2][9][1] = 1; // 8-9
			for(int i=1; i<=8; i++) {
				dp[2][i][1] = 1; // i-1 - 1
				dp[2][i][3] = 1; // i+1 - 1
			}
		}
		
		for(int n=3; n<=N; n++) {
			dp[n][0][3] = dp[n-1][1][1]; // 0-1-0, 
			dp[n][0][4] = dp[n-1][1][3]; // 2-1-0 ( 1-2-1-0, 3-2-1-0 x)
			dp[n][9][1] = dp[n-1][8][3]; // 9-8-9
			dp[n][9][2] = dp[n-1][8][1]; // 7-8-9 
			
			for(int i=1; i<=8; i++) {
				dp[n][i][1] = (dp[n-1][i-1][3] + dp[n-1][i-1][4]) % 1000000007; // increase 1) i=3 : 2-3-(2-3), 4-3-(2-3) 
				dp[n][i][2] = dp[n-1][i-1][1]; // increase 2) i=3 (1-2-3)
				dp[n][i][3] = (dp[n-1][i+1][1] + dp[n-1][i+1][2]) % 1000000007;// decrease 1) i=3: 4-3-(4-3), 2-3-(4-3)
				dp[n][i][4] = dp[n-1][i+1][3]; // decrease 2) i=3 (5-4-3)
			}
		}
		
		long ans = 0;
		for(int i=0; i<10; i++) {
			for(int j=0; j<5; j++) {
				ans = (ans + dp[N][i][j]) % 1000000007;
			}
		}
		
		System.out.println(ans);
		br.close();
	}

}
