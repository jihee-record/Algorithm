package 백준.백준_1000_1999.백준_1790_수이어쓰기2_G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1790_수이어쓰기2_G5_100ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String N = st.nextToken();
		
		int n = Integer.parseInt(N);
		int k = Integer.parseInt(st.nextToken());
		
		int D = N.length(); 
		int interval = 9; // 구간 숫자 개수 1~9(9) -> 10~99(90)
		int numLength = 0; // 새로 만들어진 숫자 길이
		int check = 0; // 쓴 숫자 개수
		
		for(int d=1; d<=D; d++) {
			int newLength = numLength + (interval * d); 
			if(d == D) {
				newLength = numLength + ((n - check) * D);
			}
			if(k <= newLength) { // 지금 구간에 k번째 숫자가 있다면
				int x = k - numLength; 
				int q = x / d;
				int r = x % d;
				
				if(r == 0) {
					System.out.println((check + q) % 10);
					return;
				}else {
					String str = Integer.toString(check + q + 1);
					System.out.println(str.charAt(r-1));
					return;
				}
			}
			
			numLength = newLength;
			check += interval;
			interval *= 10;
		}
		
		System.out.println(-1);
		br.close();
	}

}
