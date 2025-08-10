package 백준.백준_7000_7999.백준_7562_나이트의이동_S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_7562_나이트의이동_S1_308ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		// 8방향 나이트
		int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
		int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
		
		while(T --> 0) {
			int N = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int[][] count = new int[N][N];
			count[x1][y1] = 0;

			boolean[][] visited = new boolean[N][N];
			visited[x1][y1] = true;
					
			Queue<int[]> q = new ArrayDeque<>();
			q.add(new int[] {x1, y1});
			
			while(!q.isEmpty()) {
				int[] now = q.poll();
				int x = now[0];
				int y = now[1];
				
				if(x == x2 && y == y2) break;
				
				for(int i=0; i<8; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if(nx < 0 || nx >=N || ny < 0 || ny >= N) continue;
					if(visited[nx][ny]) continue;
					count[nx][ny] = count[x][y] + 1;
					q.add(new int[] {nx, ny});
					visited[nx][ny] = true;
				}
			}
			
			sb.append(count[x2][y2]).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}

}
