package 백준.백준_2000_2999.백준_2263_트리의순회_G1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 트리 역추적 - dfs - 재귀
public class Main_백준_2263_트리의순회_G1_412ms {
	static StringBuilder sb;
	static int[] inorder, post;
	static int[] inorderIdx;
	
	static void findPre(int postL, int postR, int inL, int inR) {
		if(postL > postR || inL > inR) return;
		int postRoot = post[postR];
		sb.append(postRoot).append(" ");
		
		int rootIdx = inorderIdx[postRoot];
		int sizeL = rootIdx - inL;
		int sizeR = inR - rootIdx;
		
		findPre(postL, postL + sizeL - 1, inL, rootIdx - 1);
		findPre(postR - sizeR, postR - 1, rootIdx + 1, inR);
	}

	// 임의의 숫작 아니라 1~N 숫자로 지정
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		inorder = new int[N];
		inorderIdx = new int[N+1];
		post = new int[N];
		
		for(int n=0; n<N; n++) {
			int inorderVal = Integer.parseInt(st1.nextToken());
			inorder[n] = inorderVal;
			inorderIdx[inorderVal] = n;
			post[n] = Integer.parseInt(st2.nextToken());
		}

		findPre(0, N-1, 0, N-1);
		System.out.println(sb.toString());
		br.close();
	}

}
