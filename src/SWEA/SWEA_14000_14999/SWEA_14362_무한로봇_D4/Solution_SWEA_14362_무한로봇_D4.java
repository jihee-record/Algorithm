package A_TEST.SWEA_14362_무한로봇_D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_SWEA_14362_무한로봇_D4 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		int[] dr = {0, 1, 0, -1};
		int[] dc = {1, 0, -1, 0};
		
		for(int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			
			String input = br.readLine();
			if(!input.contains("S")) {
				sb.append(0).append("\n");
				continue;
			}

			String[] commands = input.split("");
			int d = 0, r = 0, c = 0;
			
			int max = 0;
			for(int i=0; i<4; i++) {
				for(String command : commands) {
					switch(command) {
					case "S":
						r = r + dr[d];
						c = c + dc[d];
						max = Math.max(max, r*r + c*c);
						break;
					case "L":
						d = (d + 3) % 4;
						break;
					case "R":
						d = (d + 1) % 4;
						break;
					}
				}
				
				if(r == 0 && c == 0 && d == 0) {
					sb.append(max).append("\n");
					break;
				}
			}
			
			if(r != 0 || c != 0 || d != 0) {
				sb.append("oo").append("\n");
			}
			
		}
		
		System.out.println(sb.toString());
		br.close();
	}

}
