package 백준.백준_2000_2999.백준_2146_다리만들기_G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_백준_2146_다리만들기_G3_136ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][N];
		
		int no = 0;
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(visited[r][c]) continue;
				if(map[r][c] == 0) continue;
				
				no --;  // 섬 번호 세팅
				ArrayDeque<int[]> temp = new ArrayDeque<>();
				visited[r][c] = true;
				temp.add(new int[] {r, c});
				
				while(!temp.isEmpty()) {
					int[] now = temp.poll();
					int tr = now[0];
					int tc = now[1];
					map[tr][tc] = no;
					
					boolean ocean = false;
					for(int i=0; i<4; i++) {
						int nr = tr + dr[i];
						int nc = tc + dc[i];
						
						if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
						if(visited[nr][nc]) continue;
						
						if(map[nr][nc] > 0) {
							visited[nr][nc] = true;
							temp.add(new int[] {nr, nc});
						}else {
							ocean = true; // 섬의 경계
						}
					}
					
					if(ocean) { // 경계만 추가 - 나머지는 의미 없음
						queue.add(new int[] {tr, tc, no, 0}); // r, c, no(출발 섬), d (다리 길이)
					}
				}
			}
		}
		
		int[][] island = new int[N][N]; // dist 배열의 최소 길이를 만든 출발 섬 번호
		int[][] dist = new int[N][N]; // 해당 위치 까지 놓은 최소 다리 길이
		
		int min = Integer.MAX_VALUE;
		while(!queue.isEmpty()) {
			int now[] = queue.poll();
			
			if(min <= now[3]) continue; // 최소 거리보다 길어짐
			
			for(int i=0; i<4; i++) {
				int nr = now[0] + dr[i];
				int nc = now[1] + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if(map[nr][nc] < 0) {
					if(now[2] != map[nr][nc]) min = Math.min(min, now[3]); // 다른섬도착 갱신 - 길이 1만 나오는 케이
					continue; // 같은섬은 버리고, 다른섬이면 길이만 갱신하고 더 이을 필요없음 
				}
				
				if(dist[nr][nc] > 0) { // 이미 도착한 다른 섬에서 출발한 다리가 있음
					if(island[nr][nc] == now[2]) { // 같은 섬에서 출발 한경우
						if(dist[nr][nc] <= now[3] + 1) continue; // 같은 섬에서 출발 갱신 불가일 때
						dist[nr][nc] = now[3] + 1; // 갱신
				        queue.add(new int[] {nr, nc, now[2], now[3]+1});
					} else {
						// 다른 섬에서 온 다리랑 만난 건 다리를 이으면 섬끼리 연결된다는 것
						// 갱신: 지금까지 다리랑 + 다른데서 온 다리 합침
						min = Math.min(min, now[3] + dist[nr][nc]); 
					}
					
					continue;
				}
				
				// 다리 연장
				dist[nr][nc] = now[3] + 1; 
				island[nr][nc] = now[2];
				queue.add(new int[] {nr, nc, now[2], now[3]+ 1});
			}
		}
		
		System.out.println(min);
		br.close();
	}

}
