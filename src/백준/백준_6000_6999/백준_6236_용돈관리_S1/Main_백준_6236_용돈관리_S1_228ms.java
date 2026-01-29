package 백준.백준_6000_6999.백준_6236_용돈관리_S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_6236_용돈관리_S1_228ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] money = new int[N];
		int max = 0;
		for(int n=0; n<N; n++) {
			money[n] = Integer.parseInt(br.readLine());
			max = Math.max(max, money[n]);
		}
		
		int l = max, r = max * N, ans = 0;
		
		while(l <= r) {
			int mid = l + (r - l) / 2; 
			int cnt = 0;
			int remain = 0;
			for(int n=0; n<N; n++) {
				if(remain < money[n]) {
					cnt ++; 
					remain = mid; 
				}
				
				remain -= money[n];
			}
			
			if(cnt <= M) {
				ans = mid;
				r = mid - 1;
				
			}else {
				l = mid + 1;
			}
		}
		
		System.out.println(ans);
		br.close();
	}

}
