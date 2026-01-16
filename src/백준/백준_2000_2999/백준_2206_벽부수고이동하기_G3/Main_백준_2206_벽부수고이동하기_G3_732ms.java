package 백준.백준_2000_2999.백준_2206_벽부수고이동하기_G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// bfs - 상태
public class Main_백준_2206_벽부수고이동하기_G3_732ms {
	static int N, M;
	
	static class Cell {
		int r, c, d, broken;
		
		Cell(){}
		
		Cell(int r, int c, int d){
			this.r = r;
			this.c = c;
			this.d = d;
			this.broken = 0;
		}
		
		Cell(int r, int c, int d, int broken){
			this.r = r;
			this.c = c;
			this.d = d;
			this.broken = broken;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[N][M];
		for(int n=0; n<N; n++) {
			String input = br.readLine();
			for(int m=0; m<M; m++) {
				map[n][m] = input.charAt(m);
			}
		}
		
		int[] dr = {0, 0, -1, 1};
		int[] dc = {1, -1, 0, 0};
		boolean[][][] visited = new boolean[N][M][2]; // 0,1 : isBroken
		
		Queue<Cell> queue = new LinkedList<>();
		Cell cell = new Cell(0, 0, 1);
		queue.add(cell);
		
		int er = N - 1, ec = M - 1;
		while(!queue.isEmpty()) {
			cell = queue.poll();
			
			if(cell.r == er && cell.c == ec) {
				System.out.println(cell.d);
				return;
			}
			
			for(int i=0; i<4; i++) {
				int nr = cell.r + dr[i];
				int nc = cell.c + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				
				if(map[nr][nc] == '0' && !visited[nr][nc][cell.broken]) {
					visited[nr][nc][cell.broken] = true;
					queue.add(new Cell(nr, nc, cell.d + 1, cell.broken));
					
				} else if(map[nr][nc] == '1' && cell.broken == 0) {
					visited[nr][nc][1] = true;
					queue.add(new Cell(nr, nc, cell.d + 1, 1));
				}
			}
		}
		
		
		System.out.println(-1);
		br.close();
		
	}

}
