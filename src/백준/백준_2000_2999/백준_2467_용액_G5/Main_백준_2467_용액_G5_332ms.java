package 백준.백준_2000_2999.백준_2467_용액_G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 산성 > 0, 알칼리 < 0
 */
// 투 포인터
public class Main_백준_2467_용액_G5_332ms {
	
	// 특성값 두개 찾기
	/*
	 * 끝에서 두 값 a,b(a < b)를 더했을 때
	 * 음수면 b를 더 작은 값으로 설정하면 절대값이 커지므로 a = a + 1;
	 * 양수면 b = b - 1; 
	 */
	static int[] findEv(int[] arr) {
		int[] ans = new int[2];
		
		int min = 2000000000;
		int left = 0 , right = arr.length - 1;
		
		while(left < right) {
			int sum = arr[left] + arr[right];
			int abs = Math.abs(sum);
			
			if(abs < min) {
				min = abs;
				ans[0] = arr[left];
				ans[1] = arr[right];
			}
			
			if(sum == 0) return ans;

			if(sum > 0)  right --;
			else  left ++ ;
			
		}
		
		return ans;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] value = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n=0; n<N; n++) {
			value[n] = Integer.parseInt(st.nextToken());
		}
		
		int[] ans = findEv(value);
		System.out.println(ans[0] + " " + ans[1]);
		
		br.close();
	}

}
