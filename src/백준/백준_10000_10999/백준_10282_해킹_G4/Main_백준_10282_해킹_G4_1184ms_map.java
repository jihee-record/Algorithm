package 백준.백준_10000_10999.백준_10282_해킹_G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// pq ,  visited + dist 배열따로
public class Main_백준_10282_해킹_G4_1184ms_map {
	
	static class Computer {
		int no;
		Map<Integer, Integer> linked; // key: a, value: second
		
		Computer(){}
		Computer(int no){
			this.no = no;
			linked = new HashMap<>();
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
				
				com[b].linked.put(a, s);
			}
			
			int[] dist = new int[N+1];
			Arrays.fill(dist, -1);
			boolean[] visited = new boolean[N+1];
			
			// [0] : no, [1] : C -> A dist
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
				int[] v = pq.poll();
//				System.out.println("체크 : " + v[0]);
				
				if(visited[v[0]]) {
//					System.out.println("스킵");
					continue;
				}
				
				visited[v[0]] = true;
				cnt++;
				result = v[1];
//				System.out.println();
//				System.out.println("dist[v]: " + dist[v[0]]);
				
				for(int a: com[v[0]].linked.keySet()) {
					if(visited[a]) continue;
//					System.out.println("a: " + a);
					int ca = dist[v[0]] + com[v[0]].linked.get(a);
//					System.out.println("ca: " + ca);
					if(dist[a] != -1 && dist[a] < ca) continue;
					dist[a] = ca;
					pq.add(new int[] {a, ca});
//					System.out.println(a + " 추가");
				}
//				System.out.println();
			}
			
			sb.append(cnt).append(" ").append(result).append("\n");
		}
		
		System.out.println(sb.toString());
		br.close();
	}
}
