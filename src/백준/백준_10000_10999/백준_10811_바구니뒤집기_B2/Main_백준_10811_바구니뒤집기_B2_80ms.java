package 백준.백준_10000_10999.백준_10811_바구니뒤집기_B2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_10811_바구니뒤집기_B2_80ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		
		int[] nums = new int[N+1]; //  왜 n+1인지 모르겠음 //0제외 1번부터 N번바구니
		for(int i=1; i<=N; i++){
			nums[i] = i; //일부러 이렇게 한거
		} // 바구니 순서 수열 제작
		
		for(int m=0; m<M; m++) {
			String[] str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			int[] temp = Arrays.copyOf(nums, N+1);
			for(int i=0; i<=b-a; i++) {
				nums[i+a] = temp[b-i]; 
			}
		}
		
		for(int i=1; i<=N; i++) { // 바구니 최종출력
			System.out.print(nums[i]+" ");
		}
		
		br.close();
	}
}