package SWEA.SWEA_Test.Test3_1_이지희;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test3_1_이지희 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int price = Integer.parseInt(br.readLine());
			int count = 0;
			
			count += price/7;
			price %= 7;
			
			count += price/5;
			price %= 5;
			
			if(price >= 1) count++;
			sb.append("#").append(t).append(" ").append(count).append("\n");
			
		}// end of for t 
		
		System.out.println(sb.toString());
		br.close();
	}

}
