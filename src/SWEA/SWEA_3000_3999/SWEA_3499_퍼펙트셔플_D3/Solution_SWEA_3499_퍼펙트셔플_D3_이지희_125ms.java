package SWEA.SWEA_3000_3999.SWEA_3499_퍼펙트셔플_D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_3499_퍼펙트셔플_D3_이지희_125ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			Queue<String> q1 = new LinkedList<>(); 
			Queue<String> q2 = new LinkedList<>();
			for(int n=0; n<(N+1)/2; n++) {
				q1.add(st.nextToken());
			}
			
			int half = (N+1)/2;
			for(int n=half; n<N; n++) {
				q2.add(st.nextToken());
			}
			
			sb.append("#").append(t).append(" ");
			for(int n=0; n<N; n++) {
				if(n%2 == 0) {
					sb.append(q1.poll()).append(" ");
				}else {
					sb.append(q2.poll()).append(" ");
				}
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		br.close();
	}
}
