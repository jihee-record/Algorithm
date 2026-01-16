package 백준.백준_2000_2999.백준_2213_트리의독립집합_G1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_백준_2213_트리의독립집합_G1_240ms {
	static int[] value; // 각 노드의 가중치(weight)
	static int[][] memo; // memo : idx가 루트인 서브트리의 가중치 최대값 [0] 루트 미포함, [1] 포함
	static ArrayList<Integer>[] adj;
	
	static void calculate(int before, int n) {
		memo[n][0] = 0;         // n 미선택
	    memo[n][1] = value[n];	// n 선택 
	    
		for (int v : adj[n]) {
			if(v == before) continue;
			calculate(n, v);
			
			memo[n][0] += Math.max(memo[v][0], memo[v][1]);
			memo[n][1] += memo[v][0];
		}
	}
	
	// 찾아야 됨...........
	static void trace(int before, int n, boolean parentChosen, List<Integer> chosen) {
	    if (parentChosen) {
	        // 부모가 선택이면 나는 못 고름
	        for (int v : adj[n]) {
	            if (v == before) continue;
	            trace(n, v, false, chosen);
	        }
	    } else {
	        // 부모가 미선택이면 나는 고를 수도 있음
	        if (memo[n][1] > memo[n][0]) {
	            chosen.add(n);
	            for (int v : adj[n]) {
	                if (v == before) continue;
	                trace(n, v, true, chosen);
	            }
	        } else {
	            for (int v : adj[n]) {
	                if (v == before) continue;
	                trace(n, v, false, chosen);
	            }
	        }
	    }
	}
	
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		value = new int[N+1]; // 1~N
		memo = new int[N+1][2];
		adj = new ArrayList[N+1]; // 인접리스트
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n=1; n<=N; n++) {
			adj[n] = new ArrayList<>();
			value[n] = Integer.parseInt(st.nextToken());
		}
		
		// 비순환 연결 그래프 간선 개수 N-1
		for(int n=1; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			adj[u].add(v);
			adj[v].add(u);
		}
		
		List<Integer> chosen = new ArrayList<>();
		calculate(0, 1);
		
		sb.append(Math.max(memo[1][0], memo[1][1]));
		trace(0, 1, false, chosen);
		
		sb.append("\n");
		Collections.sort(chosen);
		for(int c : chosen) sb.append(c).append(" ");
		
		System.out.println(sb);
		br.close();
	}

}
