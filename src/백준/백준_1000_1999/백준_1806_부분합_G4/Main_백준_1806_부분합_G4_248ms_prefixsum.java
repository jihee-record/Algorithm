package 백준.백준_1000_1999.백준_1806_부분합_G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 누적합 / 투 포인터
 */
public class Main_백준_1806_부분합_G4_248ms_prefixsum {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // >= 10
		int S = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int[] sum = new int[N + 1]; 
		
		for(int n=1; n<=N; n++) {
			sum[n] = sum[n-1] + Integer.parseInt(st.nextToken());;
		}
		
		int left = 0, right = 1; // left, right : increasing pointer 
		int minLength = N + 1; // 불가능한 숫자
		
		// right 제한을 줘야해 한 방향 인크리징 이므로 
		for(; right <= N; right++) {
			while(left < right && sum[right] - sum[left] >= S) {
				minLength = Math.min(right - left, minLength);
				left ++;
			}
		}
		
		System.out.println(minLength ==  N + 1? 0 : minLength);
		br.close();
	}

}
