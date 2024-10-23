package SWEA.SWEA_Test.Test3_2_이지희;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test3_2_이지희 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N][M];
			
			for(int r=0; r<N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<M; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			int count = 0;
			boolean[][] visited = new boolean[N][M];
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					if(visited[r][c]) continue;
					
					count++;
					Queue<int[]> queue = new LinkedList<>();
					queue.add(new int[]{r, c});
					
					while(!queue.isEmpty()) {
						int[] now = queue.poll();
						
						for(int i=0; i<4; i++) {
							int nr = now[0] + dr[i];
							int nc = now[1] + dc[i];
							
							if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
							
							if(!visited[nr][nc]) {
								visited[nr][nc] = true;
								if(map[nr][nc] == 1) {
									queue.add(new int[] {nr, nc});
								}
							}
						}
					}
				}
			}
			
			sb.append("#").append(t).append(" ").append(count).append("\n");
		}
		
		System.out.println(sb.toString());
		br.close();
	}
}
