package 백준.백준_1000_1999.백준_1874_스택수열_S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main_백준_1874_스택수열_S2_296ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		Deque<Integer> dq = new ArrayDeque<>();
		int num = 1;
		boolean possible = true;
		for(int n=0; n<N; n++) {
			int x = Integer.parseInt(br.readLine());
			
			while(num <= x) {
				dq.add(num++);
				sb.append("+\n");
			}
			
			if(dq.peekLast() == x) {
				dq.pollLast();
				sb.append("-\n");
			}else {
				possible = false;
				break;
			}
		}
		
		if(possible) {
			System.out.println(sb.toString());
			return;
		}
		
		System.out.println("NO");
		br.close();
	}

}
