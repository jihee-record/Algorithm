package SWEA.SWEA_7000_7999.SWEA_7102_준홍이의카드놀이_D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_7102_준홍이의카드놀이_D3_이지희_103ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int start = Math.min(N, M) + 1;
            int end = Math.max(N, M) + 1;
			
			for(int i=start; i<=end; i++) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
		}// T
        
		System.out.println(sb.toString());
        br.close();
	}// main
}// class
