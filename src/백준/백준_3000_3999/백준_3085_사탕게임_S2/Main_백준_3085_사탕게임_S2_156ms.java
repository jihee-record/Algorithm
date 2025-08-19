package 백준.백준_3000_3999.백준_3085_사탕게임_S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_3085_사탕게임_S2_156ms {
	
	static int N;
	static char[][] map;
	
	static void swap(int r, int c, int nr, int nc) {
		char temp = map[r][c];
		map[r][c] = map[nr][nc];
		map[nr][nc] = temp;
	}
	
	static int check() {
		int max = 0;
		// 행
		for(int r=0; r<N; r++) {
			int cnt = 1;
			for(int c=1; c<N; c++) {
				if(map[r][c] == map[r][c-1]) {
					cnt++;
				}else {
					max = Math.max(max, cnt);
					cnt = 1;
				}
				max = Math.max(max, cnt);
			}
		}
		
		//열
		for(int c=0; c<N; c++) {
			int cnt = 1;
			for(int r=1; r<N; r++) {
				if(map[r][c] == map[r-1][c]) {
					cnt++;
				}else {
					max = Math.max(max, cnt);
					cnt = 1;
				}
				max = Math.max(max, cnt);
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		for(int r=0; r<N; r++) {
			String str = br.readLine();
			for(int c=0; c<N; c++) {
				map[r][c] = str.charAt(c);
			}
		}
		
		int max = 0;
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(c + 1 < N && map[r][c] != map[r][c+1]) {
					swap(r, c, r, c+1);
					max = Math.max(max, check());
					swap(r, c, r, c+1);
				}
				
				if(r + 1 < N && map[r][c] != map[r+1][c]) {
					swap(r, c, r+1, c);
					max = Math.max(max, check());
					swap(r, c, r+1, c);
				}
			}
		}
		
		
		System.out.println(max);
		br.close();
	}

}
