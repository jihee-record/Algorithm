package 백준.백준_3000_3999.백준_3109_빵집_G2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_3109_빵집_G2_368ms {
	static int R, C, ans;
	static char[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1};

	static boolean dfs(int r, int c) {
		if(c == C-1) return true;
		
		for(int d=0; d<3; d++) {
			int nr = r + dr[d];
			int nc = c + 1;
			if(nr < 0 || nr >= R || nc >= C) continue;
			if(map[nr][nc] == 'x') continue;
			if(visited[nr][nc]) continue;
			visited[nr][nc] = true;
			if(dfs(nr, nc)) return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for(int r=0; r<R; r++) {
			String input = br.readLine();
			for(int c=0; c<C; c++) {
				map[r][c] = input.charAt(c);
			}
		}
		
		visited = new boolean[R][C];
		ans = 0;
		
		for(int i=0; i<R; i++) if(dfs(i, 0)) ans++;
		
		System.out.println(ans);
		br.close();
	}

}
