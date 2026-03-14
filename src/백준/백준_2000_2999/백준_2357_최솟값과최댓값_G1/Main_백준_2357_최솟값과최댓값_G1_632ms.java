package 백준.백준_2000_2999.백준_2357_최솟값과최댓값_G1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2357_최솟값과최댓값_G1_632ms {
	static class SegmentTree {
		int N;
		int[] maxTree;
		int[] minTree;
		
		SegmentTree(int[] arr, int N){
			this.N = N;
			this.maxTree = new int[4 * N];
			this.minTree = new int[4 * N];
			init(arr, 1, 1, N);
		}
		
		private int[] init(int[] arr, int node, int start, int end) {
			if(start == end) {
				minTree[node] = arr[start];
				maxTree[node] = arr[start];
				return new int[] {arr[start], arr[start]};
			}
			
			int mid = (start + end) / 2;
			int[] left = init(arr, 2 * node, start, mid);
			int[] right = init(arr, 2 * node + 1, mid + 1, end);
			minTree[node] = Math.min(left[0], right[0]);
			maxTree[node] = Math.max(left[1], right[1]);
			return new int[] {minTree[node], maxTree[node]};
		}
		
//		void update(int idx, int k) {
//			update(1, 1, N, idx, k);
//		}
//		
//		private void update(int node, int start, int end, int idx, int k) {
//			if(start == end) {
//				maxTree[node] = k;
//				minTree[node] = k;
//				return;
//			}
//			
//			int mid = (start + end) / 2;
//			if(idx < mid) update(2 * N, start, mid, idx, k);
//			else update(2 * N + 1, mid + 1, end, idx, k);
//			
//			maxTree[node] = Math.max(maxTree[node], k); 
//			minTree[node] = Math.min(minTree[node], k); 
//		}
		
		int[] getExtream(int left, int right) {
			return getExtream(1, 1, N, left, right);
		}

		private int[] getExtream(int node, int start, int end, int left, int right) {
			if(right < start || end < left) return new int[] {0, 0};
			if(left <= start && end <= right) return new int[] {minTree[node], maxTree[node]};
			
			int mid = (start + end) / 2;
			if(right <= mid) return getExtream(2 * node, start, mid, left, right);
			if(mid < left) return getExtream(2 * node + 1, mid + 1, end, left, right);
			
			int[] extreamL = getExtream(2 * node, start, mid, left, right);
			int[] extreamR = getExtream(2 * node + 1, mid + 1, end, left, right);
			
			int min = Math.min(extreamL[0], extreamR[0]);
			int max = Math.max(extreamL[1], extreamR[1]);
			return new int[] {min, max};
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N + 1];
		for(int n=1; n<=N; n++) arr[n] = Integer.parseInt(br.readLine());
		
		SegmentTree seg = new SegmentTree(arr, N);
		
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			int[] res = seg.getExtream(left, right);
			sb.append(res[0]).append(' ').append(res[1]).append('\n');
		}
		
		System.out.println(sb);
		br.close();
	}

}
