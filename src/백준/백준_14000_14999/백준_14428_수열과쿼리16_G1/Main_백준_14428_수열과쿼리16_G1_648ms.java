package 백준.백준_14000_14999.백준_14428_수열과쿼리16_G1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_백준_14428_수열과쿼리16_G1_648ms {
	static class SegmentTree {
		int N;
		int[] arr;
		int[] tree;
		
		SegmentTree(int[] arr, int N){
			this.N = N;
			this.arr = arr;
			this.arr[0] = Integer.MAX_VALUE;
			this.tree = new int[4 * N];
			init(1, 1, N);
		}
		
		// 각 노드는 arr의 idx값 <- 조건을 만족하는
		private int init(int node, int start, int end){
			if(start == end) return tree[node] = start;
			
			int mid = start + (end - start) / 2;
			int minLIdx = init(2 * node, start, mid);
			int minRIdx = init(2 * node + 1, mid + 1, end);
			
			if(arr[minLIdx] <= arr[minRIdx]) return tree[node] = minLIdx;
			return tree[node] = minRIdx; // else
		}
		
		void update(int idx, int k){
			arr[idx] = k;
			update(1, 1, N, idx);
		}
		
		private void update(int node, int start, int end, int idx){
			if (start == end) return;
			
			int mid = start + (end - start) / 2;
			if (idx <= mid) update(node * 2, start, mid, idx); // 왼쪽 트리
		    else update(node * 2 + 1, mid + 1, end, idx); //오른쪽 트리
			
			int minLIdx = tree[node * 2];
		    int minRIdx = tree[node * 2 + 1];
		    tree[node] = (arr[minLIdx] <= arr[minRIdx]) ? minLIdx : minRIdx;
		}
		
		int getLowestIdx(int left, int right) {
			return getLowestIdx(1, 1, N, left, right);
		}
		
		private int getLowestIdx(int node, int start, int end, int left, int right){
            if (left <= start && end <= right) return tree[node];
            
            int mid = start + (end - start) / 2;
            if(right <= mid) return getLowestIdx(2 * node, start, mid, left, right);
			if(left > mid) return getLowestIdx(2 * node + 1, mid + 1, end, left, right);
			
			int minLIdx = getLowestIdx(2 * node, start, mid, left, right);
			int minRIdx = getLowestIdx(2 * node + 1, mid + 1, end, left, right);
			return arr[minLIdx] <= arr[minRIdx] ? minLIdx :  minRIdx;
		}
	}
	
	
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n=1; n<=N; n++) arr[n] = Integer.parseInt(st.nextToken());
		
		SegmentTree seg = new SegmentTree(arr, N);
		
		int M = Integer.parseInt(br.readLine());
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a == 1) seg.update(b, c);
			else sb.append(seg.getLowestIdx(b, c)).append('\n');
		}
		
		System.out.print(sb);
		br.close();
	}
}