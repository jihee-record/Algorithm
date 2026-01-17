package 백준.백준_18000_18999.백준_18015_어려운계단수_P4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_18015_어려운계단수_P4_432ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int last = B-1; // last digit 

		long[][][] dp = new long[N+1][B][4]; // 0-last: 0:(0, 0), 1:(1, 0), 2:(0, 1), 3:(1, 1) 
		for(int b=1; b<last; b++) {
			dp[1][b][0] = 1;
		}
		dp[1][last][2] = 1; 
		
		
		for(int n=2; n<=N; n++) {
			dp[n][0][1] = (dp[n-1][1][0] + dp[n-1][1][1]) % 1000000000;
			dp[n][0][3] = (dp[n-1][1][2] + dp[n-1][1][3]) % 1000000000;
			
			dp[n][last][2] = (dp[n-1][last-1][0] + dp[n-1][last-1][2]) % 1000000000;
			dp[n][last][3] = (dp[n-1][last-1][1] + dp[n-1][last-1][3]) % 1000000000;
			
			for(int i=1; i<last; i++) { // i != 0, last
				dp[n][i][0] = (dp[n-1][i-1][0] + dp[n-1][i+1][0]) % 1000000000;
				dp[n][i][1] = (dp[n-1][i-1][1] + dp[n-1][i+1][1]) % 1000000000;
				dp[n][i][2] = (dp[n-1][i-1][2] + dp[n-1][i+1][2]) % 1000000000;
				dp[n][i][3] = (dp[n-1][i-1][3] + dp[n-1][i+1][3]) % 1000000000;
			}
		}
		
		long ans = 0;
		for(int i=0; i<B; i++) {
			ans = (ans + dp[N][i][3]) % 1000000000;
		}
		
		System.out.println(ans);
		br.close();
	}

}
