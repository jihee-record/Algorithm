package 백준.백준_2000_2999.백준_2738_행렬덧셈_B3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2738_행렬덧셈_B3_이지희_96ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] matrix = new int[N][M];
		
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m=0; m<M; m++) {
				matrix[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m=0; m<M; m++) {
				sb.append(matrix[n][m] + Integer.parseInt(st.nextToken())).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		br.close();
	}
}
