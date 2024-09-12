package SWEA.SWEA_1000_1999.SWEA_1218_괄호짝짓기_D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// if
public class Solution_SWEA_1218_괄호짝짓기_D4_이지희_115ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int t=1; t<=10; t++) {
			int N = Integer.parseInt(br.readLine());
			sb.append("#").append(t).append(" ");
			String[] brackets = br.readLine().split("");
			if(N%2 != 0) {
				sb.append(0).append("\n");
				continue;
			}
			Stack<String> stack = new Stack<>();
			int valid = 1; // 유효
			
			for(int i=0; i<N; i++) {
				String close = brackets[i];
				if("({[<".contains(close)) {
					stack.push(close);
				}else if(!isPair(stack.pop(), close)) {
					valid = 0;
					break;
				}
			}
			
			if(!stack.empty()) valid = 0;
			sb.append(valid).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
	
	static boolean isPair(String open, String close) {
		switch(open) {
		case "(": return close.equals(")");
		case "{": return close.equals("}");
		case "[": return close.equals("]");
		case "<": return close.equals(">");
		default : return false;
		}
	}
}
