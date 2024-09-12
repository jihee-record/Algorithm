package SWEA.SWEA_1000_1999.SWEA_1210_Ladder1_D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int t=0; t<10; t++) {
			sb.append("#").append(Integer.parseInt(br.readLine())).append(" ");
			int[][] ladder = new int[100][100];
			int startCol = 0;
			
			for(int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j < 100; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
					if(ladder[i][j] == 2) {
						startCol = j; 
					}
				}
			}
			
			// 출발 위치 설정
			int row = 99;
			int col = startCol;
			
			// 상단에 도착할 때까지 반복
			while(row > 0) {
				// 좌우 이동 체크
				if (col > 0 && ladder[row][col - 1] == 1) {
					// 좌측으로 가능한 만큼 이동
					while (col > 0 && ladder[row][col - 1] == 1) {
						col--;
					}
				} else if (col < 99 && ladder[row][col + 1] == 1) {
					// 우측으로 가능한 만큼 이동
					while (col < 99 && ladder[row][col + 1] == 1) {
						col++;
					}
				}
				// 좌우 이동 후 위로 이동
				row--;
			}
			sb.append(col).append("\n");
		}
		System.out.print(sb.toString());
		br.close();
	}
}