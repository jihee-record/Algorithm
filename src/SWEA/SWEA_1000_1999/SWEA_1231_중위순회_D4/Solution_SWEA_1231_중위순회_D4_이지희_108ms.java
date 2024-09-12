package SWEA.SWEA_1000_1999.SWEA_1231_중위순회_D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1231_중위순회_D4_이지희_108ms {
	
	static String[] tree;
	static StringBuilder sb;
	
	// 중위 순회
	static void inorder(int x) { // index
		if(x >= tree.length || x == 0) {
			return;
		}
		
		inorder(2*x); // 왼쪽
		sb.append(tree[x]); // 나
		inorder(2*x+1); // 오른쪽
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;
		
		for(int t=1; t<=10; t++) { // 테케
			sb.append("#").append(t).append(" ");
			int N = Integer.parseInt(br.readLine()); //정점의 수
			
			tree = new String[N+1]; // index : Node번호 1~N
			for(int n=1; n<=N; n++) { // 정점 정보 받기
				st = new StringTokenizer(br.readLine());
				st.nextToken(); //index = n
				tree[n] = st.nextToken();
			}// for(n) 종료
			inorder(1);
			sb.append("\n");
		} //테케 종료
		
		System.out.println(sb.toString());
		br.close();
	} //main()

} // class
