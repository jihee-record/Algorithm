package SWEA.SWEA_10000_10999.SWEA_10966_물놀이를가자_D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_SWEA_10966_물놀이를가자_D4 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			String[][] map = new String[N][M];
			List<int[]> waters = new ArrayList<>();
			
			for(int n=0; n<N; n++) {
				map[n] = br.readLine().split("");
				for(int m=0; m<M; m++) {
					if(map[n][m].equals("W")) {
						waters.add(new int[] {n, m});
					}
				}
			}
			
			int sum = 0;
			for(int n=0; n<N; n++) {
				for(int m=0; m<M; m++) {
					if(!map[n][m].equals("W")) {
						int count = Integer.MAX_VALUE;
						for(int[] water : waters) {
							count = Math.min(Math.abs(water[0]-n) +  Math.abs(water[1]-m), count);
						}
						sum += count;
					}
				}
			}
			
			sb.append(sum).append("\n");
		}
		
		System.out.println(sb.toString());
		br.close();
	}
}
