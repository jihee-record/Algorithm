package 백준.백준_15000_15999.백준_15649_N과M1_S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_15649_N과M1_S3_244ms {
	static StringBuilder sb; 
	static int N, M;
	static boolean[] used;
	static int[] out;
	
	static void dfs(int depth) {
		if(depth == M) {
			for(int c: out) sb.append(c).append(" ");
			sb.append("\n");
			return;
		}
		
		// 순서 뒤집혀도 뽑을 수 있도록
		for(int n=1; n<=N; n++) {
			if(used[n]) continue;
			used[n] = true;
			out[depth] = n;
			dfs(depth + 1); // n을 뽑았으니 다음 선택 개수 증가
			used[n] = false; // 제거
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		used = new boolean[N+1];
		out = new int[M];

		// choice 0개
		dfs(0);
		
		System.out.println(sb);
		br.close();
	}

}
