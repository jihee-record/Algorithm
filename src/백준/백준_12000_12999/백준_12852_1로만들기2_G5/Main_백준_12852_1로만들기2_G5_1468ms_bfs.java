package 백준.백준_12000_12999.백준_12852_1로만들기2_G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main_백준_12852_1로만들기2_G5_1468ms_bfs {
	static class Sol {
		int n;
		int cnt;
		StringBuilder sb;
		
		Sol(int n) {
			this.n = n;
			this.cnt = 0;
			this.sb = new StringBuilder().append(n).append(' ');
		}
		
		Sol (int n, int cnt, StringBuilder sb){
			this.n = n;
			this.cnt = cnt;
			this.sb = new StringBuilder(sb).append(n).append(' ');
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+1];
//		dp[1] = 0;
		
		for(int n=2; n<=N; n++) {
			// 기본값 
			dp[n] = dp[n-1] + 1; // 3. 
			
			if(n % 2 == 0) dp[n] = Math.min(dp[n], dp[n/2] + 1); // 2. 
			if(n % 3 == 0) dp[n] = Math.min(dp[n], dp[n/3] + 1); // 1.
		}
		
		sb.append(dp[N]).append('\n');
		
		ArrayDeque<Sol> stack = new ArrayDeque<>();
		stack.add(new Sol(N));
		
		while(!stack.isEmpty()) {
			Sol now = stack.poll();
			
			if(now.n == 1 && now.cnt == dp[N]) {
				sb.append(now.sb);
				break;
			}
			
			if(now.cnt > dp[N]) continue;
			
			if(now.n % 3 == 0) stack.add(new Sol(now.n / 3, now.cnt + 1, now.sb));
			if(now.n % 2 == 0) stack.add(new Sol(now.n / 2, now.cnt + 1, now.sb));
			stack.add(new Sol(now.n - 1, now.cnt + 1, now.sb));
		}
		
		System.out.print(sb);
		br.close();
	}

}

