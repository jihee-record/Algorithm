package 코드트리.학습체크.학습체크1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_학습체크1 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 격자 크기
		int[][] map = new int[N][N];
		
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		int R = Integer.parseInt(br.readLine()); // 
		int C = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		int sum = 0;
		
		for(int r=R-1; r<N; r++) {
			for(int c=C-1; c<N; c++) {
				if(map[r][c] % K != 0) sum += map[r][c];
			}
		}
		
		
		System.out.println(sum);
		br.close();
		
	}

}
