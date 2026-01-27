package 백준.백준_15000_15999.백준_15651_N과M3_S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_15651_N과M3_S3_392ms {
	static StringBuilder sb;
	static int N, M;
	static int[] out;
	
	static void dfs(int depth) {
		if(depth == M) {
			for(int i=0; i<M; i++)sb.append(out[i]).append(" ");
			sb.append("\n");
			return;
		}
		
		for(int n=1; n<=N; n++) {
			out[depth] = n;
			dfs(depth+1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		out = new int[M];
		
		dfs(0);
		
		System.out.println(sb);
		br.close();
	}

}
