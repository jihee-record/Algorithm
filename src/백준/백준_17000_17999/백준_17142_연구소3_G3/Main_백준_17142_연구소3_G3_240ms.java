package 백준.백준_17000_17999.백준_17142_연구소3_G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 실패 사유 - 이동을 0으로만 할 수 있게 했음 : 2도 옮길 수 있음
public class Main_백준_17142_연구소3_G3_240ms {
	static int N, M, K, V;
	static int[][] lab;
	static ArrayList<Integer> inactive;
	static boolean[][] visited;
	static boolean canSpread = false;
	static int minTime = 3000;
	static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
	
	// idx : 비활성화리스트 인덱스, cnt : 선택개수-selected idx
	static void combination(int idx, int cnt, int[] selected) {
		if(V - idx < M - cnt) return; // 남은 개수가 모자름
		
		if(cnt == M) {
			spread(selected);
			return;
		}
		
		if(idx == V) return;
		
		selected[cnt] = idx;
		combination(idx + 1, cnt + 1, selected);
		combination(idx + 1, cnt, selected);
	}
	
	static void spread(int[] selected) {
		visited = new boolean[N][N];
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		for(int m=0; m<M; m++) {
			int v = inactive.get(selected[m]);
			deque.add(v);
			visited[v / N][v % N] = true;
		}
		
		int caseBlank = K;
		int caseTime = 1;
		
		while(!deque.isEmpty()) {
			if(caseTime > minTime) return;
			int size = deque.size();
			for(int s = 0 ; s < size ; s++) {
				int v = deque.poll();
				int r = v / N;
				int c = v % N;
				
				for(int d = 0 ; d < 4 ; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
					
					if(visited[nr][nc] || lab[nr][nc] == 1) continue;
					
					visited[nr][nc] = true;
					deque.add(nr * N + nc);
					
					if(lab[nr][nc] ==  0 && --caseBlank == 0) {
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
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		K = 0; // 빈 칸
		lab = new int[N][N];
		inactive = new ArrayList<>();
		
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				lab[r][c] = Integer.parseInt(st.nextToken());
				if(lab[r][c] == 2) inactive.add(r * N + c);
				else if(lab[r][c] == 0) K++; 
			}
		}
		
		V = inactive.size(); // 비활성화칸 수
		
		if(K == 0) {
			System.out.println(0);
			return;
		}
		
		combination(0, 0, new int[M]);
		
		System.out.println(canSpread ? minTime : -1);
		br.close();
	}

}
