package 백준.백준_15000_15999.백준_15663_N과M9_S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_15663_N과M9_S2_168ms {
	static StringBuilder sb;
	static int N, M;
	static int[] arr, out;
	static boolean[] used;
	
	static void dfs(int depth) {
		if(depth == M) {
			for(int m=0; m<M; m++) sb.append(out[m]).append(' ');
			sb.append('\n');
			return;
		}
		
		for(int n=0; n<N; n++) {
			if(used[n]) continue;
			if (n > 0 && arr[n] == arr[n-1] && !used[n-1]) continue; // 1 - 7 , 1 (7) 7 x
			
			used[n] = true;
			out[depth] = arr[n];
			dfs(depth + 1);
			used[n] = false;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int n=0; n<N; n++) arr[n] = Integer.parseInt(st.nextToken());

		Arrays.sort(arr);
		
		used = new boolean[N];
		out = new int[M];
		
		dfs(0);
		
		System.out.println(sb);
		br.close();
		
	}

}
