package 백준.백준_2000_2999.백준_2166_다각형의면적_G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2166_다각형의면적_G5_180ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] pos = new int[N][2];
		
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			pos[n][0] = Integer.parseInt(st.nextToken());
			pos[n][1] = Integer.parseInt(st.nextToken());
		}
		
		long sum = 0;
		/// 삼각형들의 합
		for(int n=2; n<N; n++) {
			int x1 = pos[n-1][0] - pos[0][0];
			int y1 = pos[n-1][1] - pos[0][1];
			int x2 = pos[n][0] - pos[0][0];
			int y2 = pos[n][1] - pos[0][1];
			
			sum += 1L * x1 * y2 - 1L * y1 * x2;
		}
		
		System.out.printf("%.1f\n", Math.abs(sum / 2.0));
		br.close();
	}

}
