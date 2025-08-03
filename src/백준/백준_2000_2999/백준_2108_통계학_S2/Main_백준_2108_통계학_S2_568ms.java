package 백준.백준_2000_2999.백준_2108_통계학_S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_2108_통계학_S2_568ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		for(int n=0; n<N; n++) {
			arr[n] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		double sum = 0;
		int mode = 0;
		int idx = 0;
		int cnt = 0;
		int change = 0;
		for(int n=0; n<N; n++) {
			sum += arr[n];
			if(n == N-1 ||arr[n] != arr[n+1]) {
				int freq = n - idx + 1;
				if(freq > cnt) {
					cnt = freq;
					mode = arr[idx];
					change = 1;
				}else if(freq == cnt && change < 2) {
					mode = arr[idx];
					change++;
				}
				idx = n + 1;
			}
		}
		
		sb.append((int) Math.round(sum/N)).append("\n").append(arr[N/2]).append("\n").append(mode).append("\n").append(arr[N-1] - arr[0]);
		System.out.println(sb.toString());
		br.close();
	}

}
