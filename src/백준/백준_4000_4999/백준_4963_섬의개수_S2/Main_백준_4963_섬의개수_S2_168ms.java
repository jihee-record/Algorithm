package 백준.백준_4000_4999.백준_4963_섬의개수_S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_4963_섬의개수_S2_168ms {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
		int[] dy = {0, 0, -1, 1, -1, 1, 1, -1};
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			if(w == 0 && h == 0) {
				break;
			}
			
			Queue<int[]> q = new ArrayDeque<>();

			int[][] map = new int[h][w];
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) q.add(new int[] {i, j});
				}
			}
			
			boolean[][] visited = new boolean[h][w];
			
			int cnt = 0;
			while(!q.isEmpty()) {
				int[] now = q.poll();
				if(visited[now[0]][now[1]]) continue;
				
				cnt++;
				Queue<int[]> temp = new ArrayDeque<>();
				temp.add(now);
				
				while(!temp.isEmpty()) {
					int[] relate = temp.poll();
					visited[relate[0]][relate[1]] = true;
					for(int i=0; i<8; i++) {
						int nx = relate[0] + dx[i];
						int ny = relate[1] + dy[i];
						
						if(nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
						if(map[nx][ny] != 1 || visited[nx][ny]) continue;
						
						temp.add(new int[] {nx, ny});
						visited[nx][ny] = true;
					}
				}
				
			}
			
			sb.append(cnt).append("\n");
			
		}
        
        System.out.println(sb.toString());
        br.close();
	}
}
