package 백준.백준_15000_15999.백준_15990_123더하기5_S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_15990_123더하기5_S1_140ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		int[] caseNo = new int[T];
		int max = 0;
		
		for(int t=0; t<T; t++) {
			caseNo[t] = Integer.parseInt(br.readLine());
			max = Math.max(max, caseNo[t]);
		}
		
		long[][] dp = new long[max + 1][4];
		dp[1][1] = 1;
		
		if(max > 1) dp[2][2] = 1;
		if(max > 2) {
			dp[3][1] = 1; // dp[2][2] + dp[2][3]
			dp[3][2] = 1; // dp[1][1] + dp[1][3]
			dp[3][3] = 1; // 
		}
		
		for(int n=4; n<=max; n++) {
			dp[n][1] = (dp[n-1][2] + dp[n-1][3]) % 1000000009;
			dp[n][2] = (dp[n-2][1] + dp[n-2][3]) % 1000000009;
			dp[n][3] = (dp[n-3][1] + dp[n-3][2]) % 1000000009;
		}
		
		for(int t=0; t<T; t++) {
			sb.append((dp[caseNo[t]][1] + dp[caseNo[t]][2] + dp[caseNo[t]][3]) % 1000000009).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}

}
