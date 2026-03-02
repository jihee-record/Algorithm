package 백준.백준_14000_14999.백준_14567_선수과목_G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_14567_선수과목_G5_544ms_topology {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 과목 수
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] adj = new ArrayList[N+1]; 
		for(int n=1; n<=N; n++) adj[n] = new ArrayList<>();
		
		int[] level = new int[N+1];
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			adj[A].add(B); // B : A의 follow
			level[B]++;
		}
		
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		for(int n=1; n<=N; n++) if(level[n] == 0) queue.add(n);
		
		int[] answer = new int[N+1];
		Arrays.fill(answer, 1);
		
		while(!queue.isEmpty()) {
			int n = queue.poll();
			
			for(int k : adj[n]) {
				answer[k] = answer[n] + 1;
				if(--level[k] == 0) {
					queue.add(k);
				}
			}
		}
		
		for(int n=1; n<=N; n++) sb.append(answer[n]).append(' ');
		System.out.println(sb);
		br.close();
	}

}
