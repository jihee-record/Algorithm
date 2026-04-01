package 백준.백준_11000_11999.백준_11505_구간곱구하기_G1;

import java.util.*;
import java.io.*;

class Main_백준_11505_구간곱구하기_G1_508ms_rec { 
    static int MOD = 1_000_000_007;
    
    static class SegmentTree {
        long[] tree;
        int n;

        SegmentTree(long[] arr, int n) {
            this.n = n;
            this.tree = new long[4 * n];
            init(arr, 1, 1, n);
        }

        long init(long[] arr, int node, int start, int end) {
            if (start == end) return tree[node] = arr[start] % MOD;
            
            int mid = start + (end - start) / 2;
            return tree[node] = (init(arr, 2 * node, start, mid) * init(arr, 2 * node + 1, mid + 1, end)) % MOD;
        }
        
        long update(int idx, long tobe) {
        	return update(1, 1, n, idx, tobe);	
        }

        private long update(int node, int start, int end, int idx, long tobe) {
            if (idx < start || end < idx) return tree[node];

            if (start == end) return tree[node] = tobe % MOD;

            int mid = start + (end - start) / 2;
            return tree[node] = (update(2 * node, start, mid, idx, tobe) * update(2 * node + 1, mid + 1, end, idx, tobe)) % MOD;
        }
        
        long query(int left, int right){
        	return query(1, 1, n, left, right);
        }

        private long query(int node, int start, int end, int left, int right) {
            if (left > end || right < start) return 1; 
            if (left <= start && end <= right) return tree[node];

            int mid = start + (end - start) / 2;
            return (query(2 * node, start, mid, left, right) * query(2 * node + 1, mid + 1, end, left, right)) % MOD;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		long[] arr = new long[N+1];
		for(int n=1; n<=N; n++) arr[n] = Long.parseLong(br.readLine());
		
		SegmentTree seg = new SegmentTree(arr, N);
		
		for(int i=0; i<M+K; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			if(a == 1) seg.update(b, c);
			else sb.append(seg.query(b, (int) c)).append('\n');
		}
		
		System.out.print(sb);
		br.close();
    }
}