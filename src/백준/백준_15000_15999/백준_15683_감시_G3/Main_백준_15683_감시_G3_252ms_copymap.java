package 백준.백준_15000_15999.백준_15683_감시_G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 0 : 빈칸, 1~5 : CCTV, 6:벽
public class Main_백준_15683_감시_G3_252ms_copymap {
	static char[][] map;
	static int N, M, minRemain, cctvCnt;
	static ArrayList<int[]> cctvList;
	
	
	static void direct(int i, int remain) {
		if(minRemain == 0) return;
		
		if(i == cctvCnt) {
			minRemain = Math.min(remain, minRemain);
			return;
		}
		
		if(remain == 0) {
			minRemain = 0;
			return;
		}
		
		int[] cctv = cctvList.get(i);
		int no = cctv[0];
		int r = cctv[1];
		int c = cctv[2];
		
		switch(no) {
		case 1: case1(i, r, c, remain);
			break;
		case 2: case2(i, r, c, remain);
			break;
		case 3: case3(i, r, c, remain);
			break;
		case 4: case4(i, r, c, remain);
			break;
		case 5: case5(i, r, c, remain);
			break;
		}
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static void case1(int i, int r, int c, int remain) {
		char[][] tempMap = new char[N][M];
		for(int n=0; n<N; n++) tempMap[n] = Arrays.copyOf(map[n], M);
		for(int d=0; d<4; d++) {
			int tempRemain = remain;
			tempRemain -= common(r, c, d);
			direct(i + 1, tempRemain);
			for(int n=0; n<N; n++) map[n] = Arrays.copyOf(tempMap[n], M);
		}
	}
	
	static void case2(int i, int r, int c, int remain) {
		char[][] tempMap = new char[N][M];
		for(int n=0; n<N; n++) tempMap[n] = Arrays.copyOf(map[n], M);
		for(int k=0; k<4; k=k+2) { // 2가지
			int tempRemain = remain;
			for(int l=0; l<2; l++) {// (0,1) (2,3)
				int d = k + l;
				tempRemain -= common(r, c, d);
			}
			direct(i + 1, tempRemain);
			for(int n=0; n<N; n++) map[n] = Arrays.copyOf(tempMap[n], M);
		}
	}
	
	static void case3(int i, int r, int c, int remain) {
		char[][] tempMap = new char[N][M];
		for(int n=0; n<N; n++) tempMap[n] = Arrays.copyOf(map[n], M);
		for(int k=0; k<2; k++) {
			for(int l=3-k; l>=2-k; l--) {
				int tempRemain = remain;
				for(int d=k; d<=k+l; d=d+l) {
					tempRemain -= common(r, c, d);
				}
				direct(i + 1, tempRemain);
				for(int n=0; n<N; n++) map[n] = Arrays.copyOf(tempMap[n], M);
			}
		}
	}
	
	static void case4(int i, int r, int c, int remain) {
		char[][] tempMap = new char[N][M];
		for(int n=0; n<N; n++) tempMap[n] = Arrays.copyOf(map[n], M);
		for(int k=0; k<4; k++) {
			int tempRemain = remain;
			for(int d=0; d<4; d++) {
				if(k == d) continue;
				tempRemain -= common(r, c, d);
			}
			direct(i + 1, tempRemain);
			for(int n=0; n<N; n++) map[n] = Arrays.copyOf(tempMap[n], M);
		}
	}
	
	static void case5(int i, int r, int c, int remain) {
		char[][] tempMap = new char[N][M];
		for(int n=0; n<N; n++) tempMap[n] = Arrays.copyOf(map[n], M);
		int tempRemain = remain;
		for(int d=0; d<4; d++) {
			tempRemain -= common(r, c, d);
		}
		direct(i + 1, tempRemain);
		for(int n=0; n<N; n++) map[n] = Arrays.copyOf(tempMap[n], M);
	}
	
	static int common(int nr, int nc, int d) {
		int cnt = 0;
		while(true) {
			nr += dr[d];
			nc += dc[d];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= M) break;
			if(map[nr][nc] == '#') continue;
			if(map[nr][nc] == '6') break;
			if(map[nr][nc] - '0' > 0) continue; // 다른 cctv 건너띄기
			
			map[nr][nc] = '#'; // 체크
			cnt++;
		}
		return cnt;
	}
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		minRemain = 0;
		cctvList = new ArrayList<>();
		map = new char[N][M];
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m=0; m<M; m++) {
				map[n][m] = st.nextToken().charAt(0);
				int temp = map[n][m] - '0';
				if(temp == 0) minRemain ++;
				else if(temp != 6) cctvList.add(new int[] {temp, n, m});
			}
		}
		
		cctvCnt = cctvList.size();
		
		direct(0, minRemain);
		
		System.out.println(minRemain);
		br.close();
	}

}
