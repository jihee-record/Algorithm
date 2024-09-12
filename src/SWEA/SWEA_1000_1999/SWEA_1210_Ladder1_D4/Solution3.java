package SWEA.SWEA_1000_1999.SWEA_1210_Ladder1_D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int t=0; t<10; t++) {
			sb.append("#").append(Integer.parseInt(br.readLine())).append(" ");
			int[][] ladder = new int[100][100];
			//출발 위치
			int row = 99, col = 0;
			for(int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j < 100; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int j=0; j<100; j++) {
				if(ladder[99][j] == 2) {
					col = j;
				}
			}
			
			// 상단에 도착할 때까지
			while(row > 0) {
				// 왼쪽에 사다리가 있음
				if(col>0 && ladder[row][col-1] == 1) {
					// 왼쪽 벽에 도착하거나 사다리가 끊길 때까지 좌로 이동
					while(col > 0 && ladder[row][col-1] == 1) {
						col--;
					}
					
				// 오른쪽에 사다리가 있음
				}else if (col < 99 && ladder[row][col+1] == 1) {
					// 오른쪽 벽에 도착하거나 사다리가 끊길 때까지 우로 이동
					while(col < 99 && ladder[row][col+1] == 1) {
						col++;
					}
				}
				
				// 좌우에 모두 사다리가 없으니까 위로 한칸 이동
				row--;
			}
			sb.append(col).append("\n");
		}
		System.out.print(sb.toString());
		br.close();
	}
}
