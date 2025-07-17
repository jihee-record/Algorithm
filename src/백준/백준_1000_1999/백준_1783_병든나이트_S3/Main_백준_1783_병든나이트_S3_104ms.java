package 백준.백준_1000_1999.백준_1783_병든나이트_S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1783_병든나이트_S3_104ms {
	 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		if(N == 1 || M == 1) {
			System.out.println(1);
			return;
		}
		
		if(N == 2) {
			System.out.println(Math.min(4, (M+1)/2));
			return;
		}
		
		if(M < 7) {
			System.out.println(Math.min(4, M));
			return;
		}
		
		System.out.println(M-2);
		br.close();
	}

}
