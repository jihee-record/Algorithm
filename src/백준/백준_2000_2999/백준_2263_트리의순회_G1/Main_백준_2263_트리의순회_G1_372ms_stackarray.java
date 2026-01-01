package 백준.백준_2000_2999.백준_2263_트리의순회_G1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 트리 역추적 - dfs - 스택구현
public class Main_백준_2263_트리의순회_G1_372ms_stackarray {

	// 임의의 숫자가 아니라 1~N 숫자로 지정
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		int[] inorder = new int[N];
		int[] inorderIdx = new int[N+1];
		int[] post = new int[N];
		
		for(int n=0; n<N; n++) {
			int inorderVal = Integer.parseInt(st1.nextToken());
			inorder[n] = inorderVal;
			inorderIdx[inorderVal] = n;
			post[n] = Integer.parseInt(st2.nextToken());
		}
		
		int[] stack = new int[N*4]; // postL, postR, inL, inR 세트
		int top = 0;
		stack[top++] = 0; // postL
		stack[top++] = N-1; // postR
		stack[top++] = 0; // inL
		stack[top++] = N-1; // inR
		
		while(top > 0) {
			int inR = stack[--top];
			int inL = stack[--top];
			int postR = stack[--top];
			int postL = stack[--top];
			
			int root = post[postR];
			sb.append(root).append(" ");
			
			
			int rootIdx = inorderIdx[root];
			int leftSize = rootIdx - inL;
			
			// LIFO
			// 오른쪽서브트리
			int rInL = rootIdx + 1;
			if(rInL <= inR) {
				stack[top++] = postL + leftSize;
				stack[top++] = postR - 1;
				stack[top++] = rInL;
				stack[top++] = inR;
			}
			
			// 왼쪽서브트리
			int lInR = rootIdx - 1;
			if(inL <= lInR) {
				stack[top++] = postL;
				stack[top++] = postL + leftSize - 1;
				stack[top++] = inL;
				stack[top++] = lInR;
			}
		}

		System.out.println(sb.toString());
		br.close();
	}

}
