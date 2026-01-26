package 백준.백준_1000_1999.백준_1253_좋다_G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_1253_좋다_G4_276ms_binarysearch {
	static int N;
	static int binarySearch(int[] seq, int start, int target) {
		int left = start, right = N - 1, ans = start;

		while(left <= right) {
			int mid = left + (right - left) / 2;
			if(seq[mid] == target) {
				
				return mid;
			}
			
			if(seq[mid] < target) {
				ans = mid;
				left = mid + 1;
			} else { // seq[mid] > target
				right = mid - 1;
			}
		}
		
		return ans;
	}
	
	static boolean findTwoSum(int[] seq, int idx) {
		for(int left = 0; left < N-1; left++) {
			if(left == idx) continue;
			if(seq[left] == 0 && idx < N-1 && left != idx + 1 && seq[idx] == seq[idx + 1]) return true; // 1, 1, 1의 경우 A(0) = 1만 체크하므로
			
			int right = binarySearch(seq, left + 1, seq[idx] - seq[left]);
//			System.out.println("seq["+idx + "]= " +seq[idx] + ", "+left + "-" + right);
			if(right == idx) continue;
//			System.out.println("seq["+idx + "]= " +seq[idx] + ", "+left + "-" + right);
			if(seq[left] + seq[right] == seq[idx]) return true;
		}
		
		
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		int[] seq = new int[N]; 
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n=0; n<N; n++) {
			seq[n] = Integer.parseInt(st.nextToken());
		}
		
		if(N <= 2) {
			System.out.println(0);
			return;
		}
		
		Arrays.sort(seq);
		
//		for(int n=0; n<N; n++) {
//			System.out.print(seq[n]+ " ");
//		}
//		System.out.println();
		
		int cnt = 0;
		boolean before = false;
		for(int n=0; n<N; n++) {
			if(n > 0 && seq[n-1] == seq[n]) {
				if(before) cnt++;
				continue;
			}
			
			boolean isGood = findTwoSum(seq, n);
			if(isGood) cnt++;
			before = isGood;
		}
		
		System.out.println(cnt);
		br.close();
	}

}
