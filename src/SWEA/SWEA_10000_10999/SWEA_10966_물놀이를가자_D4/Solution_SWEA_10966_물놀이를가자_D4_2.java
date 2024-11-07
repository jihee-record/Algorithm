package SWEA.SWEA_10000_10999.SWEA_10966_물놀이를가자_D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_10966_물놀이를가자_D4_2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		for(int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			String[][] map = new String[N][M];
			
			for(int n=0; n<N; n++) {
				map[n] = br.readLine().split("");
			}
			
			int sum = 0;
			for(int n=0; n<N; n++) {
				for(int m=0; m<M; m++) {
					if(map[n][m].equals("L")) {
						boolean[][] visited = new boolean[N][M];
						
//						List<int[]> list = new ArrayList<>();
//						int count = 0;
//						for(int i=0; i<4; i++) {
//							int nr = n + dr[i];
//							int nc = m + dc[i];
//							if(nr >= 0 && nr < N && nc >= 0 && nc < M) {
//								list.add(new int[] {nr, nc, 1});
//							}
//						}
						
						Queue<int[]> queue = new LinkedList<>();
						queue.add(new int[] {n, m, 0});
						
						while(!queue.isEmpty()) {
							int[] temp = queue.poll();
							
							if(visited[temp[0]][temp[1]]) {
								continue;
							}
							
							if(map[temp[0]][temp[1]].equals("W")) {
								sum += temp[2];
								break;
							}
							
							for(int i=0; i<4; i++) {
								int nr = temp[0] + dr[i];
								int nc = temp[1] + dc[i];
								if(nr >= 0 && nr < N && nc >= 0 && nc < M) {
									queue.add(new int[] {nr, nc, temp[2]+1});
								}
							}
							
						}
					}
				}
			}
			
			sb.append(sum).append("\n");
		}
		
		System.out.println(sb.toString());
		br.close();
	}
}
