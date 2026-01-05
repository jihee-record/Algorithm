package 백준.백준_4000_4999.백준_4256_트리_G2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_4256_트리_G2_332ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] pre = new int[N];
			int[] in = new int[N];
			int[] inIdx = new int[N+1]; // 1부터 - 각 값이 in 배열 어느 index 위치하는지
			int[] post = new int[N];
			
			StringTokenizer stPre = new StringTokenizer(br.readLine());
			StringTokenizer stIn = new StringTokenizer(br.readLine());
			
			for(int n=0; n<N; n++) {
				pre[n] = Integer.parseInt(stPre.nextToken());
				
				int inValue = Integer.parseInt(stIn.nextToken());
				in[n] = inValue;
				inIdx[inValue] = n;
			}
				
			int[] stack = new int[4 * N]; // preL, preR, inL, inR
			int top = 0;
			int postIdx = 0;
			
			stack[top++] = 0;
			stack[top++] = N-1;
			stack[top++] = 0;
			stack[top++] = N-1;
			
			// 4개씩 꺼내야하므로 최소 4
			while(top > 0) {
				int inR = stack[--top];
				int inL = stack[--top];
				int preR = stack[--top];
				int preL = stack[--top];
				
				int root = pre[preL];
				post[postIdx++] = root;
				
				int rootIdx = inIdx[root];
				int leftSize = rootIdx - inL;
				
				// LIFO이니까 나중에 체크할 왼쪽트리를 먼저 넣음
				int lInR = rootIdx - 1;
				if(inL <= lInR) {
					stack[top++] = preL + 1;
					stack[top++] = preL + leftSize;
					stack[top++] = inL;
					stack[top++] = rootIdx - 1;
				}
				
				int rInL = rootIdx + 1;
				if(rInL <= inR) {
					stack[top++] = preL + leftSize + 1;
					stack[top++] = preR;
					stack[top++] = rInL;
					stack[top++] = inR;
				
				}
			}
			
			for(int n=N-1; n>=0; n--) {
				sb.append(post[n]).append(" ");
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}

}
