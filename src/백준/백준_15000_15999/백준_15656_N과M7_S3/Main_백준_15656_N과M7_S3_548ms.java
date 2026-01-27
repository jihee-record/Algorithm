package 백준.백준_15000_15999.백준_15656_N과M7_S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 서로 다른 숫자 N개 중에서 중복하여 M개 선택 (순열) 
public class Main_백준_15656_N과M7_S3_548ms {
	static StringBuilder sb;
	static int N, M;
	static int[] arr, out;
	
	static void dfs(int n, int depth) {
		if(depth == M) {
			for(int i=0; i<M; i++) sb.append(out[i]).append(' ');
			sb.append('\n');
			return;
		}
		
		for(int i=0; i<N; i++) {
			out[depth] = arr[i];
			dfs(i, depth + 1);
		}
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
