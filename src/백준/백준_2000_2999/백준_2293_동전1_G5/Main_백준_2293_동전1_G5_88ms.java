package 백준.백준_2000_2999.백준_2293_동전1_G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_2293_동전1_G5_88ms {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");

		int n = Integer.parseInt(str[0]);
		int k = Integer.parseInt(str[1]);
		
		int[] coin = new int[n];
		int[] dp = new int[k+1];
		dp[0] = 1;
		
		for(int i=0; i<n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
			for(int j=coin[i]; j<=k; j++) {
				dp[j] = dp[j] + dp[j-coin[i]];
			}
		}
		
		System.out.println(dp[k]);
		br.close();
	}
}
