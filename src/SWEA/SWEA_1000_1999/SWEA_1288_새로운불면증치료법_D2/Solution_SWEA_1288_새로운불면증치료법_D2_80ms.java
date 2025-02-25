package SWEA.SWEA_1000_1999.SWEA_1288_새로운불면증치료법_D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution_SWEA_1288_새로운불면증치료법_D2_80ms {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringBuilder sb = new StringBuilder();
		 
		 int T = Integer.parseInt(br.readLine());
		 
		 for(int t=1; t<=T; t++) {
			 int N = Integer.parseInt(br.readLine());
			 
			 Set<Character> set = new HashSet<>();
			 
			 int i=0;
			 while(set.size() < 10) {
				 i++;
				 String strN = Integer.toString(N*i);
				 for(int k=0; k<strN.length(); k++) {
					 set.add(strN.charAt(k));
				 }
			 }
			 
			 sb.append("#").append(t).append(" ").append(N*i).append("\n");
		 }
		 
		 System.out.println(sb.toString());
		 br.close();
	}

}
