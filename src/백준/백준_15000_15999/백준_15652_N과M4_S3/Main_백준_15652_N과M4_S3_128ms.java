package 백준.백준_15000_15999.백준_15652_N과M4_S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_15652_N과M4_S3_128ms {
	static StringBuilder sb;
	static int N, M;
	static int[] out;
	
	static void dfs(int n, int depth) {
		if(depth == M) {
			for(int c: out) sb.append(c).append(" ");
			sb.append("\n");
			return;
		}
		
		if(n > N) return;
		
		// n : lowerbound
		for(int i=n; i<=N; i++) {
			out[depth] = i;
			dfs(i, depth+1);
		}
	};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		out = new int[M];
		dfs(1, 0);
		
		System.out.println(sb);
		br.close();
	}

}
