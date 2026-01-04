package 백준.백준_2000_2999.백준_2512_예산_S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1:38 ~
// Binary Search
/** 
 * 어디만 더 많이 주고 이런건 불가능, 예산이 부족하다면 동등하게 나누어주어야 함 <- 예제 결과에 따라
 */
public class Main_백준_2512_예산_S2_148ms_greedy_bs {
	
	static int binarySearch(int[] arr, int start, int target) {
		int left = start, right = arr.length - 1;
		
		while(left <= right) {
			int mid = left + (right - left) / 2;
			if(arr[mid] == target) return mid;
			else if(arr[mid] < target) left = mid + 1;
			else right = mid - 1;
		}
		
		// 딱 맞는 값을 찾지는 못했지만 지금 right < left 상태에서 이 사이에 target 값이 존재
		// 딱 맞는 값이면 거기까지 예산 분배를 해야하므로 분배가 가능한 곳 반환
		// !! left로 해서 for 문에서 left 이전까지로 하려고 했는데 평균값이 예산 중 존재하는 경우 해당 값을 제외하게 되므로 오류 발생 
		return right;  
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 지역 수
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N]; 
		int totalDemand = 0; // 요구 예산 총합
		for(int n=0; n<N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
			totalDemand += arr[n];
		}
		Arrays.sort(arr);
		
		int budget = Integer.parseInt(br.readLine());
		
		// 예산 넉넉
		if(budget >= totalDemand) {
			System.out.println(arr[N - 1]);
			return;
		}
		
		// 분배필요
		int avg = budget / N ; // 평균 지점 찾기
		int start = 0;
		
		while(avg >= arr[start]){ // 같은 경우 생각 안해서 틀림
			int idx = binarySearch(arr, start, avg);
			for(int i=start; i<=idx; i++) {
				budget -= arr[i]; // 평균보다 적은 예산을 요구한 곳은 먼저 다 분배 
			}
			
			// 남은 예산에서 평균 잡아서 다시 반복
			// 이유는 남은 평균이 지역 예산보다 많을 수 있으니까
			avg = budget / (N - idx - 1);
			start = idx + 1;
		}
		
		System.out.println(avg);
		br.close();
	}

}
