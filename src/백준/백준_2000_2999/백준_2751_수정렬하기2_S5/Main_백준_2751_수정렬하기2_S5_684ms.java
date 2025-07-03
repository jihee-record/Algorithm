package 백준.백준_2000_2999.백준_2751_수정렬하기2_S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_2751_수정렬하기2_S5_684ms {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// -1000000 > number[0]에 저장
		boolean[] number = new boolean[2000001]; // 양음0
		
		int N = Integer.parseInt(br.readLine());
		
		int min = 2000000, max = 0;
		for(int n=0; n<N; n++) {
			int input = Integer.parseInt(br.readLine()) + 1000000;
			number[input] = true;
			if(input < min) min = input;
			if(input > max) max = input;
		}
		
		int count = 0;
		for(int i=min; i<=max && count<N; i++) {
			if(number[i]) {
				sb.append(i-1000000).append("\n");
				count++;
			}
		}
		
		System.out.println(sb.toString());
		br.close();
	}

}
