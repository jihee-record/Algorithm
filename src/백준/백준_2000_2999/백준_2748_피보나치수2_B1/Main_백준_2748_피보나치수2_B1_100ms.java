package 백준.백준_2000_2999.백준_2748_피보나치수2_B1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_2748_피보나치수2_B1_100ms {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long[] fn = new long[N+1];
		fn[1] = 1;
		
		for(int n=2; n<=N; n++) {
			fn[n] = fn[n-1] + fn[n-2];
		}
		
		System.out.println(fn[N]);
		br.close();
	}

}
