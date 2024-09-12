package 백준.백준_5000_5999.백준_5430_AC_G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main_백준_5430_AC_G5_1092ms {
	static StringBuilder AC(Deque<String> deq, String[] p) {
		boolean direction = true;
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<p.length; i++) {
			if(p[i].equals("R")) {
				direction = !direction;
			}else {
				if(deq.isEmpty()) {
					return sb.append("error");
					
				}else {
					if(direction) {
						deq.removeFirst();
					}else {
						deq.removeLast();
					}
				}
			}
		}
		
		sb.append("[");
		while(!deq.isEmpty()) {
			sb.append(direction ? deq.removeFirst() : deq.removeLast());
			if(!deq.isEmpty()) sb.append(",");
		}
		sb.append("]");
		
		return sb;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			String[] p = br.readLine().split("");
			Deque<String> deq = new LinkedList<>();
			String input = br.readLine().replace("[", "").replace("]", "");
			for(String str : input.split(",")) {
				if(!str.equals("")) {
					deq.add(str);
				}
			}
			
			System.out.println((AC(deq, p)));
		}
		
		br.close();
	}
}
