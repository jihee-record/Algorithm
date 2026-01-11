package 백준.백준_1000_1999.백준_1806_부분합_G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 슬라이딩윈도우 / 투 포인터
 */
public class Main_백준_1806_부분합_G4_248ms_slidingwindow {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // >= 10
		int S = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N]; 
		
		int sum = 0;
		for(int n=0; n<N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());;
		}
		
		int left = 0, right = 0; // left, right : increasing pointer 
		int minLength = N + 1; // 불가능한 숫자
		
		for(; right<N; right++) {
			sum += arr[right];
			while(left <= right && sum >= S) {
				minLength = Math.min(right - left + 1, minLength);
				sum -= arr[left];
				left ++; 
			}
		}
		
		System.out.println(minLength ==  N + 1? 0 : minLength);
		br.close();
	}

}
