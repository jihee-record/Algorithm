package 백준.백준_1000_1999.백준_1562_계단수_G1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_1562_계단수_G1_184ms2 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long[][] prev = new long[10][1<<10];
		long[][] next = new long[10][1<<10];
		for(int i=1; i<=9; i++) prev[i][1<<i] = 1;
		
		for(int n=2; n<=N; n++) {
			for(int i=0; i<=9; i++) Arrays.fill(next[i], 0);
			
			for(int mask=0; mask<(1<<10); mask++) {
				next[0][mask | (1<<0)] = (next[0][mask | (1<<0)] + prev[1][mask]) % 1000000000;
				next[9][mask | (1<<9)] = (next[9][mask | (1<<9)] + prev[8][mask]) % 1000000000;
				
				for(int i=1; i<9; i++) {
					int nmask = mask | (1<<i);
					next[i][nmask] = (next[i][nmask] + prev[i-1][mask]) % 1000000000;
					next[i][nmask] = (next[i][nmask] + prev[i+1][mask]) % 1000000000;
				
				}
			}
			
			long[][] temp = prev;
			prev = next;
			next = temp;
		}
		
		long ans = 0;
		for(int i=0; i<10; i++) {
			ans = (ans + prev[i][(1<<10)-1]) % 1000000000;
		}
		
		System.out.println(ans);
		br.close();
	}

}
