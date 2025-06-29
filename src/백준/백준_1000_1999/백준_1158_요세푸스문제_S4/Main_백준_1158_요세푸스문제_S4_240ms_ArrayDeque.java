package 백준.백준_1000_1999.백준_1158_요세푸스문제_S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_1158_요세푸스문제_S4_240ms_ArrayDeque {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		sb.append("<");
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new ArrayDeque<>();
		for(int n=1; n<=N; n++) {
			q.add(n);
		}
		
		while(true) {
			for(int k=1; k<K; k++) {
				q.add(q.poll());
			}
			
			sb.append(q.poll());
			
			if(q.isEmpty()) break;
			sb.append(", ");
		}
		
		sb.append(">");
		System.out.println(sb.toString());
		br.close();
	}

}
