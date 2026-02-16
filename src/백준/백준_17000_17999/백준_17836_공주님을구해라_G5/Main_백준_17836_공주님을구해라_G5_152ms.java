package 백준.백준_17000_17999.백준_17836_공주님을구해라_G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_백준_17836_공주님을구해라_G5_152ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[N][M];
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m=0; m<M; m++) {
				map[n][m] = st.nextToken().charAt(0);
			}
		}
		
		int ans = 10001;
		int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
		boolean[][][] visited = new boolean[N][M][2]; // state: hasSword
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		if(map[0][0] == '2') {
			visited[0][0][1] = true;
			queue.add(new int[] {0, 0, 0, 1}); // r, c, t, false
		} else {
			visited[0][0][0] = true; // 0
			queue.add(new int[] {0, 0, 0, 0}); // r, c, t, false
		}
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			
			if(now[0] == N-1 && now[1] == M-1) {
				ans = Math.min(ans, now[2]);
				continue;
			}
			
			if(now[2] >= T) continue;

			for(int d=0; d<4; d++) {
				int nr = now[0] + dr[d];
				int nc = now[1] + dc[d];
				
				int hasSword = now[3];
				if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				if(visited[nr][nc][hasSword]) continue;
				if(hasSword == 0 && map[nr][nc] == '1') continue;
				visited[nr][nc][hasSword] = true;
				if(map[nr][nc] == '2') hasSword = 1;
				queue.add(new int[] {nr, nc, now[2] + 1, hasSword});
			}
		}
		
		System.out.println(ans <= T ? ans : "Fail");
		br.close();
	}

}
