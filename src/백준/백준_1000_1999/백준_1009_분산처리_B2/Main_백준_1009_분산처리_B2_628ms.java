package 백준.백준_1000_1999.백준_1009_분산처리_B2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1009_분산처리_B2_628ms {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			a %= 10;
			
			int result = 1; //unity
			for(int i=1; i<=b; i++) {
				result *= a;
				if(result > 10) {
					result %= 10;
				}
			}
			
			if(result == 0) {
				result = 10;
			}
			sb.append(result).append("\n");
			
		}//for T
		
		System.out.println(sb.toString());
		br.close();
	}

}