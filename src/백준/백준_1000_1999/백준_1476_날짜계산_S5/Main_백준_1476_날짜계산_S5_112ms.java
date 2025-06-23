package 백준.백준_1000_1999.백준_1476_날짜계산_S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 차근 차근 구하기
public class Main_백준_1476_날짜계산_S5_112ms {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken()) % 28;
		int M = Integer.parseInt(st.nextToken()) % 19;

		int year = E;
		int ESCommon = 420;
		
		outloop:
		while(true) {
			if((year % 28) == S) {
				while(true) {
					if((year % 19) == M) break outloop;
					year += ESCommon;
				}
			}
			year += 15;
		}
		
		System.out.println(year);
		br.close();
		
	}

}
