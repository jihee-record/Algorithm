package 백준.백준_10000_10999.백준_10844_쉬운계단수_S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_10844_쉬운계단수_S1_104ms2 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long[] prev = new long[10]; // 자릿수, 마지막 숫자
		long[] next = new long[10]; // 자릿수, 마지막 숫자
		Arrays.fill(prev, 1);
		prev[0] = 0; 
		
		for(int n=2; n<=N; n++) {
			next[0] = prev[1];
			next[9] = prev[8];
			for(int i=1; i<=8; i++) {
				next[i] = (prev[i-1] + prev[i+1]) % 1000000000;
			}
			
			// swap
			long[] temp = prev;
			prev = next; // 다음에 쓸 prev 배열 : 지금의 배열
			next = temp; 
		}
		
		long ans = 0;
		for(int i=0; i<=9; i++) {
			ans = (ans + prev[i]) % 1000000000;
		}
		
		System.out.println(ans);
		br.close();
	}

}
