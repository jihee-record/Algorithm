package 백준.백준_10000_10999.백준_10872_팩토리얼_B3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_10872_팩토리얼_B3_76ms {
	
	static public int factorial(int k) {
		if(k == 0) {
			return 1;
		}else {
			return k*factorial(k-1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// n : 12이하 정수
		int n = Integer.parseInt(br.readLine());
		System.out.println(factorial(n));
		br.close();
	}
}