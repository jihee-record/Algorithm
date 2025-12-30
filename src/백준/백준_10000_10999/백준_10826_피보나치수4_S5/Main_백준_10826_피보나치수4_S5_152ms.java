package 백준.백준_10000_10999.백준_10826_피보나치수4_S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main_백준_10826_피보나치수4_S5_152ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		BigInteger a = BigInteger.ZERO; //BigInteger.valueOf(0);
		BigInteger b = BigInteger.ONE; //BigInteger.valueOf(1);
		
		for(int i=0; i<N; i++) {
			BigInteger c = a.add(b);
			a = b;
			b = c;
		}
		
		System.out.println(a);
		br.close();
	}

}
