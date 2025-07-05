package 백준.백준_9000_9999.백준_9095_123더하기_S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_9095_123더하기_S3_104ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		
		int[] dp = new int[11];
		dp[1] = 1; // 1
		dp[2] = 2; // 1+1, 2
		dp[3] = 4; // 1+1+1, 1+2, 2+1, 3
		
		int idx = 3;
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			if(N > idx) {
				for(int i=idx+1; i<=N; i++) {
					dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
				}
				idx = N;
			}
			sb.append(dp[N]).append("\n");
		}
		
		System.out.println(sb.toString());
		br.close();
	}

}
