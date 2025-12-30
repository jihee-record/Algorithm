package 백준.백준_10000_10999.백준_10870_피보나치수5_B2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_10870_피보나치수5_B2_100ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int a = 0;
		int b = 1;
		
		for(int i=0; i<N; i++) {
			int c = a + b;
			a = b;
			b = c;
		}
		
		System.out.println(a);
		br.close();
	}

}
