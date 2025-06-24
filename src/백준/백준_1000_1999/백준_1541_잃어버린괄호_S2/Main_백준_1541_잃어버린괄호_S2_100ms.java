package 백준.백준_1000_1999.백준_1541_잃어버린괄호_S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_1541_잃어버린괄호_S2_100ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] minusSplit = br.readLine().split("-"); // [0] : - 등장 이전
		
		int total = 0;
		
		String[] addSplit = minusSplit[0].split("\\+");
		for(String number : addSplit) {
			total += Integer.parseInt(number);
		}
		
		for(int i=1; i<minusSplit.length; i++) {
			for(String number : minusSplit[i].split("\\+")) {
				total -= Integer.parseInt(number);
			}
		}
		
		System.out.println(total);
		br.close();
	}

}
