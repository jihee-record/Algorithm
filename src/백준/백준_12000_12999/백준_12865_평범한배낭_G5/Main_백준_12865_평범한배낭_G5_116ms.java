package 백준.백준_12000_12999.백준_12865_평범한배낭_G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_12865_평범한배낭_G5_116ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 물품 수
		int K = Integer.parseInt(st.nextToken()); // 무게
		
		int[] W = new int[N];
		int[] V = new int[N];
		
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			W[n] = Integer.parseInt(st.nextToken());
			V[n] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[K+1];
		for(int n=0; n<N; n++) {
			int w = W[n];
			int v = V[n];
			for(int m=K; m>=w; m--) {
				dp[m] = Math.max(dp[m], dp[m-w] + v);
			}
		}
		
		System.out.println(dp[K]);
		br.close();
	}

}
