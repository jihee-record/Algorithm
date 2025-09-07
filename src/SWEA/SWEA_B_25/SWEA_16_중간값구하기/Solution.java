package SWEA.SWEA_B_25.SWEA_16_중간값구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int result = 0;
			
			int N = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			PriorityQueue<Integer> minQ = new PriorityQueue<>();
			PriorityQueue<Integer> maxQ = new PriorityQueue<>();
			
			for(int n=0; n<N; n++) {
				st = new StringTokenizer(br.readLine(), " ");
				
				while(st.hasMoreElements()) {
					int a = Integer.parseInt(st.nextToken());
					if(a < k) {
						minQ.add(a);
					}else {
						maxQ.add(a);
					}
				}
				k = maxQ.peek();
				System.out.println("k:" + k);
				result = (result + k) % 20171109;
			}
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		
		System.out.println(sb.toString());
		br.close();
	}

}
