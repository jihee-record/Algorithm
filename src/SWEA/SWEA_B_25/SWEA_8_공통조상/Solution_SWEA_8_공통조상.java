package SWEA.SWEA_B_25.SWEA_8_공통조상;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_SWEA_8_공통조상 {
	static Node[] tree;
	static class Node{
		int me;
		int parent;
		LinkedList<Node> sons;
		
		public Node(){
			this.sons = new LinkedList<>();
		}
	}
	
	static List<Integer> findAncestors(Node node) {
		List<Integer> list = new ArrayList<>();
		
		while(node.me != 1) {
			node = tree[node.parent];
			list.add(node.me);
		}
		
		return list;
	}
	
	static int findLCA(List<Integer> A, List<Integer> B) {
		List<Integer> low = A;
		Set<Integer> high = new HashSet<>();
		
		if(A.size() > B.size()) {
			low = B;
			high.addAll(A);
		}else {
			high.addAll(B);
		}
		
		for(int i=0; i<low.size(); i++) {
			if(high.contains(low.get(i))) {
				return low.get(i);
			}
		}
		
		return 0;
	}
	
	static int findTreeSize(int n) { //서브트리 크기 찾기
		int result = 0;
		
		Node node = tree[n];
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		while(!queue.isEmpty()) {
			result++;
			Node now = queue.poll();
			queue.addAll(now.sons);
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			
			
			int V = Integer.parseInt(st.nextToken()); // 정점 수
			int E = Integer.parseInt(st.nextToken()); // 간선
			int a = Integer.parseInt(st.nextToken()); // 자손1
			int b = Integer.parseInt(st.nextToken()); // 자손2
			
			tree =  new Node[V+1]; 
			for(int v=1; v<=V; v++) {
				tree[v] = new Node();
			}
			
			tree[1].parent = 1;
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int e=0; e<E; e++) {
				int parent = Integer.parseInt(st.nextToken());
				int son = Integer.parseInt(st.nextToken());
				Node node = tree[parent];
				node.me = parent;
				node.sons.add(tree[son]);
				tree[son].parent = parent;
			}
			
			int common = 0;
			if(a == b) {
				common = a;
			}else {
				List<Integer> ancestorsA = findAncestors(tree[a]);
				List<Integer> ancestorsB = findAncestors(tree[b]);
				common = findLCA(ancestorsA, ancestorsB);
			}
			
			sb.append(common).append(" ").append(findTreeSize(common)).append("\n");
		}
		
		System.out.println(sb.toString());
		br.close();
	}

}
