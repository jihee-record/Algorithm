package 백준.백준_2000_2999.백준_2225_합분해_G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2225_합분해_G5_104ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		long[][] dp = new long[N+1][K+1];
		for(int k=1; k<=K; k++) dp[0][k] = 1;
		
		for(int n=1; n<=N; n++) {
			for(int k=1; k<=K; k++) {
				// dp[n][k-1] : 마지막 항이 0인 것.
				// dp[n-1][k] : 마지막 항이 1 ~ n인 것.
				dp[n][k] = (dp[n][k-1] + dp[n-1][k]) % 1000000000; 
			}
		}
		
		System.out.println(dp[N][K]);
		br.close();
	}

}
