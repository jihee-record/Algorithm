package 백준.백준_2000_2999.백준_2252_줄세우기_G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_2252_줄세우기_G3_428ms {
	static class Student {
		ArrayList<Integer> follow; // 큰 애들

		Student() {
			this.follow = new ArrayList<>();
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 학생 수 
		int M = Integer.parseInt(st.nextToken()); // 비교 횟수
		
		Student[] students = new Student[N+1];
		for(int n=1; n<=N; n++) {
			students[n] = new Student();
		}
		
		int[] follow = new int[N+1];
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			// A < B 키순
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			students[A].follow.add(B);
			follow[B]++;
		}
		
		Queue<Integer> queue = new LinkedList<>();

		for(int n=1; n<=N; n++) {
			if(follow[n] == 0) {
				queue.add(n);
			}
		}
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			sb.append(now).append(" ");
			for(int next: students[now].follow) {
				if(--follow[next] == 0) queue.add(next);
			}
		}
		
		System.out.println(sb.toString());
		br.close();
	}

}

/*
 * 8 6
2 4
5 4
6 3
4 3
3 7
5 3
*/
