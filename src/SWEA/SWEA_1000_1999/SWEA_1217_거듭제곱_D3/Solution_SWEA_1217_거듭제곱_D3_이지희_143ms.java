package SWEA.SWEA_1000_1999.SWEA_1217_거듭제곱_D3;

import java.util.Scanner;

public class Solution_SWEA_1217_거듭제곱_D3_이지희_143ms {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t=1; t<=10; t++) {
			sc.nextInt();
			
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			int result = 1;
			
			for(int i=0; i<m; i++) {
				result *= n;
			}
			
			System.out.println("#" + t + " " + result);
		}
		
		sc.close();
	}
}
