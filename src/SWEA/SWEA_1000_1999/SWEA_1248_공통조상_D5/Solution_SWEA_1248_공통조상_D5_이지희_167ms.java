package SWEA.SWEA_1000_1999.SWEA_1248_공통조상_D5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_SWEA_1248_공통조상_D5_이지희_167ms {
	
	static class TreeNode {
		int value;
		TreeNode parent;
		List<TreeNode> children;

	    TreeNode(int value) {
	        this.value = value;
	        this.parent = null;
	        this.children = new ArrayList<>();
	    }
	}
	
	static Map<Integer, TreeNode> nodes; // key : node 번호, value : TreeNode 객체
	
	/**
	 * 가장 가까운 공통 조상 찾기
	 * @param node1
	 * @param node2
	 * @return 라인 타고 올라가다가 함께 만난 첫번째 조상
	 */
	static TreeNode findLowestCommonAncestor(TreeNode node1, TreeNode node2) {
		Set<TreeNode> ancestors = new HashSet<>();
		while(node1 != null) { // 루트에 도달할 때까지 올라가기
			ancestors.add(node1);
			node1 = node1.parent;
		}
		
		while(node2 != null) { // 공통 조상을 찾을 때까지 올라가기
			if(ancestors.contains(node2)) { // 찾았으면 리턴
				return node2;
			}
			node2 = node2.parent; // 못찾았으면 올라가
		}
		
		return null;
	}
	
	/**
	 * 서브트리의 노드 수 구하기
	 * @param root 서브트리의 뿌리
	 * @return 서브트리의 노드 수
	 */
	static int countSubtreeNodes(TreeNode root) {
		int count = 1; // 나다. 뿌리.
		for(TreeNode child : root.children) {
			count += countSubtreeNodes(child); // 내새끼들의 새끼들도 세어줘야함
		}
		
		return count;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
	
		int T = Integer.parseInt(br.readLine()); //테스트 케이스
		
		// 테스트 반복
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int V = Integer.parseInt(st.nextToken()); // 정점의 개수
			int E = Integer.parseInt(st.nextToken()); // 간선의 개수 = (정점-1)
			int A = Integer.parseInt(st.nextToken()); // 공통 조상을 찾는 정점1
			int B = Integer.parseInt(st.nextToken()); // 공통 조상을 찾는 정점2
			
			nodes = new HashMap<>();
			for(int v=1; v<=V; v++) {
				nodes.put(v, new TreeNode(v));
			}
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int e=1; e<=E; e++) {
				int parent = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());
				TreeNode parentNode = nodes.get(parent);
				TreeNode childNode = nodes.get(child);
				parentNode.children.add(childNode);
				childNode.parent = parentNode;
			}
			
			TreeNode ancestor = findLowestCommonAncestor(nodes.get(A), nodes.get(B));
			int count = countSubtreeNodes(ancestor);
			
			sb.append("#").append(t).append(" ").append(ancestor.value).append(" ").append(count).append("\n");
		} // 테스트 반복 종료
		
		System.out.println(sb.toString());
		br.close();
	}//main()
}//class()
