package 백준.백준_1000_1999.백준_1748_수이어쓰기1_S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_1748_수이어쓰기1_S4_104ms {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		
		int count = Integer.parseInt(N);
		int result = 0;
		
		int digit = 9, i=1;
		for(i=1; i<N.length(); i++, digit *= 10) {
			result += (i * digit);
			count -= digit;
		}
		
		result = result + i*count;
		
		System.out.println(result);
		br.close();
	}

}
