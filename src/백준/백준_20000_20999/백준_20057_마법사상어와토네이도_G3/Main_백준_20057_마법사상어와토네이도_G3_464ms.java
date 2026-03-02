package 백준.백준_20000_20999.백준_20057_마법사상어와토네이도_G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_20057_마법사상어와토네이도_G3_464ms {
	static int N;
	static int[][] map;
	static int[] dr = {0, 1, 0, -1}, dc = {-1, 0, 1, 0}; 
	static int totalSand;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		int r = N / 2; // 가운데 좌표
		int c = r;
		
		totalSand = 0; //밖으로 나온 모래
		int d = 3; //현재 방향
		
		boolean[][] visited = new boolean[N][N];
		visited[r][c] = true;
		
		while(true) {
			if(r == 0 && c == 0) break;
			
			int nd = (d + 1) % 4; // 다음 방향으로 가고 싶어
			int nr = r + dr[nd]; // 이제 갈 위치
			int nc = c + dc[nd];
			
			// nr < 0 || nr >= N || nc < 0 || nc >= N : 안해도 되는 이유 
			// (r, c) = (0, 0)에서 종료하고, 그 외에는 왼쪽으로 돌고 싶어해서 나갈 일이 없어
			if(!visited[nr][nc]) { // 갈수 있어
				d = nd; // 방향 바꿈
			}else { // 못가는 방향이면 기존 방향으로 가야해
				nr = r + dr[d];  
				nc = c + dc[d];
			}
			
			visited[nr][nc] = true;
			int all = map[nr][nc]; // 퍼질 모래양
			
			if(all == 0) {
				r = nr; c = nc;
				continue;
			}
			
			// 1
			int sand = (int) all / 100;
			spread(r, c, d + 3, sand, false);
			map[nr][nc] -= sand;
			spread(r, c, d + 1, sand, false);
			map[nr][nc] -= sand;
			
			r = nr;
			c = nc;
			
			// 7
			sand = (int) (all * 7 / 100);
			spread(r, c, d + 3, sand, false);
			map[r][c] -= sand;
			spread(r, c, d + 1, sand, false);
			map[r][c] -= sand;
			
			// 2
			sand = (int) (all * 2 / 100);
			spread(r, c, d + 3, sand, true);
			map[r][c] -= sand;
			spread(r, c, d + 1, sand, true);
			map[r][c] -= sand;
			
			// 10 : a
			sand = (int) (all / 10);
			nr = nr + dr[d];
			nc = nc + dc[d];
			spread(nr, nc, d + 3, sand, false);
			map[r][c] -= sand;
			spread(nr, nc, d + 1, sand, false);
			map[r][c] -= sand;
			
			// 5 
			sand = (int) (all * 5 / 100);
			spread(nr, nc, d, sand, false);
			map[r][c] -= sand;
			
			// a
			if(canSpread(nr, nc)) map[nr][nc] += map[r][c];
			else totalSand += map[r][c];
			
			map[r][c] = 0;
		}
		
		System.out.println(totalSand);
		br.close();
	}
	
	static void spread(int r, int c, int d, int sand, boolean twice) { // sand 이동량
		int nd = d % 4; 
		int nr = r + dr[nd];
		int nc = c + dc[nd];
		
		if(twice) {
			nr = nr + dr[nd];
			nc = nc + dc[nd];
		}
		
		if(canSpread(nr, nc)) {
			map[nr][nc] += sand;
		}
		else {
			totalSand += sand;
		}
	}
	
	static boolean canSpread(int r, int c) {
		return (r < 0 || r >=N || c < 0 || c >= N) ? false : true;
	}
}
