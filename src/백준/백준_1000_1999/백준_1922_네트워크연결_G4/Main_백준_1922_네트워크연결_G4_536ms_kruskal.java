package 백준.백준_1000_1999.백준_1922_네트워크연결_G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// mst kruskal
public class Main_백준_1922_네트워크연결_G4_536ms_kruskal {
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
	
	static class Edge {
		int a;
		int b;
		int value;
		
		Edge(){}
		Edge(int a, int b, int value){
			this.a = a;
			this.b = b;
			this.value = value;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // vertex
		int M = Integer.parseInt(br.readLine()); // edge
		
		parent = new int[N+1];
		for(int n=1; n<=N; n++) {
			parent[n] = n;
		}
		
		Edge[] edges = new Edge[M];
		
		
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			edges[m] = new Edge(a, b, c);
		}
		
		Arrays.sort(edges, (e, f) -> Integer.compare(e.value, f.value));
		
		int cost = 0;
		int cnt = 1;
		
		for(Edge e: edges) {
			if(!union(e.a, e.b)) continue;
			
			cost += e.value;
			if(++cnt == N) break;
		}
		
		System.out.println(cost);
		br.close();
	}

}
