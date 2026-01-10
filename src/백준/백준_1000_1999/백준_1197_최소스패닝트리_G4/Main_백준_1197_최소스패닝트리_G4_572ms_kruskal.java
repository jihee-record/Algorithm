package 백준.백준_1000_1999.백준_1197_최소스패닝트리_G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// mst 크루스칼
public class Main_백준_1197_최소스패닝트리_G4_572ms_kruskal {
	static int[] parent;
	
	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x == y) return false;
		
		if(x < y) parent[y] = x;
		else parent[x] = y;
		
		return true;
	}
	
	static int find(int x) {
		if(x == parent[x]) return x;
		return parent[x] = find(parent[x]);
	}
	
	static class Edge{
		int A;
		int B;
		int value;
		
		Edge(){}
		Edge(int A, int B, int value){
			this.A = A;
			this.B = B;
			this.value = value;
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken()); // 정점의 개수
		int E = Integer.parseInt(st.nextToken()); // 간선의 개수
		
		parent = new int[V+1];
		for(int v=1; v<=V; v++) {
			parent[v] = v;
		}
		
		Edge[] edges = new Edge[E];
		// |AB| = C, |C| <= 1,000,000
		for(int e=0; e<E; e++) {
			st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			edges[e] = new Edge(A, B, C);
		}
		
		Arrays.sort(edges, (e, f) -> Integer.compare(e.value, f.value));
		
		int mst = 0;
		int elements = 1;
		
		for(Edge e: edges) {
			if(!union(e.A, e.B)) continue;
			
			mst += e.value;
			if(++elements == V) break;
		}
		
		System.out.println(mst);
	}
	
}
