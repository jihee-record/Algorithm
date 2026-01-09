package 백준.백준_1000_1999.백준_1520_내리막길_G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_1520_내리막길_G3_356ms {
	static int[][] map;
	static int[][] dp;
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {1, -1, 0, 0};
	static int M, N;
	
	static int dfs(int r, int c) {
		if(dp[r][c] != -1) return dp[r][c];
		
		int cnt = 0;
		for(int d=0; d<4; d++) {
			int nr = r + dr[d]; // before
			int nc = c + dc[d]; // before
			
			if(nr < 0 || nr >= M || nc < 0 || nc >= N) continue;
			
			if(map[r][c] < map[nr][nc]) cnt += dfs(nr, nc);
		}
		
		return dp[r][c] = cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken()); // 세로
		N = Integer.parseInt(st.nextToken()); // 가로/
		
		map = new int[M][N];
		dp = new int[M][N];
		
		for(int m=0; m<M; m++) {
			Arrays.fill(dp[m], -1);
			st = new StringTokenizer(br.readLine());
			for(int n=0; n<N; n++) {
				map[m][n] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = 1;
		
		System.out.print(dfs(M-1, N-1));
		br.close();
	}
	
	

}
