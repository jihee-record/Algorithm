package 백준.백준_1000_1999.백준_1541_잃어버린괄호_S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_1541_잃어버린괄호_S2_104ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int startIdx = 0;
		int total = 0;
		boolean subtraction  = false;
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			
			if(c == '+' || c == '-') {
				int number = Integer.parseInt(str.substring(startIdx, i));
				total += subtraction ? -number : + number;
				startIdx = i+1;
				
				if(c == '-') subtraction = true;
			}
		}
		
		int number = Integer.parseInt(str.substring(startIdx));
		total += subtraction ? -number : + number;
		
		System.out.println(total);
		br.close();
	}

}
