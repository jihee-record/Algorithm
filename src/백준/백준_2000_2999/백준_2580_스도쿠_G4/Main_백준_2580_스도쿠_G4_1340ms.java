package 백준.백준_2000_2999.백준_2580_스도쿠_G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 최초 정렬해봄
public class Main_백준_2580_스도쿠_G4_1340ms {
	static StringBuilder sb;
	static int[][] map;
	static boolean[][] row, col, square;
	static ArrayList<int[]> blanks;
	static int blankCnt;
	static boolean flag;
	
	static void sudoku(int idx) { 
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
		int s = (r / 3) * 3 + (c / 3); 
		for(int n = 1; n <= 9; n++) {
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
	
	static int countCandidates(int r, int c) {
		int cnt = 0;
		
		int s = (r / 3) * 3 + c / 3;
		for(int n=1; n<=9; n++) {
			if(!row[r][n] && !col[c][n] && !square[s][n]) cnt++;
		}
		
		return cnt;
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
			
			int sr = (r / 3) * 3; 
			for(int c=0; c<9; c++) {
				int v = Integer.parseInt(st.nextToken()); 
				if(v == 0) {
					blanks.add(new int[] {r, c});
					continue;
				}
				
				map[r][c] = v;
				row[r][v] = col[c][v] = square[sr + c/3][v] = true;
			}
		}
		
		blanks.sort((a, b) -> countCandidates(a[0], a[1]) - countCandidates(b[0], b[1]));
		
		blankCnt = blanks.size();
		flag = false;
		sudoku(0);
		
		System.out.println(sb);
		br.close();
	}

}
