package SWEA.SWEA_7000_7999.SWEA_7733_치즈도둑_D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_7733_치즈도둑_D4_이지희_358ms {
	
	static int[] dr = {-1, 1, 0, 0}; // 상하좌우 행
	static int[] dc = {0, 0, -1, 1}; // 상하좌우 열
	static int[][] map;
	static boolean[][] visited;
	static int N, day, maxDay; //치즈 한 변의 길이, 며칠째, 100까지말고 가장큰맛
	static int maxMass;
	
	// 어느 덩어리에서 어느 날 체크중 day는 전역변수
	static void bfs(int row, int col) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {row, col}); // 새로운 덩어리 조각 하나 넣어두고 시작
		
		while(!queue.isEmpty()) {
			int[] cheese = queue.poll();
			int r = cheese[0];
			int c = cheese[1];
			for(int i=0; i<4; i++) {
				int nxtR = r + dr[i]; 
				int nxtC = c + dc[i]; 
				// 벗어나지 않았고,
				// 범위 확인
				if(nxtR<0 || nxtR>=N || nxtC<0 || nxtC>=N) {
					continue;
				}
				
				// 방문을 안했으며 아직 살아있는 치즈면
				if(!visited[nxtR][nxtC]) {
					visited[nxtR][nxtC] = true; // 확인체크
					if(map[nxtR][nxtC]>day) {
						// 다음 체크할 목록으로 추가함
						queue.add(new int[] {nxtR, nxtC});
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];
			for(int row=0; row<N; row++) {
				st = new StringTokenizer(br.readLine());
				for(int col=0; col<N; col++) {
					map[row][col] = Integer.parseInt(st.nextToken());
					maxDay = Math.max(maxDay, map[row][col]);
				}// for col 종료
			}// for row 종료
			
			maxMass = 1;
			for(day = 1; day<=maxDay; day++) {
				int mass = 0;
				for(int i=0; i<N; i++) {
					Arrays.fill(visited[i], false); // 새로시작
				}
				for(int r=0; r<N; r++) {
					for(int c=0; c<N; c++) {
						// 방문전이고 먹지 않은 부분을 체크해야해
						if(!visited[r][c]) {
							visited[r][c] = true;
							if(map[r][c]>day) {
								mass++; //새로운 덩어리가 발견 되었으니 Mass카운트
								bfs(r, c);
							}
						}
					}
				}
				maxMass = Math.max(mass, maxMass);
			}
			
			sb.append("#").append(t).append(" ").append(maxMass).append("\n");
		}// for t 종료
		
		System.out.println(sb.toString());
		br.close();
	}

}
