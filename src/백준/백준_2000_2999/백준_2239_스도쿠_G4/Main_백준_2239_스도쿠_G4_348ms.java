package 백준.백준_2000_2999.백준_2239_스도쿠_G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 답안 오름차순
public class Main_백준_2239_스도쿠_G4_348ms {
	static StringBuilder sb;
	static int[][] map;
	static boolean[][] row, col, square;
	static ArrayList<Integer> blankR, blankC; // blank row, blank column
	static int blankCnt;
	static boolean flag;
	
	static void sudoku(int idx) {
		if(flag) return;
		
		if(idx == blankCnt) {
			for(int r=0; r<9; r++) {
				for(int c=0; c<9; c++) {
					sb.append(map[r][c]);
				}
				sb.append('\n');
			}
			flag = true;
			return;
		}
		
		int r = blankR.get(idx);
		int c = blankC.get(idx);
		
		int s = (r / 3) * 3 + (c / 3); 
		for(int n=1; n<=9; n++) {
			if(row[r][n] || col[c][n] || square[s][n]) continue;
			
			// 선택
			map[r][c] = n;
			row[r][n] = col[c][n] = square[s][n] = true;
			
			sudoku(idx + 1);
			
			// 미선택
			map[r][c] = 0;
			row[r][n] = col[c][n] = square[s][n] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		map = new int[9][9];
		
		row = new boolean[9][10];
		col = new boolean[9][10];
		square = new boolean[9][10];
		blankR = new ArrayList<>();
		blankC = new ArrayList<>();
		
		for(int r=0; r<9; r++) {
			int sr = (r / 3) * 3; //square r
			String line = br.readLine();
			for(int c=0; c<9; c++) {
				int v = line.charAt(c) - '0';
				
				if(v == 0) {
					blankR.add(r);
					blankC.add(c);
					continue;
				}
				
				int s = sr + (c / 3);
				map[r][c] = v;
				row[r][v] = col[c][v] = square[s][v] = true;
			}
		}
		
		blankCnt = blankR.size();
		flag = false;
		sudoku(0);
		
		System.out.println(sb);
		br.close();
	}

}
