package 백준.백준_2000_2999.백준_2580_스도쿠_G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_백준_2580_스도쿠_G4_236ms {
	static StringBuilder sb;
	static int[][] map;
	static boolean[][] row, col, square;
	static ArrayList<int[]> blanks;
	static int blankCnt;
	static boolean flag;
	
	static void sudoku(int idx) { // idx : 빈칸 순번, n : 채울 숫자
		if(flag) return;
		
		if(idx == blankCnt) {
			for(int r=0; r<9; r++) {
				for(int c=0; c<9; c++) {
					sb.append(map[r][c]).append(' ');
				}
				sb.append('\n');
			}
			
			flag = true;
			return;
		}
		
		int[] blank = blanks.get(idx);
		int r = blank[0];
		int c = blank[1];
		int s = (r / 3) * 3 + (c / 3); // square 위치
		for(int n = 1; n <= 9; n++) {
			if(row[r][n] || col[c][n] || square[s][n]) continue; // 이미 있는 숫자
			
			// 선택
			map[r][c] = n;
			row[r][n] = true;
			col[c][n] = true;
			square[s][n] = true;
			
			sudoku(idx + 1);
			
			// 미선택
			map[r][c] = 0;
			row[r][n] = false;
			col[c][n] = false;
			square[s][n] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		
		map = new int[9][9];
		blanks = new ArrayList<>();
		
		row = new boolean[9][10];
		col = new boolean[9][10];
		square = new boolean[9][10];

		for(int r=0; r<9; r++) {
			st = new StringTokenizer(br.readLine());
			
			int sr = (r / 3) * 3; // square row
			for(int c=0; c<9; c++) {
				int v = Integer.parseInt(st.nextToken()); // value
				if(v == 0) {
					blanks.add(new int[] {r, c});
					continue;
				}
				
				map[r][c] = v;
				row[r][v] = true;
				col[c][v] = true;
				square[sr + c/3][v] = true;
			}
		}
		
		blankCnt = blanks.size();
		flag = false;
		sudoku(0);
		
		System.out.println(sb);
		br.close();
	}

}
