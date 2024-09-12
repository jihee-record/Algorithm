package SWEA.SWEA_1000_1999.SWEA_1232_사칙연산_D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1232_사칙연산_D4_이지희_130ms {
	
	static class Node{
		String value; // node value
		int left; //left tree result
		int right; // right tree result
		
		public Node(String value) {
			this.value = value;
		}
		
		public Node(String value, int left, int right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
	
	static Node[] tree;
	static StringBuilder sb;
	
	// 중위 순회 : result of calculation of subtree
	static int inorder(int x) { // index
		if(x >= tree.length || x == 0) {
			return 0;
		}
		
		switch(tree[x].value) {
			case "+": {
				int a = inorder(tree[x].left);
				int b =	inorder(tree[x].right);
				return a+b;
			}
			case "-": {
				int a = inorder(tree[x].left);
				int b =	inorder(tree[x].right);
				return a-b;
			}
			case "*": {
				int a = inorder(tree[x].left);
				int b =	inorder(tree[x].right);
				return a*b;
			}
			case "/": {
				int a = inorder(tree[x].left);
				int b =	inorder(tree[x].right);
				return a/b;
			}
		}
		
		return Integer.parseInt(tree[x].value);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;
		
		for(int t=1; t<=10; t++) { // 테케
			sb.append("#").append(t).append(" ");
			int N = Integer.parseInt(br.readLine()); //정점의 수
			
			tree = new Node[N+1]; // index : Node번호 1~N
			for(int n=1; n<=N; n++) { // 정점 정보 받기
				st = new StringTokenizer(br.readLine());
				st.nextToken(); //index = n
				String str = st.nextToken();
				if("+-*/".contains(str)) {
					tree[n] = new Node(str, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				}else {
					tree[n] = new Node(str);
				}
			}// for(n) 종료
			
			sb.append(inorder(1)).append("\n");
		} //테케 종료
		
		System.out.println(sb.toString());
		br.close();
	} //main()

} // class
