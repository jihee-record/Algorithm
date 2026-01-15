package 백준.백준_17000_17999.백준_17141_연구소2_G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_17141_연구소2_G4_224ms_pos {
	static int[] select;
	static int N, M, W, blank;
	static int[][] map;
	static ArrayList<Integer> virus;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean canSpread = false;
	static int minTime = 3000;
	
	static void combination(int n, int cnt) {
		if(cnt == M) {
			spread(select);
			return; 
		}
		
		if(n == W) return; // W: 2의 개수 < N
		
		select[cnt] = n;
		combination(n+1, cnt+1);
		combination(n+1, cnt);
	}
	
	static void spread(int[] selected) {
		boolean[][] visited = new boolean[N][N];
		Queue<Integer> queue = new LinkedList<>();
		
		int caseBlank = blank - M;
		if(caseBlank == 0) {
			canSpread = true;
			minTime = 0;
			return;
		}
		
		for(int m=0; m<M; m++) {
			int v = virus.get(selected[m]);
			queue.add(v); //mod - qr
			visited[v / N][v % N] = true;
		}
		
		int caseTime = 1;
		while(!queue.isEmpty()) {
			if(caseTime >= minTime) return;
			
			int size = queue.size(); // 레벨로 돌리기 
			for(int s=0; s<size; s++) {
				int v = queue.poll();
				int r = v / N;
				int c = v % N;
				
				for(int d=0; d<4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
					
					if(visited[nr][nc] || map[nr][nc] == 1) continue;
					
					visited[nr][nc] = true;
					queue.add(nr * N + nc);
					
					if(--caseBlank == 0) { // 전부 채웠을 때
						canSpread = true;
						minTime = Math.min(minTime, caseTime);
						return;
					}
				}
			}
			
			caseTime++;
		}
		
	}
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 연구소 n*n
		M = Integer.parseInt(st.nextToken()); // 바이러스
		
		map = new int[N][N];
		virus = new ArrayList<>();
		blank = 0; // 빈칸의 개수
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == 2) virus.add(r * N + c);
				if(map[r][c] != 1) blank++; // 2도 빈칸 (바이러스를 놓을 수 있는)
			}
		}
		
		select = new int[M];
		W = virus.size();
		combination(0, 0);
		
		System.out.println(canSpread? minTime : -1);
		br.close();
	}

}
