package 백준.백준_15000_15999.백준_15681_트리와쿼리_G5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_백준_15681_트리와쿼리_G5_544ms {
    static List<Integer>[] linkedNodes;  // index : Node number
	static int[] size;
	
	static int countSubtreeNodes(int currentNode, int parent) {
	    size[currentNode] = 1;  // 본인 포함
	
	    for (int node : linkedNodes[currentNode]) {
	        if (node != parent) {  // 부모 노드는 건너뛰기
	            size[currentNode] += countSubtreeNodes(node, currentNode);
	        }
	    }
	    return size[currentNode];
    }
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    StringTokenizer st = new StringTokenizer(br.readLine());
	
	    int N = Integer.parseInt(st.nextToken()); // 정점의 수
	    int R = Integer.parseInt(st.nextToken()); // 루트 번호
	    int Q = Integer.parseInt(st.nextToken()); // 쿼리 수
	
	    linkedNodes = new ArrayList[N + 1];
	    size = new int[N + 1];
	
	    for (int n = 1; n <= N; n++) {
	        linkedNodes[n] = new ArrayList<>();
	    }
	
	    for (int n = 1; n < N; n++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        int u = Integer.parseInt(st.nextToken());
	        int v = Integer.parseInt(st.nextToken());
	
	        linkedNodes[u].add(v);
	        linkedNodes[v].add(u);
	    }
	
	    countSubtreeNodes(R, -1);
	
	    for (int q = 0; q < Q; q++) {
	        int root = Integer.parseInt(br.readLine());
	        sb.append(size[root]).append("\n");
	    }
	
	    System.out.println(sb.toString());
	    br.close();
	}

}
