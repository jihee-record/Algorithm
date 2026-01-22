package 백준.백준_1000_1999.백준_1106_호텔_G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_1106_호텔_G4_104ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken()); // C명
		int N = Integer.parseInt(st.nextToken()); // 도시 N
		
		int[] cost = new int[N];
		int[] profit = new int[N];
		
		int maxProfit = 0;
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			cost[n] = Integer.parseInt(st.nextToken());
			profit[n] = Integer.parseInt(st.nextToken());
			maxProfit = Math.max(maxProfit, profit[n]);
		}
		
		int MAX = C + maxProfit;
		int[] dp = new int[MAX + 1]; // budget
		Arrays.fill(dp, 111111);
		dp[0] = 0;
		for(int i=0; i<=MAX; i++) {
			for(int n=0; n<N; n++) {
				int ni = i + profit[n];
				if(ni > MAX) continue;
				
				dp[ni] = Math.min(dp[ni], dp[i] + cost[n]);
			}
		}
		
		int ans = 111111;
		for(int i=C; i<=MAX; i++) ans = Math.min(ans, dp[i]);
		
		System.out.println(ans);
		br.close();
	}

}
