package 백준.백준_15000_15999.백준_15666_N과M12_S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_백준_15666_N과M12_S2_120ms_hashset {
	static StringBuilder sb;
	static int N, M, K;
	static int[] arr, out;
   
	static void dfs(int k, int depth) {
		if(depth == M) {
			for(int i=0; i<M; i++) sb.append(out[i]).append(' ');
			sb.append('\n');
			return;
		}
		
		for(int i=k; i<K; i++) {
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
	   
		HashSet<Integer> set = new HashSet<>();
	   
		st = new StringTokenizer(br.readLine());
		for(int n=0; n<N; n++) set.add(Integer.parseInt(st.nextToken()));
	   
		K = set.size();
		arr = new int[K];
	   
		int i=0;
		for(int c : set) arr[i++] = c;
	   
		Arrays.sort(arr);
	   
		out = new int[M];
		dfs(0, 0);
	   
		System.out.println(sb);
		br.close();
	}

}
