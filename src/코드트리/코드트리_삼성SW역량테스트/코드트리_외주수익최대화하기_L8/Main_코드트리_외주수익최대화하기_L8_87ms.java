package 코드트리.코드트리_삼성SW역량테스트.코드트리_외주수익최대화하기_L8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_코드트리_외주수익최대화하기_L8_87ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] time = new int[N+1];
		int[] price = new int[N+1];
		int[] dp = new int[N+1];
		
		for(int n=1; n<=N; n++) {
			st = new StringTokenizer(br.readLine());
			time[n] = Integer.parseInt(st.nextToken());
			price[n] = Integer.parseInt(st.nextToken());

			if(time[n] ==  1) dp[n] = dp[n-1] + price[n]; 
			else dp[n] = dp[n-1];
			
			for(int k=1; k<Math.min(n, 6); k++) {
				int start = n - k; // k일 전 시작
				if(time[start] == k + 1) {   
					dp[n] = Math.max(dp[n], dp[start-1] + price[start]);
				}
			}
		}
		
		System.out.println(dp[N]);
		br.close();
	}

}
