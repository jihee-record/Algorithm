package SWEA.SWEA_B_25.SWEA_7_중위순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_7_중위순회 {
	static StringBuilder sb;
	
	// 중위 순회 나의 왼쪽 자식 > 나 > 오른쪽 자식 순으로 순회
	static class Node{
		int no;
		char c;
		Node left;
		Node right;
		
		Node(){}
		Node(int n){
			this.no = n;
		}
	}
	
	static void print(Node now) {
		Node left = now.left;
		if(left != null) {
			print(left);
		}
		sb.append(now.c);
		Node right = now.right;
		if(right != null) {
			print(right);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		
		for(int t=1; t<=1; t++) {
			sb.append("#").append(t).append(" ");
			
			int N = Integer.parseInt(br.readLine());
			
			Node[] tree = new Node[N+1];
			for(int n=1; n<=N; n++) {
				tree[n] = new Node(n);
			}
			
			for(int n=1; n<=N; n++) {
				st = new StringTokenizer(br.readLine(), " ");
				int no = Integer.parseInt(st.nextToken());
				char c = st.nextToken().charAt(0);
				
				Node node = tree[n];
				node.no = no;
				node.c = c;

				if(!st.hasMoreTokens()) {
					continue;
				}
				
				int left = Integer.parseInt(st.nextToken());
				node.left = tree[left];
				
				if(!st.hasMoreTokens()) {
					continue;
				}
				
				int right = Integer.parseInt(st.nextToken());
				node.right = tree[right];
			}
			
			print(tree[1]);
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		br.close();
	}

}
