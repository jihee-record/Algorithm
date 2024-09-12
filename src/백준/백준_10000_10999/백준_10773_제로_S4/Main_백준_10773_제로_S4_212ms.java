package 백준.백준_10000_10999.백준_10773_제로_S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_백준_10773_제로_S4_212ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		int result = 0;

		for(int i=0; i<n; i++) {
			int k = Integer.parseInt(br.readLine());
			if(k ==  0) {
				stack.pop();
			}else {
				stack.push(k);
			}
		}
		
		while(!stack.empty()) {
			result += stack.pop();
		}
		
		System.out.println(result);
		br.close();
	}
}
