package 코드트리.코드트리_삼성SW역량테스트.코드트리_토스트계란틀_L11_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_코드트리_토스트계란틀_L11_204ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[][] egg = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				egg[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean flag;
		int result = 0;
		while(true) {
			flag = false;
			boolean[][] visited = new boolean[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(visited[i][j]) continue;
					
					Queue<Integer> qx = new ArrayDeque<>();
					Queue<Integer> qy = new ArrayDeque<>();
					
					qx.add(i);
					qy.add(j);
					
					visited[i][j] = true;
					
					int sum = egg[i][j];
					int cnt = 1;
					
					Queue<Integer> eggX = new ArrayDeque<>();
					Queue<Integer> eggY = new ArrayDeque<>();
					eggX.add(i);
					eggY.add(j);
					
					while(!qx.isEmpty()) {
						int x = qx.poll();
						int y = qy.poll();
						
						for(int k=0; k<4; k++) {
							int nx = x + dx[k];
							if(nx < 0 || nx >= N) continue;
							
							int ny = y + dy[k];
							if(ny < 0 || ny >= N) continue;
							
							if(visited[nx][ny]) continue;
							
							if(Math.abs(egg[x][y] - egg[nx][ny]) >= L && Math.abs(egg[x][y] - egg[nx][ny]) <= R) {
								qx.add(nx);
								qy.add(ny);
								
								sum += egg[nx][ny];
								cnt++;
								
								eggX.add(nx);
								eggY.add(ny);
								
								visited[nx][ny] = true;
							}
						}
					}
					
					if(cnt > 1) {
						flag = true;
						int flat = sum / cnt;
						
						while(!eggX.isEmpty()) {
							egg[eggX.poll()][eggY.poll()] = flat;
						}
					}
				}
			}
			
			if(!flag) break;
			result++;
		}
		
		System.out.println(result);
		br.close();
	}

}
