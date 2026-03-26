package 백준.백준_2000_2999.백준_2470_두용액_G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_2470_두용액_G5_316ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n=0; n<N; n++) arr[n] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		
		int[] ans = new int[2];
		int v = Integer.MAX_VALUE;
		int l = 0, r = N - 1;
		while(l < r) {
			int sum = arr[l] + arr[r];
			int abSum = Math.abs(sum);
			if(abSum < v) {
				v = abSum;
				ans[0] = l; 
				ans[1] = r;
			}
			
			if(sum == 0) break;
			else if(sum < 0) l++;
			else r--;
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(arr[ans[0]]).append(' ' ).append(arr[ans[1]]);
		System.out.println(sb);
		br.close();
	}
}
