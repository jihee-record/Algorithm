
package 백준.백준_1000_1999.백준_1330_두수비교하기_B5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_1330_두수비교하기_B5_80ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		int a = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);
		
		if(a>b) System.out.println(">");
		else if(a<b) System.out.println("<");
		else System.out.println("==");
		br.close();
	}
}