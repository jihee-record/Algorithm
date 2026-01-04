package 백준.백준_2000_2999.백준_2512_예산_S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 19:40
// Binary Search <  Parametric Search
public class Main_백준_2512_예산_S2_144ms_parameter_bs {
	
	static int binarySearch(int[] arr, int max, int budget) {
		int left = 0, right = max, ans = 0;
		
		while(left <= right) {
			int mid = left + (right - left) / 2;
			
			int sum = 0;
			for(int i=0; i<arr.length; i++) {
				sum += Math.min(arr[i], mid);
			}
			
			if(sum <= budget){
				ans = mid;
				left = mid + 1;
			}
			else right = mid - 1;
		}
		
		return ans;  
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 지역 수
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N]; 
		
		int max = 0;
		int totalDemand = 0; // 요구 예산 총합
		for(int n=0; n<N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[n]);
			totalDemand += arr[n];
		}
		
		int budget = Integer.parseInt(br.readLine());

		// 예산 넉넉
		if(budget >= totalDemand) {
			System.out.println(max);
			return;
		}
		
		// 최소 요구치보다 적어
		if(budget < arr[0]) {
			System.out.println(budget / N);
			return;
		}
		
		System.out.println(binarySearch(arr, max, budget));
	}
}
