package 백준.백준_2000_2999.백준_2343_기타레슨_G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2343_기타레슨_G5_236ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] course = new int[N];
		int l = 0; // 가장 긴 비디오 길이
		int r = 0; // 전체 비디오 길이 합
		st = new StringTokenizer(br.readLine());
		for(int n=0; n<N; n++) {
			course[n] = Integer.parseInt(st.nextToken());
			l = Math.max(l, course[n]);
			r += course[n];
		}
		
		int ans = 0; 
		while(l <= r) {
			int mid = l + (r - l) / 2;
			
			int cnt = 1; // 블루레이 개수
			int sum = 0; // 현재 블루레이에 녹화된 영상 길이
			for(int n=0; n<N; n++) {
				if(sum + course[n] <= mid) {
					sum += course[n];
				}else {
					if(++cnt > M) break;
					sum = course[n];
				}
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