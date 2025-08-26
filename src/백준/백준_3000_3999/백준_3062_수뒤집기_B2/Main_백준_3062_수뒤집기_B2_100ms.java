package 백준.백준_3000_3999.백준_3062_수뒤집기_B2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_3062_수뒤집기_B2_100ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		while(N --> 0) {
			String str = br.readLine();
			StringBuilder opposite = new StringBuilder();
			for(int n=str.length()-1; n>=0; n--) {
				opposite.append(str.charAt(n));
			}
			
			String sum = Integer.toString(Integer.parseInt(str) + Integer.parseInt(opposite.toString()));
			int sumL = sum.length();
			boolean flag = true;
			for(int n=0; n<sumL/2; n++) {
				if(sum.charAt(n) != sum.charAt(sumL-n-1)) {
					flag = false;
					break;
				}
			}
			if(flag) sb.append("YES\n");
			else sb.append("NO\n");
		}
		
		System.out.println(sb);
		br.close();
	}

}
