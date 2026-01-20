package 백준.백준_1000_1999.백준_1103_게임_G2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 3 7
3942178
1234567
9123532
 */
public class Main_백준_1103_게임_G2 {
	static int N, M;
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean[][] visited;
	static boolean infinite = false;
	static int max = 0;
	
	static void dfs(int r, int c, int move) {
		if(infinite) return;
		max = Math.max(max, move); // for 문 안에서 할거면 초기값 1로 해야함
		
		for(int i=0; i<4; i++) {
			int nr = r + map[r][c] * dr[i];
			int nc = c + map[r][c] * dc[i];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == -1) continue;
			
			if(visited[nr][nc]) {
				infinite = true;
				return;
			}

			visited[nr][nc] = true;
			dfs(nr, nc, move + 1);
			visited[nr][nc] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int n=0; n<N; n++) {
			String input = br.readLine();
			for(int m=0; m<M; m++) {
				char c = input.charAt(m);
				if(c == 'H') map[n][m] = -1;
				else map[n][m] = c - '0';
			}
		}

		visited = new boolean[N][M];
		visited[0][0] = true;
		
		dfs(0, 0, 1);
		System.out.print(infinite ? -1 : max);
		br.close();
	}

}
