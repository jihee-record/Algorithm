package 백준.백준_2000_2999.백준_2042_구간합구하기_G1;

import java.util.*;
import java.io.*;

class Main_백준_2042_구간합구하기_G1_548ms {
	static class SegmentTree {
		long[] tree;
		long[] arr;
		
		SegmentTree(long[] arr, int N){
			this.arr = arr;
			this.tree = new long[4 * N];
			init(1, 0, N-1);
		}
		
		public long init(int node, int start, int end) {
			if(start == end){
				return tree[node] = arr[start];
			}
			
			int mid = start + (end - start) / 2;
			
			return tree[node] = init(2 * node, start, mid) + init(2 * node + 1, mid + 1, end);
		}
		
		public void update(int node, int start, int end, int idx, long diff){
			if(idx < start || end < idx) return;
			
			tree[node] += diff;
			
			if(start != end){
				int mid = start + (end - start) / 2;
				update(2 * node, start, mid, idx, diff);
				update(2 * node + 1, mid + 1, end, idx, diff);
			}
		}
		
		public long sum(int node, int start, int end, int left, int right){
			if(left > end || right < start) return 0;
			
			if(left <= start && end <= right) return tree[node];
			
			int mid = start + (end - start) / 2;
			
			return sum(2 * node, start, mid, left, right) + sum(2 * node + 1, mid + 1, end, left, right);
			
		}
	}
	
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		long[] arr = new long[N];
		for(int n=0; n<N; n++){
			arr[n] = Long.parseLong(br.readLine());
		}
		
		SegmentTree seg = new SegmentTree(arr, N);
		
		for(int i=0; i<M+K; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			if(a == 1) {
				long diff = c - arr[b-1];
				seg.update(1, 0, N-1, b-1, diff);
				arr[b-1] = c;
			} else { // a == 2
				sb.append(seg.sum(1, 0, N-1, b-1, (int) c-1)).append('\n');
			}
		}
		
		System.out.print(sb);
		br.close();
	}
}