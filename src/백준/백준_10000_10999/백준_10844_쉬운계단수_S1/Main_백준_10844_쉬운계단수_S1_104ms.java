package 백준.백준_10000_10999.백준_10844_쉬운계단수_S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_10844_쉬운계단수_S1_104ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long[][] dp = new long[N+1][10]; // 자릿수, 마지막 숫자
		Arrays.fill(dp[1], 1);
		dp[1][0] = 0; 
		
		for(int n=2; n<=N; n++) {
			dp[n][0] = dp[n-1][1];
			dp[n][9] = dp[n-1][8];
			for(int i=1; i<=8; i++) {
				dp[n][i] = (dp[n-1][i-1] + dp[n-1][i+1]) % 1000000000;
			}
		}
		
		long ans = 0;
		for(int i=0; i<=9; i++) {
			ans = (ans + dp[N][i]) % 1000000000;
		}
		
		System.out.println(ans);
		br.close();
	}

}
