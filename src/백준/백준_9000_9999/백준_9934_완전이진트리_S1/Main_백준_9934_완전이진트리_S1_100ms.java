package 백준.백준_9000_9999.백준_9934_완전이진트리_S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// inorder
public class Main_백준_9934_완전이진트리_S1_100ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int K = Integer.parseInt(br.readLine());
		int N = (int)Math.pow(2, K) - 1; // 노드 개수
		String[] inorder = br.readLine().split(" ");
		
		int cnt = 1;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0, N-1}); // left, right index of tree // 처음부터 (2^K)-2로 해도되고
		
		int temp = 0;
		while(!queue.isEmpty()) {
			int[] tree = queue.poll();
			int rootIdx = (tree[0] + tree[1]) / 2; 
			sb.append(inorder[rootIdx]).append(" ");
			
			if(tree[0] == tree[1]) continue; // 리프 노드
			
			queue.add(new int[] {tree[0], rootIdx - 1}); // 왼쪽 트리
			queue.add(new int[] {rootIdx + 1, tree[1]}); // 오른쪽 트리

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
