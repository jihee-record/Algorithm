package 백준.백준_1000_1999.백준_1799_비숍_P5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_백준_1799_비숍_P5_시간초과 {
	static int N, B;
	static char[][] board;
	static ArrayList<Integer> blanks;
	static int[] dr = {-1, -1, 1, 1};
	static int[] dc = {-1, 1, -1, 1};
	static int max = 0;
	
	/**
	 * 비숍 조합
	 * @param blankIdx : blanks 리스트에서 선택할 차례인 인덱스 
	 * @param selected : 선택된 blanks 원소의 인덱스 리스트
	 */
	static void combination(int blankIdx, ArrayList<Integer> selected) {
		if(selected.size() > 0 && !crossCheck(selected)) {
			return;
		}
		
		if(blankIdx == B) return;

		selected.add(blankIdx);

		combination(blankIdx + 1, selected);
		selected.remove(selected.size()-1);
		combination(blankIdx + 1, selected);
	}
	
	static boolean crossCheck(ArrayList<Integer> selected) {
		int recent = selected.size() - 1;
		int idx = selected.get(recent); // 최근 추가된 비숍만 체크하면 됨. 앞은 이전 crossCheck에서 확인 완료
		int n = blanks.get(idx);
		int r = n / N;
		int c = n % N;

		for(int d=0; d<4; d++) {
			int k = 0;
			while(true) { // 1, 2, 3 .. break 될 때 까지
				k++;
				int nr = r + k * dr[d];
				int nc = c + k * dc[d];
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) break; // 한 방향 종료
				
				if(board[nr][nc] == '0') continue; // 0 못 놓는 곳
				
				for(int i=0; i<recent; i++) {
					int idx1 = selected.get(i);
					int n1 = blanks.get(idx1);
					int r1 = n1 / N;
					int c1 = n1 % N;
					
					if(nr == r1 && nc == c1) return false;
				}
				
			}
		}

		max = Math.max(max, selected.size());
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		board = new char[N][N];
		blanks = new ArrayList<>();
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				board[r][c] = st.nextToken().charAt(0);
				if(board[r][c] == '1') blanks.add(r * N + c);
			}
		}
		
		B = blanks.size();
		combination(0, new ArrayList<>());
		
		System.out.println(max);
		br.close();
	}

}
