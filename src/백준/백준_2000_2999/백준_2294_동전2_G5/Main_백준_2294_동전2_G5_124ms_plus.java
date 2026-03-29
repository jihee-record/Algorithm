package 백준.백준_2000_2999.백준_2294_동전2_G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_2294_동전2_G5_124ms_plus {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 입력 줄
		int K = Integer.parseInt(st.nextToken()); // k원
		
		int[] price = new int[N];
		for(int n=0; n<N; n++) {
			price[n] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(price);
		
		int[] dp = new int[K+1];
		Arrays.fill(dp, 10001);
		for(int n=0; n<N && price[n] <= K; n++) dp[price[n]] = 1;
		for(int i=price[0]; i<=K; i++) { 
			for(int n=0; n<N; n++) {
				if(n > 0 && price[n] == price[n-1]) continue; // 중복 동전 방지
				int k = i + price[n];
				if(k > K) break;
				dp[k] = Math.min(dp[i] + 1, dp[k]);
			}
		}
		
		System.out.println(dp[K] == 10001 ? -1 : dp[K]);
		br.close();
	}

}
