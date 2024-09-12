package 백준.백준_7000_7999.백준_7576_토마토_G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_7576_토마토_G5_580ms {
	static class Tomato {
		int x;
		int y;
		int d;
		
		public Tomato(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
	
	static int M, N;
	static int[][] box;
	static int[] x = {-1, 1, 0, 0};
	static int[] y = {0, 0, -1, 1};
	static int days = 0;
	static int not_exist = 0; //상자의 빈 칸 개수
	static int ripe = 0; //익은 토마토 개수
	static Queue<Tomato> queue = new LinkedList<>();
	
	static void BFS() {
		while(!queue.isEmpty()) {
			Tomato tomato = queue.poll();
			
			for(int i=0; i<4; i++) {
				int dx = tomato.x + x[i];
				int dy = tomato.y + y[i];
				
				if(dx<0 || dx>=M || dy<0 || dy>=N) continue; //박스 좌표 오류
				if(box[dx][dy] == 1) continue; //익은 토마토
				if(box[dx][dy] == -1) continue; //토마토 없음
				
				//안 익은 토마토 익을 차례
				box[dx][dy] = 1;
				ripe ++;
				queue.add(new Tomato(dx, dy, tomato.d + 1));
				days = tomato.d + 1;
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		box = new int[M][N];
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int m=0; m<M; m++) {
				box[m][n] = Integer.parseInt(st.nextToken());
				if(box[m][n] == 1) {
					queue.add(new Tomato(m, n, 0));
					ripe ++;
					continue;
				}
				if(box[m][n] == -1) {
					not_exist++;
					continue;
				}
			}
		}
		
		//처음부터 다 익은 경우
		if(ripe == M*N-not_exist) {
			System.out.println(0);
			return;
		}
		
		//며칠 익히고
		BFS();
		
		//익을 수 없는 토마토가 있는 경우
		if(ripe < M*N-not_exist) {
			System.out.println(-1);
			return;
		}
		
		//다 익은 경우
		System.out.println(days);
		br.close();
	}
}
