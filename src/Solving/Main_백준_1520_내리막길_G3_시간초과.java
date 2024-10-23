package Solving;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1520_내리막길_G3_시간초과 {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int N, M, count;
	static int[][] map;
	
	static void goDown(int r, int c) {
//		System.out.println("--------------");
//		System.out.println("[진입]");
//		System.out.println("r : " + r);
//		System.out.println("c : " + c);
//		System.out.println("now : " + map[r][c]);
		
		if(r == N-1 && c == M-1) {
//			System.out.println("count ++ ");
			count ++;
			return;
		}
		
//		System.out.println("[탐색]");
		for(int i=0; i<4; i++) {
//			System.out.println("r : " + r);
//			System.out.println("c : " + c);
			int nr = r + dr[i];
			int nc = c + dc[i];
//			System.out.println("nr : " + nr);
//			System.out.println("nc : " + nc);
			if(nr < 0 || nr >= N || nc < 0 || nc >= M) {
//				System.out.println("boundary continue");
				continue;
			}
			
			if(map[nr][nc] >= map[r][c]) {
//				System.out.println("height continue");
				continue;
			}
//			System.out.println("goDown");
			goDown(nr, nc);
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로
		
		map = new int[N][M];
		count = 0;
		
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m=0; m<M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		goDown(0, 0);
		System.out.println(count);
		br.close();
	}

}
