package 백준.백준_11000_11999.백준_11727_2n타일링2_S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_11727_2n타일링2_S3_104ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+1];
		dp[0] = 1;
		dp[1] = 1;
		
		for(int n=2; n<=N; n++) {
			dp[n] = (dp[n-1] + 2 * dp[n-2]) % 10007;
		}
		
		System.out.println(dp[N]);
		br.close();
	}

}
