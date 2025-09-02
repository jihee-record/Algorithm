package 코드트리.학습체크.학습체크3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_학습체크3 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0;
		
		int N = Integer.parseInt(br.readLine()); // NxN 매트릭스
		int Q = Integer.parseInt(br.readLine()); // 명령개수
		
		int[][] map = new int[N][N];
		int[] dx = {0, 1, -1, 0}, dy = {1, 0, 0, -1};
		int x = 0, y = N-1;
		
		for(int q=0; q<Q; q++) {
			String[] input = br.readLine().split(" ");

			int dir = 0;
			switch(input[0].charAt(0)) {
			case 'N':
				break;
			case 'E':
				dir = 1;
				break;
			case 'W':
				dir = 2;
				break;
			case 'S':
				dir = 3;
				break;
			}
			
			int distance = Integer.parseInt(input[1]);
			for(int d=0; d<distance; d++) {
				int nx = x + dx[dir], ny = y + dy[dir];
				
				if(nx < 0 || nx >= N || ny <0 || ny >= N) break;
				map[nx][ny]++;
				x = nx; 
				y = ny;
			}
		}
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(map[r][c] >= 2) answer++;
			}
		}
		
		System.out.println(answer);
		br.close();
	}

}
