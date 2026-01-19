package 백준.백준_12000_12999.백준_12852_1로만들기2_G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_12852_1로만들기2_G5_124ms_dp {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+1];
//		dp[1] = 0;
		
		for(int n=2; n<=N; n++) {
			// 기본값 
			dp[n] = dp[n-1] + 1; // 3. 
			
			if(n % 2 == 0) dp[n] = Math.min(dp[n], dp[n/2] + 1); // 2. 
			if(n % 3 == 0) dp[n] = Math.min(dp[n], dp[n/3] + 1); // 1.
		}
		
		sb.append(dp[N]).append('\n');
		
		while(N != 1) {
			sb.append(N).append(' ');
			
			if(N % 3 == 0 && dp[N] == dp[N/3] + 1) N /= 3;
			else if(N % 2 == 0 && dp[N] == dp[N/2] + 1) N /= 2;
			else N--;
		}
		
		sb.append(1);
		System.out.print(sb);
		br.close();
	}

}
