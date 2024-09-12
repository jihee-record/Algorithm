package 백준.백준_10000_10999.백준_10828_스택_S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main_백준_10828_스택_S4_392ms {
	
	static List<Integer> stack;
	
	static void push(int x) {
		stack.add(x);
	}
	
	static int pop() {
		if(stack.isEmpty()) {
			return -1;
		}
		int n = stack.get(stack.size()-1);
		stack.remove(stack.size()-1);
		return n;
	}
	
	static int size() {
		return stack.size();
	}
	
	static int empty() {
		if(stack.isEmpty()) {
			return 1;
		}
		return 0;
	}
	
	static int top() {
		if(stack.isEmpty()) {
			return -1;
		}
		return stack.get(stack.size()-1);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		stack = new LinkedList<>();
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			String[] ask = br.readLine().split(" ");
			switch(ask[0]) {
				case "push":
					push(Integer.parseInt(ask[1]));
					break;
				case "pop":
					System.out.println(pop());;
					break;
				case "size":
					System.out.println(size());
					break;
				case "empty":
					System.out.println(empty());
					break;
				case "top":
					System.out.println(top());
					break;
			}
		}
		br.close();
	}
}
