package 백준.백준_14000_14999.백준_14567_선수과목_G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_14567_선수과목_G5_504ms {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 과목 수
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] adj = new ArrayList[N+1]; // 선수과목
		for(int n=1; n<=N; n++) adj[n] = new ArrayList<>();
		
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			adj[B].add(A); // A : B의 선수 과목 
		}
		
		int[] dp = new int[N+1];
		Arrays.fill(dp, 1); // 선수 없으면 1학기 수강 가능
		
		for(int n=1; n<=N; n++) {
			for(int k : adj[n]) { // 선수과목
				dp[n] = Math.max(dp[n], dp[k] + 1);
			}
		}
		
		for(int n=1; n<=N; n++) sb.append(dp[n]).append(' ');
		System.out.println(sb);
		br.close();
	}

}
