package 백준.백준_2000_2999.백준_2747_피보나치수_B2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_2747_피보나치수_B2_108ms {
	static int[] fibo;
	static int fibonacci(int n) {
		if(n <= 1) return n;
		if(fibo[n] > 0) return fibo[n];
		return fibo[n] = fibonacci(n-1) + fibonacci(n-2);
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		fibo = new int[N+1];
		System.out.println(fibonacci(N));
		br.close();
	}

}
