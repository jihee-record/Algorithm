package 백준.백준_17000_17999.백준_17626_FourSquares_S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 수학
public class Main_백준_17626_FourSquares_S3_100ms_math {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int squareN = (int) Math.sqrt(N);
		if(squareN * squareN == N) {
			System.out.println(1);
			return;
		}
		
		for(int i = 0; i*i <= N/2; i++) {
			int s1 = i*i; // 제곱수
			int s2 = N - s1; //  제곱수?
			
			int square2 = (int) Math.sqrt(s2);
			if(square2 * square2 == s2) {
				System.out.println(2);
				return;
			}
		}
		
		// N = 4^a*8b + 7 => 세 제곱수 불가능
		int temp = N;
		while(temp % 4 == 0) temp /= 4; // 4^a 빼기
		if(temp % 8 == 7) {
			System.out.println(4);
			return;
		}
		
		System.out.println(3);
		br.close();
	}

}
