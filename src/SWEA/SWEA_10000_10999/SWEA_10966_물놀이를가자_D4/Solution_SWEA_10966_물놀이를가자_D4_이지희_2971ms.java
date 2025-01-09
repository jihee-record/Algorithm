package SWEA.SWEA_10000_10999.SWEA_10966_물놀이를가자_D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_10966_물놀이를가자_D4_이지희_2971ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		for(int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			String[][] map = new String[N][M]; // 물, 땅
			int[][] distance = new int[N][M]; // 물까지 최소 거리
			
			Queue<int[]> queue = new LinkedList<>(); // 물 자리들
			
			for(int n=0; n<N; n++) {
				map[n] = br.readLine().split("");
				for(int m=0; m<M; m++) {
					if(map[n][m].equals("W")) { // 물이라면
						queue.add(new int[] {n, m});
						distance[n][m] = 0 ; // 물은 물에서 끝이니까 0 설정
					}else {
						distance[n][m] = Integer.MAX_VALUE; // 육지면 최소거리를 찾아야하니까 최대로 배정
					}
				}
			}
			
			int sum = 0;
			
			while(!queue.isEmpty()) {
				int[] temp = queue.poll();
				int n = temp[0];
				int m = temp[1];
				
				sum += distance[n][m];
				
				for(int i=0; i<4; i++) {
					int nr = n + dr[i];
					int nc = m + dc[i];
					if(nr >= 0 && nr < N && nc >= 0 && nc < M && distance[nr][nc] == Integer.MAX_VALUE){
						distance[nr][nc] = distance[n][m] + 1;
						queue.add(new int[] {nr, nc});
					}
				}
			}
			
			sb.append(sum).append("\n");
		}
		
		System.out.println(sb.toString());
		br.close();
	}
}
