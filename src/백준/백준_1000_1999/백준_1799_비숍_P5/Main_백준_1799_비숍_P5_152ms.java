package 백준.백준_1000_1999.백준_1799_비숍_P5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 체스판 각 대각선의 성질 이용
// W/B은 각각 절대 마주치지않으므로, 각각의 경우에서 놓을 수 있는 경우를 뽑으면 됨
// /대각선은  r+c=상수, \대각선은 r-c=상수
public class Main_백준_1799_비숍_P5_152ms {
	static int N;
	static char[][] board;
	static ArrayList<int[]> black;
	static ArrayList<int[]> white;
	static boolean[] d1, d2; // r+c, r-c+N-1(음수 방지) - 각 라인에 놓여있는지
	static int best;
	
	/**
	 * 
	 * @param blanks : 빈 칸 목록 (B or W)
	 * @param idx : 이번에 체크 할 
	 * @param cnt : 선택 개수
	 */
	static void chess(ArrayList<int[]> blanks, int idx, int cnt) {
		int remain = blanks.size() - idx; // 앞으로 더 높을 수 있는 남은 칸 수
		if(cnt + remain <= best) return; // 남은 칸 모두 놓아도 가장 많이 놓은 경우가 못 됨
		
		if(idx == blanks.size()) { // 확인 끝
			best = Math.max(best, cnt);
			return;
		}
		
		int[] blank = blanks.get(idx);
		int r = blank[0];
		int c = blank[1];
		
		int p = r + c; // / 대각선 체크
		int q = r - c + N - 1; // \ 대각선 체크
		
		// 놓기
		if(!d1[p] && !d2[q]) {
			d1[p] = d2[q] = true;
			chess(blanks, idx + 1, cnt + 1);
			d1[p] = d2[q] = false; // 다시 복귀
		}
		
		// 안 놓기
		chess(blanks, idx + 1, cnt);
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		board = new char[N][N];
		black = new ArrayList<>();
		white = new ArrayList<>();
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				board[r][c] = st.nextToken().charAt(0);
				if(board[r][c] == '1') {
					if(((r+c) & 1) == 0) black.add(new int[] {r, c}); // 짝수
					else white.add(new int[] {r, c});// 홀수
				}
			}
		}
		
		d1 = new boolean[2*N -1]; // r+c
		d2 = new boolean[2*N -1]; // r-c +N-1
		
		// black check
		best = 0;
		chess(black, 0, 0);
		int blackBest = best;
		
		Arrays.fill(d1, false);
		Arrays.fill(d2, false);
		
		// white check
		best = 0;
		chess(white, 0, 0);
		int whiteBest = best;
		
		System.out.println(blackBest + whiteBest);
		br.close();
	}

}
