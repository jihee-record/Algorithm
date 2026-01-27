package 백준.백준_15000_15999.백준_15655_N과M6_S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_15655_N과M6_S3_100ms {
	static StringBuilder sb;
	static int N, M;
	static int[] arr, out;
	
	static void dfs(int n, int depth) {
		if(depth == M) {
			for(int i=0; i<M; i++) sb.append(out[i]).append(' ');
			sb.append('\n');
			return;
		}
		
		if(n >= N) return;
		
		out[depth] = arr[n];
		dfs(n + 1, depth + 1);
		dfs(n + 1, depth);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int n=0; n<N; n++) arr[n] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		
		out = new int[M];
		dfs(0, 0);
		
		System.out.println(sb);
		br.close();
	}

}
