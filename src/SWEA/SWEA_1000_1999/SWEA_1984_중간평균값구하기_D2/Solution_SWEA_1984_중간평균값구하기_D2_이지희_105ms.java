package SWEA.SWEA_1000_1999.SWEA_1984_중간평균값구하기_D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_1984_중간평균값구하기_D2_이지희_105ms {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		int[] numbers = new int[10];
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<10; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(numbers);
			int sumIf = 0;
			for(int i=1; i<9; i++) {
				sumIf += numbers[i];
			}
			System.out.println("#"+t+" "+Math.round((double)sumIf/8));
		}
		
		
		br.close();
	}

}
