package 백준.백준_15000_15999.백준_15683_감시_G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 0 : 빈칸, 1~5 : CCTV, 6:벽
public class Main_백준_15683_감시_G3_152ms {
	static char[][] map;
	static int N, M, minRemain, cctvCnt;
	static ArrayList<int[]> cctvList;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static int[][][] dirMap = {
			{}, // 0
			{{0}, {1}, {2}, {3}}, // 1
			{{0, 1}, {2, 3}}, // 2
			{{0, 2}, {1, 2}, {0, 3}, {1, 3}}, //3
			{{1, 2, 3}, {0, 2, 3}, {0, 1, 3}, {0, 1, 2}}, //4
			{{0, 1, 2, 3}} // 5
	};
	
	
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
		
		ArrayDeque<int[]> changed = new ArrayDeque<>();
		for(int[] dir : dirMap[no]) {
			int tempRemain = remain;
			for(int d : dir) {
				tempRemain -= common(r, c, d, changed);
			}
			direct(i + 1, tempRemain);
			undo(changed);
		}
	}
	
	static int common(int nr, int nc, int d, ArrayDeque<int[]> changed) {
		int cnt = 0;
		while(true) {
			nr += dr[d];
			nc += dc[d];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= M) break;
			if(map[nr][nc] == '#') continue;
			if(map[nr][nc] == '6') break;
			if(map[nr][nc] - '0' > 0) continue; // 다른 cctv 건너띄기
			
			map[nr][nc] = '#'; // 체크
			changed.add(new int[] {nr, nc});
			cnt++;
		}
		return cnt;
	}
	
	static void undo(ArrayDeque<int[]> changed) {
		while(!changed.isEmpty()) {
			int[] now = changed.poll();
			int nr = now[0];
			int nc = now[1];
			map[nr][nc] = '0';
		}
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
