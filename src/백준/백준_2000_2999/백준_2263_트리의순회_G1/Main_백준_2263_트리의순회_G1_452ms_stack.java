package 백준.백준_2000_2999.백준_2263_트리의순회_G1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 트리 역추적 - dfs
public class Main_백준_2263_트리의순회_G1_452ms_stack {

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
		
		Stack<int[]> stack = new Stack<>();
		stack.push(new int[] {0, N-1, 0, N-1});
		
		while(!stack.isEmpty()) {
			int[] now = stack.pop();
			int postL = now[0];
			int postR = now[1];
			
			if(postL > postR) continue;
			
			int postRoot = post[postR];
			sb.append(postRoot).append(" ");
			
			int inL = now[2];
			int inR = now[3];
			
			int rootIdx = inorderIdx[postRoot];
			int sizeL = rootIdx - inL;
			
			// LIFO
			stack.push(new int[] {postL + sizeL, postR - 1, rootIdx + 1, inR});
			stack.push(new int[] {postL, postL + sizeL - 1, inL, rootIdx - 1});
		}

		System.out.println(sb.toString());
		br.close();
	}

}
