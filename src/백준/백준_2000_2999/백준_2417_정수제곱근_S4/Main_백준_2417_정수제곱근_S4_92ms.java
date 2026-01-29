package 백준.백준_2000_2999.백준_2417_정수제곱근_S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_2417_정수제곱근_S4_92ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Long.parseLong(br.readLine());
		long sqr = (long)Math.sqrt(n); 
		
		System.out.println(Math.pow(sqr, 2) < n ? sqr + 1 : sqr);
		br.close();
		
	}

}
