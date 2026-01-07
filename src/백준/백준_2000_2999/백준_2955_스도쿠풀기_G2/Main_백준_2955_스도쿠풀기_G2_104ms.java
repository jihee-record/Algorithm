package 백준.백준_2000_2999.백준_2955_스도쿠풀기_G2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_백준_2955_스도쿠풀기_G2_104ms {
	static StringBuilder sb;
	static char[][] map;
	static boolean[][] row, col, square;
	static int[] blankCnt;
	static boolean flag;
	
	static void sudoku() {
		while(true) {
			boolean fill = false;
			for(int n=1; n<=9; n++) {
				if(!flag) return;
				if(blankCnt[n] == 0) continue;
				if(crossHatching(n)) fill = true;
			}
			
			if(!fill) break;
		}
	}
	
	static boolean crossHatching(int n) {
		boolean fill = false;
		outloop:
		for(int s=0; s<9; s++) {
			if(square[s][n]) continue;
			
			int startR = (s / 3) * 3;
			int startC = (s % 3) * 3;

			int endR = startR + 2;
			int endC = startC + 2;
			
//			System.out.println("***************");
//			System.out.println(startR + "-" + endR + ", " + startC + "-" + endC);
			
			ArrayList<Integer> restR = new ArrayList<Integer>();
			ArrayList<Integer> restC = new ArrayList<Integer>();
			
			for(int r = startR; r <= endR; r++) {
				if(row[r][n]) continue;
				
				for(int c = startC; c <= endC; c++) {
					if(col[c][n]) continue;
					
					restR.add(r);
					restC.add(c);
				}
			}
			
			int idx = -1;
			for(int i = 0; i < restR.size(); i++) {
				int r = restR.get(i);
				int c = restC.get(i);
//				if(n == 1) System.out.println(r + "-" + c + " = " + map[r][c]);
				
				if(map[r][c] != '.') continue; // 이미 숫자가 있어
				if(idx != -1) {
//					System.out.println(r + "-" + c + " skip");
					continue outloop; // 빈 칸이 둘 이상
				}

				idx = i;
			}
			
			if(idx == -1) {
				flag = false;
				return false; // 이 박스에 n이 없는 데 적을 수 있는 칸이 없음
			}
			
			int r = restR.get(idx);
			int c = restC.get(idx);
			
			map[r][c] = (char)('0' + n);
			row[r][n] = col[c][n] = square[s][n] = true;
			blankCnt[n]--;
			fill = true;
//			System.out.println(r + "-" + c + ": " + n + "[" + s + "]");
//			System.out.println("-----------");
		}
		
		return fill;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		map = new char[9][9];
		row = new boolean[9][10];
		col = new boolean[9][10];
		square = new boolean[9][10];
		blankCnt = new int[10];
		
		Arrays.fill(blankCnt, 9);
		
		for(int r=0; r<9; r++) {
			int sr = (r / 3) * 3;
			
			String line = br.readLine();
			for(int c=0; c<9; c++) {
				map[r][c] = line.charAt(c);
				
				if(map[r][c] == '.')  continue;
				
				int v = map[r][c] - '0';
				int s = sr + (c / 3);
				if(row[r][v] || col[c][v] || square[s][v]) {
					System.out.println("ERROR");
					return;
				}
				
				row[r][v] = col[c][v] = square[s][v] = true;
				blankCnt[v]--;
			}
		}

		flag = true;
		sudoku();
		
		if(!flag) {
			System.out.println("ERROR");
			return;
		}
		
		for(int r=0; r<9; r++) {
			for(int c=0; c<9; c++) {
				sb.append(map[r][c]);
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
		br.close();
	}

}
