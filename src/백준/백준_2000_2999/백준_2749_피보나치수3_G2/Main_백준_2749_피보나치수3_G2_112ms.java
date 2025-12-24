package 백준.백준_2000_2999.백준_2749_피보나치수3_G2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 피사노 주기
// 피보나치 수를 M으로 나눈 나머지는 반복되는 주기가 있다.
// M = 10^k (k>2) => 주기 = 15 * 10^(k-1)
public class Main_백준_2749_피보나치수3_G2_112ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int mod = 1_000_000; // 10^6
		long N = Long.parseLong(br.readLine());
		
		int cycle = 1_500_000; //15 * 10^5
		
		int K = (int)(N % cycle); // f(n) % mod 
		
		int a = 0, b = 1; // 0, 1
		for(int i=0; i<K; i++) {
			int c = (a + b) % mod;
			a = b;
			b = c; 
		}
		
		System.out.println(a);
		br.close();
	}

}
