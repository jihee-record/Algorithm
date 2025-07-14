package 백준.백준_1000_1999.백준_1654_랜선자르기_S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1654_랜선자르기_S2_156ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		long[] lines = new long[K];
		long max = 0;

		for(int k=0; k<K; k++) {
			lines[k] = Integer.parseInt(br.readLine());
			max = Math.max(max, lines[k]);
		}

		long left = 1;
		long right = max; 

		long answer = 0;
		while(left <= right) {
			long mid = (left + right) / 2;
			
			int cnt = 0;
			for(long line : lines) {
				cnt += line / mid;
			}
			
			if(cnt >= N) {
				answer = mid;
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		
		System.out.println(answer);
		br.close();
	}

}
