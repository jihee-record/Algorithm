package SWEA.SWEA_1000_1999.SWEA_1210_Ladder1_D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//134ms 
//24,244kb

public class Solution_SWEA_1210_Ladder1_D4_이지희_134ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int t = 0; t < 10; t++) {
			sb.append("#").append(Integer.parseInt(br.readLine())).append(" ");
			int[][] ladder = new int[100][100];
			
			// 출발 위치
			int row = 99;
			int col = 0;
			
			for (int i = 0; i < 100; i++) {
				String line = br.readLine();
				for (int j = 0; j < 100; j++) {
					// 숫자가 0, 1, 2로 이루어져 있어서 charAt() 사용 가능
					ladder[i][j] = line.charAt(j * 2) - '0'; 
					if (ladder[i][j] == 2) {
						// 출발 위치 저장
						col = j; 
					}
				}
			}
			
			// 상단에 도착할 때까지 
			while (row > 0) {
				// 왼쪽에 사다리가 있음
				if (col > 0 && ladder[row][col - 1] == 1) {
					// 왼쪽 벽에 도착하거나 사다리가 끊길 때까지 좌로 이동
					while (col > 0 && ladder[row][col - 1] == 1) {
						col--;
					}
					
				// 오른쪽에 사다리가 있음
				} else if (col < 99 && ladder[row][col + 1] == 1) {
					// 오른쪽 벽에 도착하거나 사다리가 끊길 때까지 우로 이동
					while (col < 99 && ladder[row][col + 1] == 1) {
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
