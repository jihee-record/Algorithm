package 백준.백준_2000_2999.백준_2580_스도쿠_G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_백준_2580_스도쿠_G4_256ms_swap {
	static StringBuilder sb;
	static int[][] map;
	static boolean[][] row, col, square;
	static ArrayList<Integer> blankR, blankC; 
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
		
		// 다음 칸
		int best = idx;
		int bestCnt = 9; // 한 칸에 선택 가능한 최대 개수
		for(int i=idx; i<blankCnt; i++) { // idx 이전은 이미 다 채웠음
			int r = blankR.get(i);
			int c = blankC.get(i);
			int cnt = countCandidates(r, c);
			
			if(cnt < bestCnt) {
				best = i;
				bestCnt = cnt;
				if(bestCnt == 1) break; 
			}
		}
		
		if(bestCnt == 0) return; // 틀린 답
		
		int r = blankR.get(best);
		int c = blankC.get(best);

		if(best != idx) { // idx에 있는 값을 베스트 쌍으로 바꿔서 사용
			blankR.set(best, blankR.get(idx));
			blankC.set(best, blankC.get(idx));
			
			blankR.set(idx, r);
			blankC.set(idx, c);
		}
		
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
	
	// 해당 칸의 후보 개수
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
		blankR = new ArrayList<>();
		blankC = new ArrayList<>();
		
		row = new boolean[9][10];
		col = new boolean[9][10];
		square = new boolean[9][10];

		for(int r=0; r<9; r++) {
			st = new StringTokenizer(br.readLine());
			
			int sr = (r / 3) * 3; // square row
			for(int c=0; c<9; c++) {
				int v = Integer.parseInt(st.nextToken()); // value
				if(v == 0) {
					blankR.add(r);
					blankC.add(c);
					continue;
				}
				
				map[r][c] = v;
				row[r][v] = col[c][v] = square[sr + c/3][v] = true;
			}
		}
		
		blankCnt = blankR.size();
		flag = false;
		sudoku(0);
		
		System.out.println(sb);
		br.close();
	}

}
