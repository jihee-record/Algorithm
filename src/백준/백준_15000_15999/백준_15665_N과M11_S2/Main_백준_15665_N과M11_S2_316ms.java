package 백준.백준_15000_15999.백준_15665_N과M11_S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * N개의 자연수 중에서 M개를 고른 수열
 * 같은 수를 여러 번 골라도 된다.
 * 
 * 중복으로 주어질 수 있음
 */
public class Main_백준_15665_N과M11_S2_316ms {
	static StringBuilder sb;
	static int N, M;
	static int[] arr, out;

	static void dfs(int n, int depth) {
		if(depth == M) {
			for (int i=0; i<M; i++) {
				sb.append(out[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		int prev = 0;
		for(int i=0; i<N; i++) {
			if(arr[i] == prev) continue;
			prev = arr[i];
			
			out[depth] = arr[i];
			dfs(i, depth + 1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int n=0; n<N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		out = new int[M];
		dfs(0, 0);
		
		System.out.println(sb);
		br.close();
	}
	

}
