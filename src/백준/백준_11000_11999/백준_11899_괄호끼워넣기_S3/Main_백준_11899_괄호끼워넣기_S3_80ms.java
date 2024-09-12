package 백준.백준_11000_11999.백준_11899_괄호끼워넣기_S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_백준_11899_괄호끼워넣기_S3_80ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split("");
		Stack<String> stack= new Stack<>();
		for(int i=0; i<input.length; i++) {
			if(input[i].equals("(")) {
				stack.push("(");
			}else if(!stack.empty() && stack.peek().equals("(")){
				stack.pop();
			}else {
				stack.push(")");
			}
		}
		
		System.out.println(stack.size());
		br.close();
	}
}
