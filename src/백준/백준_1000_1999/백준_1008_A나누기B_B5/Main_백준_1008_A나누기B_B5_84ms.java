package 백준.백준_1000_1999.백준_1008_A나누기B_B5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_1008_A나누기B_B5_84ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		Double a = Double.parseDouble(input[0]);
		Double b = Double.parseDouble(input[1]);
		
		System.out.println(a/b);
		
		br.close();
	}

}