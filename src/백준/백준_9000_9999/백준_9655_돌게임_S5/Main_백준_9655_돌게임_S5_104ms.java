package 백준.백준_9000_9999.백준_9655_돌게임_S5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_9655_돌게임_S5_104ms {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		if(Integer.parseInt(br.readLine()) % 2 == 1) System.out.println("SK");
		else System.out.println("CY");

		br.close();
	}

}
