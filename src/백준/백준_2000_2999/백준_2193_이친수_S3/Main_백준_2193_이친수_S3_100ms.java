package 백준.백준_2000_2999.백준_2193_이친수_S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_2193_이친수_S3_100ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long[] dp = new long[N+1];
		dp[1] = 1;
		
		for(int n=2; n<=N; n++) {
			dp[n] = dp[n-1] + dp[n-2];
		}
		
		System.out.println(dp[N]);
		br.close();
	}

}
