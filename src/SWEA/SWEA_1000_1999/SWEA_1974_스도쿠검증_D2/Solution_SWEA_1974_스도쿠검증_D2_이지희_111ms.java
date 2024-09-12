package SWEA.SWEA_1000_1999.SWEA_1974_스도쿠검증_D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution_SWEA_1974_스도쿠검증_D2_이지희_111ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			String[][] sudoku = new String[9][9];
			for(int i=0; i<9; i++) {
				sudoku[i] = br.readLine().split(" "); 
			}
			
			boolean flag = true;
			outerLoop:
			for(int i=0; i<9; i++) {
				Set<String> set = new HashSet<>();
				//가로
				for(int j=0; j<9; j++) {
					set.add(sudoku[i][j]);
				}
				if(set.size()<9) {
					flag = false;
					break outerLoop;
				}
				
				//세로
				for(int j=0; j<9; j++) {
					set.remove(sudoku[j][i]);
				}
				if(set.size()>0) {
					flag = false;
					break outerLoop;
				}
			}
			
			//네모박스
			outerLoop:
			for(int i=0; i<9; i=i+3) {
				for(int j=0; j<9; j=j+3) {
					Set<String> set = new HashSet<>();
					set.add(sudoku[i][j]);
					set.add(sudoku[i][j+1]);
					set.add(sudoku[i][j+2]);
					set.add(sudoku[i+1][j]);
					set.add(sudoku[i+1][j+1]);
					set.add(sudoku[i+1][j+2]);
					set.add(sudoku[i+2][j]);
					set.add(sudoku[i+2][j+1]);
					set.add(sudoku[i+2][j+2]);
					if(set.size()<9) {
						flag = false;
						break outerLoop;
					}
				}
			}
			
			sb.append("#").append(t).append(" ");
			if(flag) sb.append(0).append("\n");
			else sb.append(1).append("\n");
		}
		
		System.out.println(sb.toString());
		br.close();
	}
}
