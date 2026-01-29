package 백준.백준_17000_17999.백준_17951_흩날리는시험지_G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_17951_흩날리는시험지_G3_232ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] score = new int[N];
		st = new StringTokenizer(br.readLine());
		
		int sum = 0;
		for(int n=0; n<N; n++) {
			score[n] = Integer.parseInt(st.nextToken());
			sum += score[n];
		}
		
		int l = 0, r = sum, ans = 0;
		while(l <= r) {
			int mid = l + (r - l) / 2;
			
			int cnt = 0; // 그룹 개수
			int subSum = 0;
			for(int n=0; n<N; n++) {
				subSum += score[n];
				if(subSum >= mid) {
					cnt ++;
					if(cnt > K) break;
					subSum = 0;
				}
			}
			
			if(cnt >= K) {
				ans = mid;
				l = mid + 1;
			}else {
				r = mid - 1;
			}
		}
		
		System.out.println(ans);
		br.close();
	}

}
