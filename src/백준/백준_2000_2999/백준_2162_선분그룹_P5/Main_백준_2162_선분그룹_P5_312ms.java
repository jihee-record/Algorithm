package 백준.백준_2000_2999.백준_2162_선분그룹_P5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_백준_2162_선분그룹_P5_312ms {
	static int N;
	static int[] parent;
	static Line[] lines;
	
	static class Line {
		int x1, y1, x2, y2;
		
		Line(int x1, int y1, int x2, int y2){
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}
	}
	
	static int findParent(int x) {
		if(x == parent[x]) return x;
		return parent[x] = findParent(parent[x]);
	}
	
	static void union(int x, int y) {
		x = findParent(x);
		y = findParent(y);
		
		if(x == y) return;
		
		if(x < y) parent[y] = x;
		else parent[x] = y;
	}
	
	/**
	 * 해당 선분의 그룹 찾기
	 * @param idx : line index
	 */
	static void findGroup(int idx) { 
		for(int i=0; i<idx; i++) {
			if(intersect(lines[idx], lines[i])) { // 어디에 속한다면
				union(idx, i); 
			}
		}
	}
	
	// 외적 AB, AC
	static int ccw(int x1, int y1, int x2, int y2, int x3, int y3) {
		int v = (x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1); // AB 기준 C의 방향
		if(v > 0) return 1;
		if(v < 0) return -1;
		return 0; // 일직선
	}
	
	// 선분 교차 여부
	static boolean intersect(Line AB, Line CD) {
		int ab_c = ccw(AB.x1, AB.y1, AB.x2, AB.y2, CD.x1, CD.y1);
		int ab_d = ccw(AB.x1, AB.y1, AB.x2, AB.y2, CD.x2, CD.y2);
		int cd_a = ccw(CD.x1, CD.y1, CD.x2, CD.y2, AB.x1, AB.y1);
		int cd_b = ccw(CD.x1, CD.y1, CD.x2, CD.y2, AB.x2, AB.y2);
		
		// 일직선상 
		if(ab_c == 0 && ab_d == 0) return overlap(AB.x1, AB.x2, CD.x1, CD.x2) && overlap(AB.y1, AB.y2, CD.y1, CD.y2);
		
		return (ab_c * ab_d <= 0) && (cd_a * cd_b <= 0); // AB 기준 C, D각 각각 반대 방향, CD 기준 A, B 반대 방향 모두 만족
		
	}
	
	// 구간 교차 범위 체크, [a, b] vs [c, d]
	static boolean overlap(int a, int b, int c, int d) {
		// 좌표 순서 맞추기 
		if(a > b) {
			int t = a; 
			a = b; 
			b = t;
		}
		
		if(c > d) {
			int t = c; 
			c = d; 
			d = t;
		}
		
		return Math.max(a, c) <= Math.min(b, d);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		parent = new int[N];
		lines = new Line[N];
		
		for(int n=0; n<N; n++) {
			parent[n] = n;
			
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			lines[n] = new Line(x1, y1, x2, y2);
			findGroup(n);
		}
		
		HashSet<Integer> groups = new HashSet<>();
		int[] size = new int[N]; // 그룹크기
		for(int n=0; n<N; n++) {
			int root = findParent(n);
			groups.add(root); // hashset에 root들만 담아서 그룹이 총 몇개인지 판단
			size[root]++;
		}
		
		Arrays.sort(size);
		StringBuilder sb = new StringBuilder();
		sb.append(groups.size()).append('\n').append(size[N-1]);
		
		System.out.println(sb);
		br.close();
	}

}
