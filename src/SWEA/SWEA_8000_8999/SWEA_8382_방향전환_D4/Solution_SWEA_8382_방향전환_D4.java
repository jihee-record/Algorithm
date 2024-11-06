package SWEA.SWEA_8000_8999.SWEA_8382_방향전환_D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_8382_방향전환_D4 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int x = Math.abs(x2-x1);
			int y = Math.abs(y2-y1);
			
			int max = Math.max(x, y);
			int min = Math.min(x, y);

			sb.append("#").append(t).append(" ");
			
			if((max-min)%2 != 0) sb.append(2*max -1);
			else sb.append(2*max);
			
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		br.close();
	}
}
