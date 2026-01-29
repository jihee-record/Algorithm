package 백준.백준_1000_1999.백준_1477_휴게소세우기_G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 구간 길이 주의 (N 아니고 N + 2 : last index = N + 1)
public class Main_백준_1477_휴게소세우기_G4_92ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 현재 휴게소 개수
		int M = Integer.parseInt(st.nextToken()); // 지을 휴게소 개수
		int L = Integer.parseInt(st.nextToken()); // 고속도로 길이
		
		int[] already = new int[N+2]; // 0, L 끝 점 추가
		already[N+1] = L;
		
		st = new StringTokenizer(br.readLine());
		for(int n=1; n<=N; n++) {
			already[n] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(already);
		
		int maxDiff = 0;
		for(int n=1; n<=N+1; n++) {
			maxDiff = Math.max(maxDiff, already[n] - already[n-1]);
		}
		
		int l = 1, r = maxDiff, ans = 0;
		while(l <= r) {
			int mid = l + (r - l) / 2;
			
			int cnt = 0;
			for(int n=1; n<=N+1; n++) {
				int diff = already[n] - already[n-1];
				if(diff <= mid) continue;
				cnt += (diff - 1) / mid; // 현재 구간 뉴 휴게소
				if(cnt > M) break;
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
