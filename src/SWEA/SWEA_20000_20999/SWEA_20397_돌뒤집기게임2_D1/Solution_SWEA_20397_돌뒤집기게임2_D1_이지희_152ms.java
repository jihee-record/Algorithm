package SWEA.SWEA_20000_20999.SWEA_20397_돌뒤집기게임2_D1;

import java.util.Scanner;

public class Solution_SWEA_20397_돌뒤집기게임2_D1_이지희_152ms {
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		
		// 테케 개수
		int T = sc.nextInt();
		
		// 테케
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[] 돌 = new int[N+1];
			
			for(int n=1; n<=N; n++) {
				돌[n] = sc.nextInt();
			}
			
			// M : 뒤집기 횟수
			for(int m=1; m<=M; m++) { 
				int I = sc.nextInt();
				int J = sc.nextInt();
				
				for(int j=1; j<=J; j++) {
					if(I-j <= 0 || I+j > N) {
						break;
					}
					if(돌[I-j] == 돌[I+j]) {
						if(돌[I-j] == 0) {
							돌[I-j] = 1;
							돌[I+j] = 1;
						}else {
							돌[I-j] = 0;
							돌[I+j] = 0;
						}
					}
				}
			}
			
			System.out.print("#" + t + " ");
			for(int n=1; n<=N; n++) {
				System.out.print(돌[n] + " ");
			}
			System.out.println();
			
		}//for t 종료
		sc.close();
	}
}
