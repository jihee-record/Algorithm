package 백준.백준_17000_17999.백준_17387_선분교차2_G2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// long 주의
public class Main_백준_17387_선분교차2_G2_88ms {
	//AB AC
	static int ccm(long x1, long y1, long x2, long y2, long x3, long y3) {
		long v = (x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1);
		if(v > 0) return 1;
		if(v < 0) return -1;
		return 0;
	}
	
	// 구간 교차 확인 [a, b] [c, d]
	static boolean overlap(int a, int b, int c, int d) {
		if(a > b) { int t = a; a = b; b= t; }
		if(c > d) { int t = c; c = d; d= t; }
		
		return Math.max(a, c) <= Math.min(b, d);
	}
	
	// AB CD
	static boolean intersect(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
		int ab_c = ccm(x1, y1, x2, y2, x3, y3);
		int ab_d = ccm(x1, y1, x2, y2, x4, y4);
		int cd_a = ccm(x3, y3, x4, y4, x1, y1);
		int cd_b = ccm(x3, y3, x4, y4, x2, y2);
		
		if(ab_c == 0 && ab_d == 0) { // 일직선
			return overlap(x1, x2, x3, x4) && overlap(y1, y2, y3, y4);
		}
		
		return (ab_c * ab_d) <= 0 && (cd_a * cd_b) <= 0;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//AB
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());
		
		//CD
		st = new StringTokenizer(br.readLine());
		int x3 = Integer.parseInt(st.nextToken());
		int y3 = Integer.parseInt(st.nextToken());
		int x4 = Integer.parseInt(st.nextToken());
		int y4 = Integer.parseInt(st.nextToken());
		
		System.out.println(intersect(x1, y1, x2, y2, x3, y3, x4, y4) ? 1 : 0);
		br.close();
	}

}
