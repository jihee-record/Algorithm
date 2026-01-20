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
public class Main_백준_1103_게임_G2_104ms_dp {
	static int N, M;
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean[][] visited;
	static int[][] dp;
	static boolean infinite = false;
	static int max = 0;
	
	static int dfs(int r, int c) {
		if(infinite) return 0;
		
		if(dp[r][c] != 0) return dp[r][c];
		
		if(visited[r][c]) {
			infinite = true;
			return 0;
		}
		
		visited[r][c] = true;
		
		int cnt = 1;
		
		for(int i=0; i<4; i++) {
			int nr = r + map[r][c] * dr[i];
			int nc = c + map[r][c] * dc[i];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == -1) continue;
			cnt = Math.max(cnt, dfs(nr, nc) + 1);
		}
		
		visited[r][c] = false;
		return dp[r][c] = cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		dp = new int[N][M];
		
		for(int n=0; n<N; n++) {
			String input = br.readLine();
			for(int m=0; m<M; m++) {
				char c = input.charAt(m);
				if(c == 'H') map[n][m] = -1;
				else map[n][m] = c - '0';
			}
		}

		visited = new boolean[N][M];
		
		int max = dfs(0, 0);
		System.out.print(infinite ? -1 : max);
		br.close();
	}

}
