package SWEA.SWEA_1000_1999.SWEA_1224_계산기3_D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution_SWEA_1224_계산기3_D4_이지희_131ms {
   public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int t=1; t<=10; t++) {
			int N = Integer.parseInt(br.readLine());
			String[] tokens = br.readLine().split(""); 
	        List<String> postfix = new ArrayList<>();
	        Stack<String> stack = new Stack<>();

	        for(int i=0; i<N; i++) {
	            String token = tokens[i];
	            
	            switch(token) {
	            case "(":
	            	stack.push(token);
	            	break;
	            case ")":
	            	while (!stack.peek().equals("(")) {
	                	postfix.add(stack.pop());
	                }
            		stack.pop();
	            	break;
	            case "+":
	            case "-":
	            case "*":
	            case "/":
	            	// 우선 순위가 같거나 내가 더 높으면 스택에서 제거 > 후위표기에 나열
	            	while(precedence(token) <= precedence(stack.peek())) {
	            		postfix.add(stack.pop());
	            	}
	            	// 우선 순위가 낮아지면 스택에 추가
	            	stack.push(token);
	            	break;
	            default : //숫자
	            	postfix.add(token);
	            	break;
	            }
	        }

	        // 스택에 남아있는 연산자 모두 후위 표기법에 추가
	        while (!stack.isEmpty()) {
	        	postfix.add(stack.pop());
	        }
	        // 후위 표기법 계산
	        int result = calculate(postfix);
	
	        sb.append("#").append(t).append(" ").append(result).append("\n"); 
		}
        
		System.out.println(sb.toString());
        br.close();
    }

    public static int calculate(List<String> postfix) {
        Stack<Integer> stack = new Stack<>();
        for (String token : postfix) {
        	// 숫자
            try {
            	stack.push(Integer.parseInt(token));
            // 숫자가 아닐 때 : 연산자일때
            }catch(NumberFormatException e) {
                int b = stack.pop();
                int a = stack.pop();
                int result = 0;
                switch (token) {
                    case "+": 
                    	result = a+b; 
                    	break;
                    case "-": 
                    	result = a-b; 
                    	break;
                    case "*": 
                    	result = a*b; 
                    	break;
                    case "/": 
                    	result = a/b; 
                    	break;
                }
                stack.push(result);
            }
        }
        return stack.pop();
    }

    public static int precedence(String operator) {
        switch (operator) {
        case "+": 
        case "-": 
        	return 1;
        case "*": 
        case "/": 
        	return 2;
        default: 
        	return 0;
        }
    }
}
