package 백준.백준_2000_2999.백준_2056_작업_G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_2056_작업_G4_748ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] time = new int[N+1];
		int[] sum = new int[N+1];
		int[] level = new int[N+1];
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] follow = new ArrayList[N+1];

		Queue<Integer> queue = new ArrayDeque<>();
		
		for(int n=1; n<=N; n++) {
			st = new StringTokenizer(br.readLine());
			
			// 선행 작업이 나보다 낮은 숫자라서 즉시 초기화 해도 됨
			follow[n] = new ArrayList<>();
			time[n] = Integer.parseInt(st.nextToken());  
			level[n] = Integer.parseInt(st.nextToken());
			if(level[n] == 0) {
				queue.add(n);
				sum[n] = time[n]; 
			}
			
			while(st.hasMoreTokens()) { // 선행 작업들
				follow[Integer.parseInt(st.nextToken())].add(n);
			}
		}
		
		int result = 0;
		while(!queue.isEmpty()) {
			int n = queue.poll();
			int total = sum[n];
			result = Math.max(total, result);
			
			for(int next: follow[n]) {
				sum[next] = Math.max(total + time[next], sum[next]);
				if(--level[next] == 0) queue.add(next);
			}
		}
		
		System.out.println(result);
		br.close();
	}

}
