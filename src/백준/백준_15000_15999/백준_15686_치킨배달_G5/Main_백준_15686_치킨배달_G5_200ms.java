package 백준.백준_15000_15999.백준_15686_치킨배달_G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_백준_15686_치킨배달_G5_200ms {
	static int N, M, min;
	static int[][] map;
	static List<int[]> people, chickens;
	static int[] selected;
	
	static void destroy(int idx, int cnt) {
		if(cnt == M) {
			calcul();
			return;
		}
		
		if(idx >= chickens.size()) {
			return;
		}
		
		selected[cnt] = idx;
		destroy(idx + 1, cnt + 1);
		
		selected[cnt] = 0;
		destroy(idx + 1, cnt);
	}
	
	static void calcul() {
		int sum = 0;
		for(int[] p : people) {
			int minD = Integer.MAX_VALUE;
			for(int idx : selected) {
				minD = Math.min(minD, distance(p, chickens.get(idx)));
			}
			sum += minD;
		}
		
		min = Math.min(sum, min);
	}
	
	static int distance(int[] a, int[] b) {
		return Math.abs(b[0] - a[0]) + Math.abs(b[1] - a[1]);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		people = new ArrayList<>();
		chickens = new ArrayList<>();
		
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == 1) people.add(new int[] {r, c});
				else if(map[r][c] == 2) chickens.add(new int[] {r, c});
			}
		}
		
		selected = new int[M];
		min = Integer.MAX_VALUE;
		
		destroy(0, 0);
		System.out.println(min);
		br.close();
	}
}
