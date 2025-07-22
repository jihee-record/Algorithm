package 백준.백준_1000_1999.백준_1012_유기농배추_S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_1012_유기농배추_S2_140ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
			
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int M = Integer.parseInt(st.nextToken()); // 가로
			int N = Integer.parseInt(st.nextToken()); // 세로
			int K = Integer.parseInt(st.nextToken()); // 배추 개수
				
			int[][] map = new int[M][N];
			
			Queue<int[]> q = new ArrayDeque<>();
			for(int k=0; k<K; k++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[x][y] = 1;
				
				q.add(new int[] {x, y});
			}
			
			boolean[][] visited = new boolean[M][N];
			
			int cnt = 0;
			while(!q.isEmpty()) {
				int[] cabbage = q.poll();
				int x = cabbage[0];
				int y = cabbage[1];
				
				if(visited[x][y]) continue;
				
				visited[x][y] = true;
				cnt++;
				
				Queue<int[]> temp = new ArrayDeque<>();
				temp.add(cabbage);
				while(!temp.isEmpty()) {
					int[] now = temp.poll(); 
					for(int i=0; i<4; i++) {
						int nx = dx[i] + now[0];
						int ny = dy[i] + now[1];
						
						if(nx < 0 || nx >= M || ny < 0 || ny >= N || visited[nx][ny] || map[nx][ny] != 1) continue;
						visited[nx][ny] = true;
						temp.add(new int[] {nx, ny});
					}
				}
			}
			
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb.toString());
		br.close();
	}

}
