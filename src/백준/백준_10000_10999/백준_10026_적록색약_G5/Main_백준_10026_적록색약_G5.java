package 백준.백준_10000_10999.백준_10026_적록색약_G5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_백준_10026_적록색약_G5 {
	static boolean[][] visited;
	static String[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int N, normalCnt, abnormalCnt;
	
	// 일반 사람 또는 적록색약의 B 색상
	static void normal(int r, int c) {
		visited[r][c] = true;
		String color = map[r][c];
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(new int[] {r, c});
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			
			for(int i=0; i<4; i++) {
				int nr = now[0] + dr[i];
				int nc = now[1] + dc[i];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
					if(map[nr][nc].equals(color)) {
						visited[nr][nc] = true;
						queue.add(new int[] {nr, nc});
					}
				}
			}
		}
	}
	
	// 적록 색약의 R/G
	static void abnormal(int r, int c) {
		String compare = "RG";
		visited[r][c] = true;
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(new int[] {r, c});
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			
			for(int i=0; i<4; i++) {
				int nr = now[0] + dr[i];
				int nc = now[1] + dc[i];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
					if(compare.contains(map[nr][nc])) {
						visited[nr][nc] = true;
						queue.add(new int[] {nr, nc});
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new String[N][N];
		
		for(int n=0; n<N; n++) {
			map[n] = br.readLine().split("");
		}
		
		visited = new boolean[N][N];
		
		normalCnt = 0;
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(!visited[r][c]) {
					normalCnt++;
					normal(r, c);
				}
			}
		}
		
		visited = new boolean[N][N];
		abnormalCnt = 0;
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(!visited[r][c]) {
					abnormalCnt++;
					if(map[r][c].equals("B")) {
						normal(r, c);
					}else {
						abnormal(r, c);
					}
				}
			}
		}
		
		System.out.println(normalCnt + " " + abnormalCnt);
		
		br.close();
	}

}
