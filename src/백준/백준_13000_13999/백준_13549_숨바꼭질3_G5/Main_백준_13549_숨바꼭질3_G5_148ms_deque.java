package 백준.백준_13000_13999.백준_13549_숨바꼭질3_G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_백준_13549_숨바꼭질3_G5_148ms_deque {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] time = new int[100001];
		Arrays.fill(time, Integer.MAX_VALUE);
		
		Deque<Integer> dq = new ArrayDeque<>();
		int n = N;
		time[n] = 0;
		dq.addLast(n);
		
		while(!dq.isEmpty()) {
			n = dq.pollLast();
			if(n == K) continue;
			
			int plus = n + 1;
			if(plus >= 0 && plus <= 100000) {
				if(time[plus] > time[n] + 1) {
					time[plus] = time[n] + 1;
					dq.addLast(plus);
				}
			}
			
			int minus = n - 1;
			if(minus >= 0 && minus <= 100000) {
				if(time[minus] > time[n] + 1) {
					time[minus] = time[n] + 1;
					dq.addLast(minus);
				}
			}
			
			int multiple = n * 2;
			if(multiple >= 0 && multiple <= 100000) {
				if(time[multiple] > time[n]) {
					time[multiple] = time[n];
					dq.addFirst(multiple);
				}
			}
		}
		
		System.out.println(time[K]);
		br.close();
	}

}
