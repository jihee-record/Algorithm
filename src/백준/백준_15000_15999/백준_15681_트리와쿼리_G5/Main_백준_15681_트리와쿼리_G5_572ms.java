package 백준.백준_15000_15999.백준_15681_트리와쿼리_G5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_백준_15681_트리와쿼리_G5_572ms {
	static List<Integer>[] linkedNodes;  // index : Node number
	static int[] size;
	
	static void countSubtreeNodes(int currentNode) {
		size[currentNode] = 1; // 본인
		
		for(int node : linkedNodes[currentNode]) {
			// 자식 노드에서 부모 노드 제거 
			// 지금 자식이 부모가 되었을 때 자식의 자식 (손주)만 데려오게 됨
			linkedNodes[node].remove(Integer.valueOf(currentNode)); 
			
			countSubtreeNodes(node);
			size[currentNode] += size[node];
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 정점의 수
		int R = Integer.parseInt(st.nextToken()); // 루트 번호
		int Q = Integer.parseInt(st.nextToken()); // 쿼리 수
		
		linkedNodes = new ArrayList[N+1];
		size = new int[N+1];
		
		for(int n=1; n<=N; n++) {
			List<Integer> list = new ArrayList<>();
			linkedNodes[n] = list;
		}
		
		for(int n=1; n<N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			linkedNodes[u].add(v);
			linkedNodes[v].add(u);
		}
		
		countSubtreeNodes(R);
		
		for(int q=0; q<Q; q++) {
			int root = Integer.parseInt(br.readLine());
			sb.append(size[root]).append("\n");
		}
		
		System.out.println(sb.toString());
		br.close();
	}

}
