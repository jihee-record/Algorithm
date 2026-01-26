package 백준.백준_1000_1999.백준_1253_좋다_G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_1253_좋다_G4_152ms_twopointer {
	static int N;
	
	static boolean findTwoSum(int[] seq, int idx) {
		int left = 0, right = N - 1;
		
		while(left < right) {
			if(left == idx) { left ++; continue; }
			if(right == idx) { right --; continue; }
			
			int sum = seq[left] + seq[right];
			if(seq[left] + seq[right] == seq[idx]) return true;
			
			if(sum < seq[idx]) left ++;
			else right --;
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		int[] seq = new int[N]; 
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n=0; n<N; n++) {
			seq[n] = Integer.parseInt(st.nextToken());
		}
		
		if(N <= 2) {
			System.out.println(0);
			return;
		}
		
		Arrays.sort(seq);
		
//		for(int n=0; n<N; n++) {
//			System.out.print(seq[n]+ " ");
//		}
//		System.out.println();
		
		int cnt = 0;
		for(int n=0; n<N; n++) {
			if(findTwoSum(seq, n)) cnt++;
		}
		
		System.out.println(cnt);
		br.close();
	}

}
