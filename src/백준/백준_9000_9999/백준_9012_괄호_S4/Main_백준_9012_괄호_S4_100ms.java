package 백준.백준_9000_9999.백준_9012_괄호_S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_백준_9012_괄호_S4_100ms {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++) {
        	String[] arr = br.readLine().split("");
        	if(arr.length%2 != 0) {
        		stack.push("end");
        	}else {
        		for(int j=0; j<arr.length; j++) {
        			if(arr[j].equals("(")) {
        				stack.push("(");
        			}else {
        				if(stack.empty()) {
        					stack.push("end");
        					break;
        				}else {
        					stack.pop();
        				}
        			}
        		}
        	}
        	if(!stack.empty()) {
        		sb.append("NO\n");
        	}else {
        		sb.append("YES\n");
        	}
        	stack.clear();
        }
        
        System.out.println(sb);
        br.close();
    }
}
