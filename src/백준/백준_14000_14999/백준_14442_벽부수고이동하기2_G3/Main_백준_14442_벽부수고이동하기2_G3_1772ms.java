package 백준.백준_14000_14999.백준_14442_벽부수고이동하기2_G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


// bfs
public class Main_백준_14442_벽부수고이동하기2_G3_1772ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[N][M];
		for(int n=0; n<N; n++) {
			String line = br.readLine();
			for(int m=0; m<M; m++) {
				map[n][m] = line.charAt(m);
			}
		}
		
		int minD = Integer.MAX_VALUE;
		
		int[] dr = {1, -1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		boolean[][][] visited = new boolean[N][M][K+1];
		Queue<int[]> queue = new LinkedList<>();
		
		visited[0][0][0] = true;
		queue.add(new int[] {0, 0, 1, 0}); // r, c, dist, broken
		
		int er = N-1, ec = M-1;
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			
			if(now[0] == er && now[1] == ec) {
				minD = now[2];
				continue;
			}
			
			for(int i=0; i<4; i++) {
				int nr = now[0] + dr[i];
				int nc = now[1] + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || minD <= now[2]) continue;
				
				if(map[nr][nc] == '0' && !visited[nr][nc][now[3]]) {
					visited[nr][nc][now[3]] = true;
					queue.add(new int[] {nr, nc, now[2] + 1, now[3]});
				} 
				
				else if(map[nr][nc] == '1' && now[3] < K && !visited[nr][nc][now[3] + 1]) {
					visited[nr][nc][now[3] + 1] = true;
					queue.add(new int[] {nr, nc, now[2] + 1, now[3] + 1});
				}
			}
		}
		
		if(minD == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(minD);
		
		br.close();
	}

}
