package 백준.백준_20000_20999.백준_20149_선분교차3_P4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 한 직선 내 판단 후 외적으로 교점 구하기
public class Main_백준_20149_선분교차3_P4_112ms_crossproduct {
	static StringBuilder sb;
	
	// 좌표 변수 좀 줄이려고
	static class P {
		int x, y;
		
		P(int x, int y) {this.x = x; this.y = y;}
	}
	
	// AB * AC
	static int ccm(P a, P b, P c) {
		long v = 1L * (b.x - a.x) * (c.y - a.y) - 1L * (b.y - a.y) * (c.x - a.x);
		if(v < 0) return -1;
		if(v > 0) return 1;
		return 0;
	}
	
	// [a, b] [c, d]
	static int overlab(int a, int b, int c, int d) {
		if(a > b) {int t = a; a = b; b = t;}
		if(c > d) {int t = c; c = d; d = t;}
		
		return Math.min(b, d) - Math.max(a, c);
	}
	
	// AB, CD
	static void findIntersection(P a, P b, P c, P d) {
		int ab_c = ccm(a, b, c);
		int ab_d = ccm(a, b, d);
		int cd_a = ccm(c, d, a);
		int cd_b = ccm(c, d, b);
		
		if(ab_c == 0 && ab_d == 0) {
			int overlabX = overlab(a.x, b.x, c.x, d.x);
			int overlabY = overlab(a.y, b.y, c.y, d.y);
			
			if(overlabX < 0 || overlabY < 0) {
				sb.append(0);
			} 
			
			else {
				sb.append(1);
				if(overlabX == 0 && overlabY == 0) findOneOfLine(a, b, c, d);
			}
			
			return;
		}
		
		if(ab_c * ab_d > 0 || cd_a * cd_b > 0) {
			sb.append(0);
			return;
		}
		
		// 외적
		double rX = b.x - a.x, rY = b.y - a.y;
		double sX = d.x - c.x, sY = d.y - c.y;

		double denom = rX * sY - rY * sX; // AB * CD

		double t = ((c.x - a.x) * sY - (c.y - a.y) * sX) / denom; 

		double x = a.x + rX * t;
		double y = a.y + rY * t;

		sb.append(1).append('\n').append(String.format("%.10f %.10f", x, y));
	}
	
	static void findOneOfLine(P a, P b, P c, P d) {
		int x = 0, y = 0;
		if((a.x == c.x && a.y == c.y) || (a.x == d.x && a.y == d.y)) { x = a.x; y = a.y; }
		else { x = b.x; y = b.y; }
		sb.append('\n').append(x).append(' ').append(y);
	}
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int x3 = Integer.parseInt(st.nextToken());
		int y3 = Integer.parseInt(st.nextToken());
		int x4 = Integer.parseInt(st.nextToken());
		int y4 = Integer.parseInt(st.nextToken());
		
		P a = new P(x1, y1);
		P b = new P(x2, y2);
		P c = new P(x3, y3);
		P d = new P(x4, y4);
		
		findIntersection(a, b, c, d);
		System.out.println(sb);
		br.close();
	}

}
