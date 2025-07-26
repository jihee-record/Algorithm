package 백준.백준_1000_1999.백준_1699_제곱수의합_S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_1699_제곱수의합_S2_144ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] dp = new int[N+1];
		
		for(int n=1; n<=N; n++) {
			dp[n] = n;
			for(int k=1; k*k <= n; k++) {
				dp[n] = Math.min(dp[n], dp[n - k*k] + 1);
			}
		}
		
		System.out.println(dp[N]);
		br.close();
	}
}
