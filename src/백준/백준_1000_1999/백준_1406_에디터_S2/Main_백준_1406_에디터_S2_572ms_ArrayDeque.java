package 백준.백준_1000_1999.백준_1406_에디터_S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_백준_1406_에디터_S2_572ms_ArrayDeque {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		ArrayDeque<Character> left = new ArrayDeque<>();
		ArrayDeque<Character> right = new ArrayDeque<>();
		String str = br.readLine();
		for(char c : str.toCharArray()) {
			left.addLast(c);
		}
		
		int N = Integer.parseInt(br.readLine());
		while(N --> 0) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			switch(command) {
			case "L":
				if(!left.isEmpty()) right.addLast(left.pollLast());
				break;
			case "D":
				if(!right.isEmpty()) left.addLast(right.pollLast());
				break;
			case "B":
				if(!left.isEmpty()) left.pollLast();
				break;
			case "P":
				left.addLast(st.nextToken().charAt(0));
				break;
			}
		}
		
		while(!left.isEmpty()) {
			sb.append(left.pollFirst());
		}
		
		while(!right.isEmpty()) {
			sb.append(right.pollLast());
		}
		
		System.out.println(sb.toString());
		br.close();
	}

}
