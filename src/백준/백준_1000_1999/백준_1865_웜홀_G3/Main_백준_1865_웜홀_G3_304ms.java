package 백준.백준_1000_1999.백준_1865_웜홀_G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1865_웜홀_G3_304ms {
	static class Edge {
		int s, e, t; // start, end, time
		
		Edge(){}
		
		Edge(int s, int e, int t) {
			this.s = s;
			this.e = e;
			this.t = t;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		testloop:
		for(int tc=0; tc<TC; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken()); // 지점
			int M = Integer.parseInt(st.nextToken()); // 도로 // + , 양방향 
			int W = Integer.parseInt(st.nextToken()); // 웜홀 // -
			
			int cnt = 2 * M + W;
			Edge[] edges = new Edge[cnt];
			
			for(int m=0; m<2*M; m=m+2) {
				st = new StringTokenizer(br.readLine());
				
				int S = Integer.parseInt(st.nextToken()); 
				int E = Integer.parseInt(st.nextToken()); 
				int T = Integer.parseInt(st.nextToken());
				
				edges[m] = new Edge(S, E, T);
				edges[m+1] = new Edge(E, S, T); // 카피하다가 S-E 그대로 작성
			}
			
			for(int w=2*M; w<cnt; w++) {
				st = new StringTokenizer(br.readLine());
				
				int S = Integer.parseInt(st.nextToken()); 
				int E = Integer.parseInt(st.nextToken()); 
				int T = Integer.parseInt(st.nextToken());
				
				edges[w] = new Edge(S, E, -T);
			}
			
			long[] t = new long[N+1];
			
			for(int i=1; i<N; i++) {
				boolean updated = false;
				
				for(Edge e: edges) {
					if(t[e.s] != Long.MAX_VALUE && t[e.e] > t[e.s] + e.t) {
						t[e.e] = t[e.s] + e.t;
						updated = true;
					}
				}
				
				if(!updated) break;
			}
			
			for(Edge e: edges) {
				if(t[e.s] != Long.MAX_VALUE && t[e.e] > t[e.s] + e.t) {
					sb.append("YES").append('\n');
					continue testloop;
				}
			}

			sb.append("NO").append('\n');
		}
		
		System.out.println(sb);
		br.close();
	}

}
