package 백준.백준_2000_2999.백준_2263_트리의순회_G1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

// 트리 역추적 - dfs - 재귀
public class Main_백준_2263_트리의순회_G1_456ms {
	static StringBuilder sb;
	static String[] inorder, post;
	static HashMap<String, Integer> inorderIdxMap;
	
	static void findPre(int postL, int postR, int inL, int inR) {
		if(postL > postR || inL > inR) return;
		sb.append(post[postR]).append(" ");
		
		int rootIdx = inorderIdxMap.get(post[postR]);
		int sizeL = rootIdx - inL;
		int sizeR = inR - rootIdx;
		
		findPre(postL, postL + sizeL - 1, inL, rootIdx - 1);
		findPre(postR - sizeR, postR - 1, rootIdx + 1, inR);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		inorder = br.readLine().split(" ");
		post = br.readLine().split(" ");
		
		inorderIdxMap = new HashMap<>();  // key: node, value: idx
		for(int n=0; n<N; n++) {
			inorderIdxMap.put(inorder[n], n);
		}

		findPre(0, N-1, 0, N-1);
		System.out.println(sb.toString());
		br.close();
	}

}
