package 백준.백준_1000_1999.백준_1890_점프_S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1890_점프_S1_108ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N]; // 0~9
		
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		long[][] dp = new long[N][N]; // (i, j)까지 도착하는 방법의 수
		dp[0][0] = 1; // 출발
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(dp[r][c] == 0) continue; // 도착할 방법 없음
				if(map[r][c] == 0) continue; // 더는 갈 곳이 없음
				
				int nr = r + map[r][c];
				int nc = c + map[r][c];
				
				if(nr < N) dp[nr][c] += dp[r][c];
				if(nc < N) dp[r][nc] += dp[r][c];
				
			}
		}
		
		System.out.println(dp[N-1][N-1]);
		br.close();
	}

}
