package 백준.백준_1000_1999.백준_1931_회의실배정_G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_백준_1931_회의실배정_G5_440ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
			if(a[1] == b[1]) return a[0] - b[0];
			return a[1] - b[1];
		});
		
		while(N --> 0) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int finish = Integer.parseInt(st.nextToken());
			pq.add(new int[] {start, finish});
		}
		
		int cnt = 0;
		int finish = 0;
		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			if(now[0] < finish) continue;
			finish = now[1];
			cnt++;
		}
		System.out.println(cnt);
		br.close();
	}

}
