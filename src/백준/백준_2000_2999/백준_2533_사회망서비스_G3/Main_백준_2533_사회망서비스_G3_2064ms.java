package 백준.백준_2000_2999.백준_2533_사회망서비스_G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_백준_2533_사회망서비스_G3_2064ms {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] adj = new ArrayList[N+1];
		for(int n=1; n<=N; n++) adj[n] = new ArrayList<>();
		
		for(int n=0; n<N-1; n++) { // 간선 N-1개
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adj[a].add(b);
			adj[b].add(a);
		}
		
		int root = 1; // 무방향
		int[] parent = new int[N+1];
		int[] order = new int[N]; // 방문 순서
		int idx = 0;
		
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		stack.push(root);
		parent[root] = -1; //root의 조상 없음 표시
		
		while(!stack.isEmpty()) {
			int now = stack.pop();
			order[idx++] = now;
			 
			for(int next: adj[now]) {
				if(next == parent[now]) continue;
				parent[next] = now;
				stack.push(next);
			 }
		 }
		 
		int[][] dp = new int[N+1][2]; // 0 : 얼리어답터 x , 1 : o
		for(int n=N-1; n>=0; n--) { // 반대 순서 - 리프부터 
			int u = order[n];
			dp[u][1] = 1; 
//			dp[u][0] = 0;
			
			for(int v : adj[u]) {
				if(v == parent[u]) continue;
				
				dp[u][0] += dp[v][1]; // 내가 얼리가 아니면 나머지가 반드시 얼리여야해
				dp[u][1] += Math.min(dp[v][0], dp[v][1]); // 내가 얼리면 나머지가 얼리든 아니든 상관없어 : 작은거 
			}
		}
		
		System.out.println(Math.min(dp[root][0], dp[root][1]));
		br.close();
	}

}
