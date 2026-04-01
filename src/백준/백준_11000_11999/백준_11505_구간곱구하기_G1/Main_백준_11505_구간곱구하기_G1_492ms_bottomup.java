package 백준.백준_11000_11999.백준_11505_구간곱구하기_G1;

import java.util.*;
import java.io.*;

class Main_백준_11505_구간곱구하기_G1_492ms_bottomup { 
    static int MOD = 1_000_000_007;
    
    static class SegmentTree {
        long[] tree;
        int n;
        int leafStart;

        SegmentTree(long[] arr, int n) {
            this.n = n;
            this.leafStart = 1;
            while (leafStart < n) leafStart *= 2;
            this.tree = new long[2 * leafStart]; 
            Arrays.fill(tree, 1); 
            
            for (int i = 1; i <= n; i++) {
                tree[leafStart + i - 1] = arr[i] % MOD;
            }

            for (int i = leafStart - 1; i > 0; i--) {
                tree[i] = (tree[i * 2] * tree[i * 2 + 1]) % MOD;
            }
        }
       
        void update(int idx, long tobe) {
            int i = leafStart + idx - 1; 
            tree[i] = tobe % MOD;
            while (i > 1) {
                i /= 2;
                tree[i] = (tree[i * 2] * tree[i * 2 + 1]) % MOD;
            }
        }
        
        long query(int left, int right) {
            long res = 1;
            int l = leafStart + left - 1;
            int r = leafStart + right - 1;

            while (l <= r) {
                if (l % 2 == 1) {
                    res = (res * tree[l]) % MOD;
                    l++;
                }
                
                if (r % 2 == 0) {
                    res = (res * tree[r]) % MOD;
                    r--;
                }
                
                l /= 2;
                r /= 2;
            }
            return res;
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