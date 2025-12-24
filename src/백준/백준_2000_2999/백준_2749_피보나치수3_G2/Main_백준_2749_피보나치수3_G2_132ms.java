package 백준.백준_2000_2999.백준_2749_피보나치수3_G2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_2749_피보나치수3_G2_132ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int mod = 1_000_000;
		long N = Long.parseLong(br.readLine());
		int a = 0, b = 1;
		
		int cycle = 0;
		while(true) {
			int c = (a + b) % mod;
			a = b;
			b = c; // next
			cycle++;
			
			if(a == 0 && b == 1) break;
		}
		
		int K = (int)(N % cycle); // f(n) % mod 
		
		a = 0; b = 1; // 0, 1
		for(int i=2; i<=K; i++) {
			int c = (a + b) % mod;
			a = b;
			b = c; 
		}
		
		System.out.println(b);
		br.close();
	}

}
