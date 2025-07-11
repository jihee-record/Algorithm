package 백준.백준_1000_1999.백준_1463_1로만들기_S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_1463_1로만들기_S3_128ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+1];
		for(int n=2; n<=N; n++) {
			dp[n] = dp[n-1] + 1; // -1
			
			if(n % 3 == 0) {
				dp[n] = Math.min(dp[n/3] + 1, dp[n]); // /3
			}
			
			if(n % 2 == 0) {
				dp[n] = Math.min(dp[n/2] + 1, dp[n]); // /2
			}
		}

		System.out.println(dp[N]);
		br.close();
	}

}
