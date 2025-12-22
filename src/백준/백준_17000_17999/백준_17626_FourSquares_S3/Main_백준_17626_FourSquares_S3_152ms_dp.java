package 백준.백준_17000_17999.백준_17626_FourSquares_S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

// 의식의 흐름 60분
public class Main_백준_17626_FourSquares_S3_152ms_dp {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> squares = new ArrayList<>();
		int[] dp = new int[N + 1];
		Arrays.fill(dp, 4);
		
		for(int i=1; i*i<=N; i++) {
			int k = i * i;
			dp[k] = 1;
			squares.add(k);
		}
		
		int i = 0; // n 이하의 제곱수 중 가장 큰 제곱수의 idx
		for(int n=2; n<=N; n++) {
			if(dp[n] == 1) { 
				i++;
				continue;
			}
			
			for(int j = i; j >= 0; j--) {
				int s = squares.get(j);
				if(dp[n] == 2) break;
				
				dp[n] = Math.min(dp[n - s] + 1, dp[n]);
			}
		}
		
		
		System.out.println(dp[N]);
		br.close();
	}

}
