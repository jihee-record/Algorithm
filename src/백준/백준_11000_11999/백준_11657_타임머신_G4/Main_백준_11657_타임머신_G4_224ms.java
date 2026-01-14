package 백준.백준_11000_11999.백준_11657_타임머신_G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_11657_타임머신_G4_224ms {
	static class Edge {
		int a, b, c;
		
		Edge(){}

		Edge(int a, int b, int c){
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // vertex
		int M = Integer.parseInt(st.nextToken()); // edge
		
		Edge[] edges = new Edge[M]; 
		
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			edges[m] = new Edge(A, B, C);
		}
		
		long[] t = new long[N+1];
		Arrays.fill(t, Long.MAX_VALUE);
		t[1] = 0;
		
		for(int n=1; n<N; n++) {
			boolean updated = false;
			
			for(Edge e: edges) {
				if(t[e.a] != Long.MAX_VALUE && t[e.b] > t[e.a] + e.c) {
					t[e.b] = t[e.a] + e.c;
					updated = true;
				}
			}
			
			if(!updated) break;
		}
		
		for(Edge e: edges) {
			if(t[e.a] != Long.MAX_VALUE && t[e.b] > t[e.a] + e.c) {
				System.out.println(-1);
				return;
			}
		}
		
		for(int n=2; n<=N; n++) sb.append(t[n] != Long.MAX_VALUE ? t[n] : -1).append('\n');
		
		System.out.println(sb);
		br.close();
	}

}
