package SWEA.SWEA_1000_1999.SWEA_1767_프로세서연결하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_SWEA_1767_프로세서연결하기_이지희_192ms {
	static int N, maxCore, minLength;
	static int[][] map;
	static List<int[]> cores;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static void connect(int idx, int cnt, int length) {
		if(idx == cores.size()) { // 이미 코어마다 확인이 끝났다
			// 코어를 더 많이 연결했다
			if(cnt > maxCore) {
				maxCore = cnt;
				minLength = length;
			}
			
			// 전선을 더 짧게 썼다
			if(cnt == maxCore && length < minLength) {
				minLength = length;
			}
			return;
		}
		
		// 연결된 코어수 + 남은 코어수 합쳐도 max 보다 작으면 종료
		if(cores.size() - idx + 1 + cnt < maxCore) {
			return;
		}
		
		int[] core = cores.get(idx); // 이번에 연결할 코어
		int x = core[0];
		int y = core[1];
		
		for(int d=0; d<4; d++) {
			int coreLength = canConnect(x, y, d);
			if(coreLength > 0) { // 연결 가능
				draw(x, y, d, 2); // d 방향으로 연결 가능 > 전선을 그려두고
				connect(idx+1, cnt+1, length + coreLength);	// 다음 코어 연결하러
				draw(x, y, d, 0); // 다시 되돌리기 전선 그린거 제거 
				// > 하고 다음 방향 체크
			}else {
				connect(idx+1, cnt, length);
			}
		}
	}
	
	static int canConnect(int x, int y, int dir) {
		int coreLength = 0;
		int nx = x;
		int ny = y;
		
		while(true) {
			nx = nx + dx[dir]; // 어디로 갈래?
			ny = ny + dy[dir];
			
			// 전원까지 도달하면 해당 길이 반환 - 연결 가능
			if(nx < 0 || nx >= N || ny < 0 || ny >= N) {
				return coreLength;
			}
			
			// 다른 코어나 전선을 만나는 경우
			if (map[nx][ny] != 0) {
				return -1; // 연결 불가능
			}
			
			coreLength++; // 한 칸 더 전진
		}
	}
	
	static void draw(int x, int y, int dir, int value) {
		int nx = x;
		int ny = y;
		
		while(true) {
			nx = nx + dx[dir];
			ny = ny + dy[dir];
			
			// 전원에 도달하면 끝
			if(nx < 0 || nx >= N || ny < 0 || ny >= N) {
				break;
			}
			
			map[nx][ny] = value; // 0 전선 제거, 2 전선 추가
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine().trim());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			map = new int[N][N];
			cores = new ArrayList<>();
			for(int r=0; r<N; r++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int c=0; c<N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					if(map[r][c]==1 && r!=0 && r!=N-1 && c!=0 && c!=N-1) {
						//가장자리는 연결할 필요가 없으므로 빼고 리스트에 추가
						cores.add(new int[] {r, c});
					}
				}// for c
			}// for r
			
			maxCore = 0;
			minLength = Integer.MAX_VALUE;
			
			connect(0, 0, 0);
			sb.append("#").append(t).append(" ").append(minLength).append("\n");
		}// for t
		
		System.out.println(sb.toString());
		br.close();
	}
}
