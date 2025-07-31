package 백준.백준_2000_2999.백준_2110_공유기설치_G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_2110_공유기설치_G4_272ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int[] house = new int[N];
		for(int n=0; n<N; n++) {
			house[n] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(house);
		                                                 
		int left = 1;
		int right = house[N-1] - house[0];
		int result = 0;
		while(left <= right) {
			int mid = (left + right) / 2;
			int cnt = 1;
			int idx = 0;
			for(int n=1; n<N; n++) {
				if(house[n] - house[idx] < mid) continue;
				
				idx = n;
				cnt++;
				if(cnt >= C) break;
			}
			
			if(cnt < C) {
				right = mid - 1;
			} else {
				result = mid;
				left = mid + 1;
			}
		}
		
		System.out.println(result);
		br.close();
	}

}
