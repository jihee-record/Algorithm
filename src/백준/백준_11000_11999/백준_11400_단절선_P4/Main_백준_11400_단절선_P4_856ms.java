package 백준.백준_11000_11999.백준_11400_단절선_P4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_백준_11400_단절선_P4_856ms {
	static int V, E;
	static ArrayList<Integer>[] adj;
	static int[] disc, lowLink;
	static int order;
	static ArrayList<int[]> list;
	
	static void dfs(int u, int parent) { 
//		System.out.println("CHECK: " + u);
		disc[u] = lowLink[u] = order++;
		
		for(int v : adj[u]) {
			if(v == parent) continue;
//			System.out.println(u + "-" + v);
			if(disc[v] == 0) { // 미방분
				dfs(v, u);
				lowLink[u] = Math.min(lowLink[u], lowLink[v]);
				
				if(lowLink[v] > disc[u]) {
					int a = Math.min(u, v);
					int b = Math.max(u, v);
					list.add(new int[] {a, b});
				}
				
			} else { // 방문
				lowLink[u] = Math.min(lowLink[u], disc[v]);
			}
			
		}
		
//		System.out.println("*********");
//		System.out.println("lowLink-" + u + " : " + lowLink[u]);
//		System.out.println("*********");
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		// 작은 숫자가 조상쪽, 연결 그래프
		adj = new ArrayList[V+1];
		for(int v=1; v<=V; v++) adj[v] = new ArrayList<>(); // 루트 1 고정
		
		disc = new int[V+1];
		lowLink = new int[V+1];
		for(int e=0; e<E; e++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			adj[A].add(B);
			adj[B].add(A);
		}
		
		order = 1;
		list = new ArrayList<>();
		dfs(1, 0);
		
		list.sort((a, b) -> {
			if(a[0] != b[0]) return a[0] - b[0];
			return a[1] - b[1];
		});
		
		sb.append(list.size()).append('\n');
		for(int[] arr : list) sb.append(arr[0]).append(' ').append(arr[1]).append('\n');
		
		System.out.print(sb);
		br.close();
	}

}
