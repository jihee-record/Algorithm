package 백준.백준_17000_17999.백준_17141_연구소2_G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_17141_연구소2_G4_252ms {
	static class Virus {
		int r, c, t;
		
		Virus(int r, int c, int t){
			this.r = r;
			this.c = c;
			this.t = t;
		}
	}
	
	static int[] select;
	static ArrayList<int[]> selectList;
	static int N, M, W;
	
	static void combination(int n, int cnt) {
		if(cnt == M) {
			int[] selected = new int[M];
			for(int m=0; m<M; m++) {
				selected[m] = select[m];
			}
			selectList.add(selected);
			return; 
		}
		
		if(n == W) return; // W: 2의 개수 < N
		
		select[cnt] = n;
		combination(n+1, cnt+1);
		combination(n+1, cnt);
	}
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 연구소 n*n
		M = Integer.parseInt(st.nextToken()); // 바이러스
		
		int[][] map = new int[N][N];
		ArrayList<Virus> virus = new ArrayList<>();
		int blank = 0; // 빈칸의 개수
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == 2) virus.add(new Virus(r, c, 0));
				if(map[r][c] != 1) blank++; // 2도 빈칸 (바이러스를 놓을 수 있는)
			}
		}
		
		select = new int[M];
		W = virus.size();
		selectList = new ArrayList<>();
		combination(0, 0);
		
//		for(int[] arr: selectList) {
//			for(int a : arr) System.out.print(a + " ");
//			System.out.println();
//		}
		
		int minTime = 3000; // 최대 2500초
		boolean canSpread = false;
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		// 바이러스 선택
		for(int[] selected: selectList) {
			
			boolean[][] visited = new boolean[N][N];
			Queue<Virus> queue = new LinkedList<>();
			
			for(int m=0; m<M; m++) {
				Virus v = virus.get(selected[m]);
				queue.add(v);
				visited[v.r][v.c] = true;
			}
			
			int caseTime = 0;
			int caseBlank = blank;
			while(!queue.isEmpty()) {
				Virus v = queue.poll();
				caseTime = Math.max(caseTime, v.t);
				caseBlank--;
				
				for(int d=0; d<4; d++) {
					int nr = v.r + dr[d];
					int nc = v.c + dc[d];
					
					if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
					
					if(visited[nr][nc] || map[nr][nc] == 1) continue;
					
					visited[nr][nc] = true;
					queue.add(new Virus(nr, nc, v.t + 1));
				}
			}
			
			if(caseBlank > 0) continue;
			
			minTime = Math.min(minTime, caseTime);
			canSpread = true;
		}
		
		System.out.println(canSpread? minTime : -1);
		br.close();
	}

}
