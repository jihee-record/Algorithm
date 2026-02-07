package 백준.백준_9000_9999.백준_9251_LCS_G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_9251_LCS_G4_136ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in ));
		
		String s1 = br.readLine();
		String s2 = br.readLine();
		
		int N = s1.length();
		int M = s2.length();
		
		int[][] dp = new int[N+1][M+1];
		
		for(int n=1; n<=N; n++) {
			for(int m=1; m<=M; m++) {
				if(s1.charAt(n-1) == s2.charAt(m-1)) {
					dp[n][m] = dp[n-1][m-1] + 1;
				}else {
					dp[n][m] = Math.max(dp[n-1][m], dp[n][m-1]);
				}
			}
		}
		
		System.out.println(dp[N][M]);
		br.close();
	}

}
