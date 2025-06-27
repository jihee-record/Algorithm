package 백준.백준_10000_10999.백준_10610_30_S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_10610_30_S4_352ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] digit = br.readLine().split("");
		
		long sum = 0;
		boolean zero = false;
		for(int i=0; i<digit.length; i++) {
			if(digit[i].equals("0")) zero = true;
			else sum += Integer.parseInt(digit[i]);
		}
		
		if(zero && sum % 3 == 0) {
			Arrays.sort(digit);
			for(int i=digit.length-1; i>=0; i--) {
				sb.append(digit[i]);
			}
		} else {
			sb.append("-1");
		}
		
		System.out.println(sb.toString());
		br.close();
	}

}
