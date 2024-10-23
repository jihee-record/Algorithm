package 백준.백준_11000_11999.백준_11725_트리의부모찾기_S2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Main_백준_11725_트리의부모찾기_S2_1204ms {
	static Map<Integer, Node> nodeMap;
	static int[] parent;
	
	static class Node {
		int number;
		List<Node> linkedNodes;
		
		Node(int number){
			this.number = number;
			linkedNodes = new LinkedList<>();
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		parent = new int[N+1];
		parent[1] = 1;
		
		nodeMap = new HashMap<>();
		for(int n=1; n<=N; n++) {
			nodeMap.put(n, new Node(n));
		}
		
		for(int n=1; n<N; n++) {
			String[] input = br.readLine().split(" ");
			int number1 = Integer.parseInt(input[0]);
			int number2 = Integer.parseInt(input[1]);
			
			Node node1 = nodeMap.get(number1);
			Node node2 = nodeMap.get(number2);

			node1.linkedNodes.add(node2);
			node2.linkedNodes.add(node1);
		}
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(nodeMap.get(1));
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			for(Node linkedNode : node.linkedNodes) {
				if(parent[linkedNode.number] == 0) {
					parent[linkedNode.number] = node.number;
					queue.add(linkedNode);
				}
			}
		}
		
		for(int n=2; n<=N; n++) {
			System.out.println(parent[n]);
		}
		br.close();
	}
}
