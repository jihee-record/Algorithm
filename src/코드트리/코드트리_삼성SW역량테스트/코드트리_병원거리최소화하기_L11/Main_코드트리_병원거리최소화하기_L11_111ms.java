package 코드트리.코드트리_삼성SW역량테스트.코드트리_병원거리최소화하기_L11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_코드트리_병원거리최소화하기_L11_111ms {
	
	static int N, M, min;
	static int[][] map;
	static List<int[]> people, hospitals;
	static List<Integer> selected;
	
	static void destroy(int idx, int cnt) {
		if(cnt == M) {
			calcul();
			return;
		}
		
		if(idx >= hospitals.size()) {
			return;
		}
		
		selected.add(idx);
		destroy(idx + 1, cnt + 1);
		
		selected.remove(selected.size() - 1);
		destroy(idx + 1, cnt);
	}
	
	static void calcul() {
		int sum = 0;
		for(int[] p : people) {
			int minD = Integer.MAX_VALUE;
			for(int idx : selected) {
				minD = Math.min(minD, distance(p, hospitals.get(idx)));
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
		hospitals = new ArrayList<>();
		
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == 1) people.add(new int[] {r, c});
				else if(map[r][c] == 2) hospitals.add(new int[] {r, c});
			}
		}
		
		selected = new ArrayList<>();
		min = Integer.MAX_VALUE;
		
		destroy(0, 0);
		System.out.println(min);
		br.close();
	}

}
