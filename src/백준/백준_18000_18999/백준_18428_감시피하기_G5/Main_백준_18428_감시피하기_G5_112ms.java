package 백준.백준_18000_18999.백준_18428_감시피하기_G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_백준_18428_감시피하기_G5_112ms {
	static int N;
	static boolean answer;
	static ArrayList<int[]> teachers, blanks;
	static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
	static char[][] map;

	// i : blanks index 
	static void setObject(int i, int cnt) {
		if(answer) return;
		if(cnt == 3) {
			if(check()) answer = true;
			return;
		}
		
		if(i == blanks.size()) return;
		
		int[] blank = blanks.get(i);
		int r = blank[0];
		int c = blank[1];

		map[r][c] = 'O';
		setObject(i + 1, cnt + 1);
		map[r][c] = 'X';
		setObject(i + 1, cnt);
	}
	
	static boolean check() {
		for(int t=0; t<teachers.size(); t++) {
			int[] now = teachers.get(t);
			int r = now[0];
			int c = now[1];
			
			for(int d=0; d<4; d++) {
				int nr = r;
				int nc = c;
				while(true) {
					nr += dr[d];
					nc += dc[d];
					
					if(nr < 0 || nr >= N || nc < 0 || nc >= N) break;
					
					if(map[nr][nc] == 'O') break;
					if(map[nr][nc] == 'S') return false; // 실패
				}
			}
		}
		
		return true; // 감시 피하기 가능
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		teachers = new ArrayList<>();
		blanks = new ArrayList<>();
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = st.nextToken().charAt(0);
				if(map[r][c] == 'T') teachers.add(new int[] {r, c});
				else if(map[r][c] == 'X') blanks.add(new int[] {r, c}); // 
			}
		}
		
		answer = false;
		setObject(0, 0);
		
		System.out.println(answer ? "YES" : "NO");
		br.close();
	}

}
