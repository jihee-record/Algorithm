package 백준.백준_1000_1999.백준_1912_연속합_S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1912_연속합_S2_232ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+1];
		
		int max = Integer.MIN_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {	
			int k = Integer.parseInt(st.nextToken());
			dp[i] = Math.max(dp[i-1] + k, k);
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
		br.close();
	}

}
