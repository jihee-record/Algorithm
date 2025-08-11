package 백준.백준_11000_11999.백준_11052_카드구매하기_S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_11052_카드구매하기_S1_124ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n=1; n<=N; n++) {
			dp[n] = Integer.parseInt(st.nextToken());
		}
		
		for(int n=1; n<=N; n++) {
			for(int k=1; k<n; k++) {
				dp[n] = Math.max(dp[n], dp[k] + dp[n-k]);
			}
		}
		
		System.out.println(dp[N]);
		br.close();
	}

}
