package 코드트리.코드트리_삼성SW역량테스트.코드트리_자율주행자동차_L11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_코드트리_자율주행자동차_L11_105ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m=0; m<M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 북동남서
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		
		int n = N-1;
		int m = M-1;
		
		boolean[][] visited = new boolean[N][M];
		visited[x][y] = true;
		
		int cnt = 1;
		while(true) {
			
			boolean move = false;
			// 4방향 확인 - 이동 후 다음 턴으로
			for(int i=1; i<=4; i++) {
				int nd = (d + i * 3) % 4;
				int nx = x + dx[nd];
				int ny = y + dy[nd];
				
//				System.out.println("nd :" + nd + ", nx:" + nx + ", ny:" + ny);
				if(nx < 0 || nx >= n || ny <= 0 || ny >= m) continue;
				if(map[nx][ny] != 0) continue;
				if(visited[nx][ny]) continue;
				
				d = nd;
				x = nx;
				y = ny;
//				System.out.println("이동)d :" + d + ", x:" + x + ", y:" + y);
				visited[x][y] = true;
				cnt++;
				move = true;
				break;
			}
			
			// 4방향 동안 이동하지 못했을 때
//			System.out.println("move:" + move + ", d: " + d);
			if(!move) {
				int nx = x - dx[d];
				int ny = y - dy[d];
				
				if(nx < 0 || nx >= n || ny <= 0 || ny >= m) break;
				if(map[nx][ny] != 0) break; 
				
				x = nx;
				y = ny;
			}
//			System.out.println("cnt: " + cnt);
		}
		
		System.out.println(cnt);
		br.close();
	}

}
