package 백준.백준_2000_2999.백준_2563_색종이_S5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2563_색종이_S5_이지희_64ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int result = 0; // 색종이가 붙은 영역의 넓이
		
		int[][] canvas = new int[100][100]; 
		
		int N = Integer.parseInt(br.readLine());
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); 
			int b = Integer.parseInt(st.nextToken());
			for(int i=0; i<10; i++) {
				for(int j=0; j<10; j++) {
					if(canvas[a+i][b+j] != 1) { // 아직 안붙은 곳만 체크(중복 있으므로)
						canvas[a+i][b+j] = 1; // 붙임 기록
						result++; // 넓이 증가
					}
				}
			}
		}
		
		System.out.println(result);
		br.close();
	}
}
