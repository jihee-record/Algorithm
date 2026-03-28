package 백준.백준_2000_2999.백준_2623_음악프로그램_G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_백준_2623_음악프로그램_G3_112ms {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] adj = new ArrayList[N+1];
		for(int n=1; n<=N; n++) adj[n] = new ArrayList<>();
		
		int[] level = new int[N+1];
		for(int m=0; m<M; m++) {  
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			int before = Integer.parseInt(st.nextToken());
			for(int k=1; k<K; k++) {
				int after = Integer.parseInt(st.nextToken());
				adj[before].add(after);
				before = after;
				level[before]++;
			}
		}

		ArrayDeque<Integer> queue = new ArrayDeque<>();
		for(int n=1; n<=N; n++) if(level[n] == 0) queue.add(n);
		
		int cnt = 0;
		while(!queue.isEmpty()) {
			int n = queue.poll();
			cnt++;
			sb.append(n).append('\n');
			
			for(int k : adj[n]) {
				if(--level[k] == 0) {
					queue.add(k);
				}
			}
		}
		
		System.out.println(cnt == N ? sb : 0);
		br.close();
	}

}
