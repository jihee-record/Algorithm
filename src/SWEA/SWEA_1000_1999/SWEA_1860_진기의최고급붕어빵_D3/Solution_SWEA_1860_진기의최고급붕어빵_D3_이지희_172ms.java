package SWEA.SWEA_1000_1999.SWEA_1860_진기의최고급붕어빵_D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_SWEA_1860_진기의최고급붕어빵_D3_이지희_172ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		// N : 사람 수
		// M, K : M초당 K개 붕어빵
		for(int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken()); 
			int K = Integer.parseInt(st.nextToken());
			PriorityQueue<Integer> customers = new PriorityQueue<>();
			st = new StringTokenizer(br.readLine());
			for(int n=0; n<N; n++) {
				customers.add(Integer.parseInt(st.nextToken()));
			}
			
			int time = 0; //현재시간 : 흘러간시간 
			boolean can = true;
			int i=1; // i가 팔아야할붕어빵개수
			while(!customers.isEmpty()) {
				time = customers.poll();  
				if((time/M)*K < i) {
					can = false;
					break;
				}
				i++;
			}
			if(can) sb.append("Possible");
			else sb.append("Impossible");
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		br.close();
	}
}
