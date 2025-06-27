package 백준.백준_10000_10999.백준_10610_30_S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_10610_30_S4_168ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num = br.readLine();
		
		int[] count = new int[10]; // 0~9 개수
		long sum = 0;
		
		for(char c : num.toCharArray()) {
			int d = c - '0'; // 
			count[d]++;
			sum += d;
		}
		
		if(count[0] == 0 || sum % 3 != 0) {
			System.out.println(-1);
			return;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int d=9; d>=0; d--) {
			while(count[d]-- > 0) {
				sb.append(d);
			}
		}
		
		System.out.println(sb.toString());
		br.close();
	}

}
