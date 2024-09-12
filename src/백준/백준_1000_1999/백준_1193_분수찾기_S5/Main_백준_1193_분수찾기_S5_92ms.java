package 백준.백준_1000_1999.백준_1193_분수찾기_S5;

import java.util.Scanner;

public class Main_백준_1193_분수찾기_S5_92ms {
	
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int X = sc.nextInt();
			int sum = 0;
			int idx; //열
			for(idx=1; idx<=5000; idx++) {
				sum += idx;
				if(sum >= X) {
					break;
				}
			}
			
			int top = idx - (sum-X); // 분자 idx 홀수 ) 분모
			int bottom = idx + 1 - top; // 분모 idx 홀수 ) 분자
			
			if(idx%2 == 0) System.out.println(top + "/" + bottom);
			else System.out.println(bottom + "/" + top);
			
			sc.close();
		}
	}

}
