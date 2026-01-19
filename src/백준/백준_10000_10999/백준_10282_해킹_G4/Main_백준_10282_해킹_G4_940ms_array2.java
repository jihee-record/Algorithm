package 백준.백준_10000_10999.백준_10282_해킹_G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// pq , array
public class Main_백준_10282_해킹_G4_940ms_array2 {
	
	static class Computer {
		int no;
		ArrayList<int[]> linked; // 0: a, 1:s 
		
		Computer(){}
		Computer(int no){
			this.no = no;
			linked = new ArrayList<>();
		}
	}
	
	 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st ;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			Computer[] com = new Computer[N+1];
			
			for(int n=1; n<=N; n++) {
				com[n] = new Computer(n);
			}

			for(int d=0; d<D; d++) {
				st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				
				com[b].linked.add(new int[] {a, s});
			}
			
			int[] dist = new int[N+1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			
			PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->{
				if(a[1] != b[1]) {
					return Integer.compare(a[1], b[1]);
				}else {
					return Integer.compare(a[0], b[0]);
				}
			});
			
			dist[C] = 0;
			pq.add(new int[] {C, 0});
			int cnt = 0;
			int result = 0;
			
			while(!pq.isEmpty()) {
				int[] v = pq.poll(); // 시작점
				
				if(dist[v[0]] < v[1]) {
					continue;
				}
				
				cnt++;
				result = v[1];
				
				for(int[] u: com[v[0]].linked) {
					int cu = dist[v[0]] + u[1];
					if(dist[u[0]] <= cu) continue;
					dist[u[0]] = cu;
					pq.add(new int[] {u[0], cu});
				}
			}
			
			sb.append(cnt).append(" ").append(result).append("\n");
		}
		
		System.out.println(sb.toString());
		br.close();
	}
}
