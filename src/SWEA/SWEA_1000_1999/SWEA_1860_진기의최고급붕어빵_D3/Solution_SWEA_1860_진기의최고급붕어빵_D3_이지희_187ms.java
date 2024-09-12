package SWEA.SWEA_1000_1999.SWEA_1860_진기의최고급붕어빵_D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_SWEA_1860_진기의최고급붕어빵_D3_이지희_187ms {
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
			List<Integer> customers = new ArrayList<>();
			customers.add(0); //index 0 빼기
			st = new StringTokenizer(br.readLine());
			for(int n=0; n<N; n++) {
				customers.add(Integer.parseInt(st.nextToken()));
			}
			Collections.sort(customers);
			
			int time = 0; //현재시간 : 흘러간시간 
			boolean can = true;
			for(int i=1; i<customers.size(); i++) {
				time = customers.get(i); // i가 팔아야할붕어빵개수 
				if((time/M)*K < i) {
					can = false;
					break;
				}
			}
			if(can) sb.append("Possible");
			else sb.append("Impossible");
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		br.close();
	}
}
