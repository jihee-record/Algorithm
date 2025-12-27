package 백준.백준_9000_9999.백준_9934_완전이진트리_S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// inorder
public class Main_백준_9934_완전이진트리_S1_100ms_queuearray {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int K = Integer.parseInt(br.readLine());
		int N = (int)Math.pow(2, K) - 1; // 노드 개수
		String[] inorder = br.readLine().split(" ");
		
		int cnt = 1;
		int[] queue = new int[2 * N]; // left, right 
		int rear = 0;
		int front = 0;
		queue[rear++] = 0;
		queue[rear++] = N-1;
		
		int temp = 0;
		while(front < rear) {
			int left = queue[front++];
			int right = queue[front++];
			int rootIdx = (left + right) / 2; 
			sb.append(inorder[rootIdx]).append(" ");
			
			if(left == right) continue; // 리프 노드
			
			// left subtree
			queue[rear++] = left;
			queue[rear++] = rootIdx - 1;
			// right subtree
			queue[rear++] = rootIdx + 1;
			queue[rear++] = right;
			

			if(++temp >= cnt) {
				sb.append("\n");
				cnt *= 2; // 각 레벨별 노드 개수 
				temp = 0; // 기록한 레벨의 노드 개수 초기화
			}
		}
		
		
		System.out.println(sb.toString());
		br.close();
	}

}
