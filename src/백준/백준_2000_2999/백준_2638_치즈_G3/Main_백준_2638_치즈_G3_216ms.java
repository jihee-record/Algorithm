package 백준.백준_2000_2999.백준_2638_치즈_G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_백준_2638_치즈_G3_216ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // r
		int M = Integer.parseInt(st.nextToken()); // c
		
		int cheese = 0;
		char[][] map = new char[N][M];
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m=0; m<M; m++) {
				map[n][m] = st.nextToken().charAt(0);
				if(map[n][m] == '1') cheese ++;
			}
		}
				
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		int answer = 0;
		while(cheese > 0) {
			answer ++;
			
			boolean[][] visited = new boolean[N][M];
			int[][] faced = new int[N][M];
			
			ArrayDeque<int[]> queue = new ArrayDeque<>();
			visited[0][0] = true;
			queue.add(new int[] {0, 0});
			
			while(!queue.isEmpty()) {
				int[] now = queue.poll();
				for(int d=0; d<4; d++) {
					int nr = now[0] + dr[d];
					int nc = now[1] + dc[d];
					
					if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
					
					if(visited[nr][nc]) continue;
					
					if(map[nr][nc] == '0') {
						visited[nr][nc] = true;
						queue.add(new int[] {nr, nc});
					
					} else { // if(map[nr][nc] == '1') { // 치즈
						if(++faced[nr][nc] == 2) { // 2면 접촉
							cheese --;
							map[nr][nc] = '0'; // 녹음
							visited[nr][nc] = true; 
						}
						
					}
					
				}
			}
		}
		
		System.out.println(answer);
		br.close();
	}

}
