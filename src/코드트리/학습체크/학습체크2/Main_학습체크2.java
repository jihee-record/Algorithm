package 코드트리.학습체크.학습체크2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_학습체크2 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); // 쉼터 개수
		int A = Integer.parseInt(st.nextToken()); // dx
		int B = Integer.parseInt(st.nextToken()); // dy
		int C = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		int[][] p = new int[N][2]; // N개 쉼터, 좌표
		
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			p[n][0] = Integer.parseInt(st.nextToken());
			p[n][1] = Integer.parseInt(st.nextToken());
		}
		
		int min = Integer.MAX_VALUE;
		for(int i=C; i<=D; i++) {
			int x = A*i, y = B*i;
			
			for(int n=0; n<N; n++) {
				int distance = Math.abs(x-p[n][0]) + Math.abs(y- p[n][1]);
				min = Math.min(min, distance);
			}
		}
		
		System.out.println(min);
		br.close();
	}

}
