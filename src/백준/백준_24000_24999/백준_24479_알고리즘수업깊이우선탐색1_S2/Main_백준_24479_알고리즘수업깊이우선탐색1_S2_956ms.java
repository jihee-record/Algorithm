package 백준.백준_24000_24999.백준_24479_알고리즘수업깊이우선탐색1_S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_백준_24479_알고리즘수업깊이우선탐색1_S2_956ms {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		List<Integer>[] graph = new ArrayList[N+1];
		for(int n=1; n<=N; n++) {
			graph[n] = new ArrayList<>();
		}

		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph[u].add(v);
			graph[v].add(u);
		}
		
		int order = 1;
		int[] visited = new int[N+1]; // 순번
		Stack<Integer> stack = new Stack<>();
		stack.add(R);
		while(!stack.isEmpty()) {
			int now = stack.pop();
			if(visited[now] > 0) continue;
			
			visited[now] = order++;
			Collections.sort(graph[now], Collections.reverseOrder());
			for(int i : graph[now]) {
				stack.add(i);
			}
		}
		
		for(int n=1; n<=N; n++) {
			sb.append(visited[n]).append("\n");
		}
		
		System.out.println(sb.toString());
		br.close();
	}

}
