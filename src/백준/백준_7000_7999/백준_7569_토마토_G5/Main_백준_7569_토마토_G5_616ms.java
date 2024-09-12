package 백준.백준_7000_7999.백준_7569_토마토_G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_7569_토마토_G5_616ms {
	static class Tomato{
		int x, y, z, d;
		Tomato(int x, int y, int z, int d){
			this.x = x;
			this.y = y;
			this.z = z;
			this.d = d;
		}
	}
	
	static int M, N, H;
	static int[][][] box;
	static int[] dx = {-1, 1, 0, 0, 0, 0}; 
	static int[] dy = {0, 0, 1, -1, 0, 0}; 
	static int[] dz = {0, 0, 0, 0, 1, -1}; 
	static int days = 0;
	static int not_exist = 0;
	static int ripe = 0;
	static Queue<Tomato> queue = new LinkedList<>();
	
	static void BFS() {
		while(!queue.isEmpty()) {
			Tomato tomato = queue.poll();
			
			for(int i=0; i<6; i++) {
				int x = tomato.x + dx[i];
				int y = tomato.y + dy[i];
				int z = tomato.z + dz[i];
				
				if(x<0 || x>=M || y<0 || y>=N || z<0 || z>=H || box[x][y][z] == -1 || box[x][y][z] == 1) continue;
				
				box[x][y][z] = 1;
				ripe ++;
				queue.add(new Tomato(x, y, z, tomato.d + 1));
				days = tomato.d + 1;
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		M = Integer.parseInt(st.nextToken()); //상자 가로 길이
		N = Integer.parseInt(st.nextToken()); //상자 세로 길이
		H = Integer.parseInt(st.nextToken()); //상자 높이
		
		box = new int[M][N][H];
		
		for(int h=0; h<H; h++) {
			for(int n=0; n<N; n++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int m=0; m<M; m++) {
					box[m][n][h] = Integer.parseInt(st.nextToken());
					if(box[m][n][h] == 1) {
						queue.add(new Tomato(m, n, h, 0));
						continue;
					}
					if(box[m][n][h] == -1) not_exist++;
				}
			}
		}
		
		ripe = queue.size();
		int count = M*N*H-not_exist;
		if(ripe == count) {
			System.out.println(0);
			return;
		}
		
		BFS();
		
		if(ripe < count) {
			System.out.println(-1);
			return;
		}
		
		System.out.println(days);
		br.close();
	}
}
