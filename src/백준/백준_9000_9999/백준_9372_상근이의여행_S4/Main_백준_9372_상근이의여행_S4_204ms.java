package 백준.백준_9000_9999.백준_9372_상근이의여행_S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_9372_상근이의여행_S4_204ms {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine()); // 테케
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 국가 수
			int M = Integer.parseInt(st.nextToken()); // 비행기 종류
			
			for(int m=0; m<M; m++) {
				br.readLine();
			}
			
			sb.append(N-1).append("\n");
		}
		
		System.out.println(sb.toString());
		br.close();
	}
}
