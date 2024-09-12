package SWEA.SWEA_1000_1999.SWEA_1949_등산로조성;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_SWEA_1949_등산로조성_이지희_118ms {
	static int[][] mountain;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean[][] visited;
	static int N, K, maxH, ans; // N:2차원배열크기, K:공사가능깊이, ans : 최대길이
	static ArrayList<int[]> highest;
	
	// r, c : 현재 좌표
	// dist : 지금까지의 공사 길이, h : 현재높이
	// skill : 공사를 할 수 있는 능력을 가지고 있는가?
	static void work(int r, int c, int h, int dist, boolean skill) {
		if(dist > ans) ans = dist; // 갱신할 수 있으면 갱신
		
		visited[r][c] = true; // 방문했고
		///////////////////////////////////
		// 4방향 탐색 (상하좌우)
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			// 경계 확인, 이미 방문한 곳
			if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;
			// 1. 다음좌표의 높이가 내 높이 보다 낮다
			if(h > mountain[nr][nc])
				work(nr, nc, mountain[nr][nc], dist+1, skill); // 길이가 늘어나고
			// 2. 다음 좌표의 높이가 나와 같거나 높다
			// 2-1 : 공사가능 ) 나보다 낮도록 공사를 할 수 있다 > 하나만 작게 공사
			// 2-2 : 공사불가능 > 종료
			else if(skill && h > mountain[nr][nc] - K) {
				work(nr, nc, mountain[r][c]-1, dist+1, false);
			}
		}
		
		///////////////////// 원상복구
		visited[r][c] = false;
	}
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());// 테케
		for(int t=1; t<=T; t++) { // 테스트 반복
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 지도 한변
			K = Integer.parseInt(st.nextToken()); // 최대 공사 가능 깊이
			
			mountain = new int[N][N]; // 등산로 맵 경계 빼려고
			visited = new boolean[N][N];
			ans = 0; // 등산로길이 
			maxH = 0; // 가장 큰 높이
			for(int i=0; i<N; i++) { // 맵 정보 받기 행
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) { // 맵 정보 받기 열
					mountain[i][j] = Integer.parseInt(st.nextToken());
					if(maxH > mountain[i][j]) {
						continue;
					}else if(maxH < mountain[i][j]) { // 더 높으면 새로 만들고
						maxH = mountain[i][j];
						highest = new ArrayList<>();
					}
					highest.add(new int[] {i, j});// 더 높거나 같으면 좌표 기록
				}// for j 종료
			}// for n 종료
			
			for(int i=0; i<highest.size(); i++) {
				int[] coordi = highest.get(i);
				work(coordi[0], coordi[1], maxH, 1, true);
			}
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}// for t 종료
		
		System.out.println(sb.toString());
		br.close();
	}// main() 

}// class 
