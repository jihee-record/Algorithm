package 백준.백준_14000_14999.백준_14501_퇴사_S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_14501_퇴사_S3_100ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] T = new int[N+1];
		int[] P = new int[N+1];
		
		int[] dp = new int[N+1];
		for(int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			T[n] = Integer.parseInt(st.nextToken());
			P[n] = Integer.parseInt(st.nextToken());
			
			if(T[n] == 1) dp[n] = dp[n-1] + P[n];
			else dp[n] = dp[n-1];
			
			for(int k = 1; k < Math.min(n, 6); k++) { //5일까지 가능 그리고, n과 같으면 0일차에 시작이라 불가능
				int start = n - k; // k일 전에 시작
				if(T[start] == k + 1) { //  k + 1일 걸려야 오늘 종료
					dp[n] = Math.max(dp[n], dp[start - 1] + P[start]);
				}
				
			}
		}
		
		System.out.println(dp[N]);
		br.close();
	}

}
