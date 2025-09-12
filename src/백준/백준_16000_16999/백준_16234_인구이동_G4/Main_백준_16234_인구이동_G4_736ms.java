package 백준.백준_16000_16999.백준_16234_인구이동_G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_16234_인구이동_G4_736ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[][] people = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				people[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean flag;
		int result = 0;
		
		int[][] visited = new int[N][N];
		int turn = 1;
		while(true) {
			flag = false;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(visited[i][j] == turn) continue;
					
					Queue<int[]> q = new ArrayDeque<>();
					
					q.add(new int[] {i, j});
					
					visited[i][j]++;
					
					int sum = people[i][j];
					int cnt = 1;
					
					List<int[]> wallless = new ArrayList<>();
					wallless.add(new int[] {i, j});
					
					while(!q.isEmpty()) {
						int[] now = q.poll();
						int x = now[0];
						int y = now[1];
						
						for(int k=0; k<4; k++) {
							int nx = x + dx[k];
							if(nx < 0 || nx >= N) continue;
							
							int ny = y + dy[k];
							if(ny < 0 || ny >= N) continue;
							
							if(visited[nx][ny] == turn) continue;
							
							int diff = Math.abs(people[x][y] - people[nx][ny]);
							if(diff >= L && diff <= R) {
								q.add(new int[] {nx, ny});
								
								sum += people[nx][ny];
								cnt++;
								
								wallless.add(new int[] {nx, ny});
								visited[nx][ny] = turn;
							}
						}
					}
					
					if(cnt > 1) {
						flag = true;
						int flat = sum / cnt;
						
						for(int[] town : wallless) {
							people[town[0]][town[1]] = flat;
						}
					}
				}
			}
			
			if(!flag) break;
			result++;
			turn++;
		}
		
		System.out.println(result);
		br.close();
	}

}
