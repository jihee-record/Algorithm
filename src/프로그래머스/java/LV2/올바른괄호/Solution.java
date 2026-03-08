package 프로그래머스.java.LV2.올바른괄호;

import java.util.Stack;

public class Solution {
	static boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++) {
        	char c = s.charAt(i); 
        	if(c == ')') {
        		if(!stack.empty() && stack.peek()=='(') {
        			stack.pop();
        		}else {
        			return false;
        		}
        	}else {
        		stack.push('(');
        	}
        }

        if(!stack.empty()) {
        	return false;
        }

        return answer;
    }
	
	public static void main(String[] args) {
		String s = "(()))";
		System.out.println(solution(s));
	}
}