package 백준.백준_17000_17999.백준_17144_미세먼지안녕_G4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_17144_미세먼지안녕_G4_256ms {
	static int R, C, T;
	static int[][] map;
	static int cleaner_up, cleaner_down; // 0 :위쪽 행, 1 :아래쪽 행
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static void spread() {
		int[][] temp = new int[R][C]; //확산 후
		
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(map[r][c] > 0) { // 먼지가 있을 때
					int remain = map[r][c];
					int weight = remain/5; // 한 방향에 확산되는 양(무게)
					for(int d=0; d<4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						
						if(nr<0 || nr>=R || nc<0 || nc>=C) { // 벗어남
							continue;
						}
						
						if(map[nr][nc] == -1) { // 공기청정기 위치
							continue;
						}
						
						// 확산ok
						temp[nr][nc] += weight; // 5분의 1만큼 그 방향으로 확산
						remain = remain - weight; // 확산 된 만큼 본래 위치에서는 먼지가 빠짐
					}
					
					temp[r][c] = temp[r][c] + remain; // 여기서 확산 이후 남은 먼지양 추가
				}
			}
		}
		
		// 확산 종료
		map = temp;
		// 공기청정기 세팅
		map[cleaner_up][0] = -1;
		map[cleaner_down][0] = -1;
	}
	
	static void cleanUpper() {
		int r = cleaner_up;
		int c = 0;
		int tobe = 0; 
		
		for(int i=1; i<C; i++) { //오른쪽으로 이동
			c++;
			tobe = change(tobe, r, c);
		}
		
		for(int i=0; i<cleaner_up; i++) { //위로 이동
			r--;
			tobe = change(tobe, r, c);
		}
		
		for(int i=1; i<C; i++) { //왼쪽으로 이동
			c--;
			tobe = change(tobe, r, c);
		}
		
		for(int i=1; i<cleaner_up; i++) {//아래로 이동
			r++;
			tobe = change(tobe, r, c);
		}
	}
	
	static void cleanLower() {
		int r = cleaner_down;
		int c = 0;
		int tobe = 0; 
		
		for(int i=1; i<C; i++) { //오른쪽으로 이동
			c++;
			tobe = change(tobe, r, c);
		}
		
		for(int i=cleaner_down+1; i<R; i++) { //아래로 이동
			r++;
			tobe = change(tobe, r, c);
		}
		
		for(int i=1; i<C; i++) { //왼쪽으로 이동
			c--;
			tobe = change(tobe, r, c);
		}
		
		for(int i=R-2; i>cleaner_down; i--) {
			r--;
			tobe = change(tobe, r, c);
		}
	}
	
	static int change(int before, int r, int c) {
		int temp  = map[r][c]; //다음 위치로 보낼 먼지 
		map[r][c] = before; //지금 위치로 온 먼지
		return temp;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken()); //행
		C = Integer.parseInt(st.nextToken()); //열
		T = Integer.parseInt(st.nextToken()); //초
		
		map = new int[R][C];
		
		boolean flag = false; //위 쪽 등록했는지 
		for(int r=0; r<R; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == -1) {
					if(flag) {
						cleaner_down = r;
					}else { // 위쪽 행부터 차례로 내려오기때문에 아직 등록전이면 공기청정기 위쪽임
						cleaner_up = r;
						flag = true;
					}
				}
			}
		}
		
		for(int t=0; t<T; t++) {
			spread();
			cleanUpper();
			cleanLower();
		}
		
		int remains = 0;
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(map[r][c] > 0) remains += map[r][c];
			}
		}
		
		System.out.println(remains);
		br.close();
	}
}
