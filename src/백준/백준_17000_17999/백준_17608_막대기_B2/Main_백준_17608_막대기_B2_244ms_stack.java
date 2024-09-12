package 백준.백준_17000_17999.백준_17608_막대기_B2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_백준_17608_막대기_B2_244ms_stack {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 막대기의 길이
		Stack<Integer> stack = new Stack<>();
			// 막대기의 개수
		int n = Integer.parseInt(br.readLine());
		// n개 막대기의 길이 (왼쪽부터 list.[0])
		for(int i=0; i<n; i++) {
			stack.push(Integer.parseInt(br.readLine()));
		}
		
		// 가장 오른쪽(list의 마지막) 막대기부터 지금까지 막대 길이의 최대값
		int max = 0;
		// 지금까지 보이는 막대 개수
		int count = 0;
		
		while(!stack.empty()) {
			int k = stack.pop();
			if(k > max) {
				count++;
				max = k;
			}
		}
		
		System.out.println(count);
		br.close();
	}
}
