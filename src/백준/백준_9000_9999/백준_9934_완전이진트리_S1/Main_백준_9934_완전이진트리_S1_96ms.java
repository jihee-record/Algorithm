package 백준.백준_9000_9999.백준_9934_완전이진트리_S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// inorder
public class Main_백준_9934_완전이진트리_S1_96ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int K = Integer.parseInt(br.readLine());
		int N = (int)Math.pow(2, K); // 노드 개수 + 1
		String[] inorder = br.readLine().split(" ");
		
		int diff = N; // 각 level 수열의 공차 - 지금은 level 1 
		
		while(diff > 1) { // 리프 끼리 diff는 2이상 
			for(int d=(diff/2)-1; d<N; d+=diff) {
				sb.append(inorder[d]).append(" ");
			}
			sb.append("\n");
			diff /= 2;
		}
		
		System.out.println(sb.toString());
		br.close();
	}

}
