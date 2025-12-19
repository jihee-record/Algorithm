package 백준.백준_1000_1999.백준_1991_트리순회_S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

// 트리 - 프리오더, 인오더, 포스트오더
public class Main_백준_1991_트리순회_S1_100ms {
	static StringBuilder sb;
	static int N;
	
	static class Node {
		char value;
		char left;
		char right;
		
		Node(){}
		Node(char value){
			this.value = value;
		}
	}
	
	static void pre(HashMap<Character, Node> tree, Node node) {
		sb.append(node.value);
		if(node.left != '.') pre(tree, tree.get(node.left));
		if(node.right != '.') pre(tree, tree.get(node.right));
	}
	
	static void inorder(HashMap<Character, Node> tree, Node node) {
		if(node.left != '.') inorder(tree, tree.get(node.left));
		sb.append(node.value);
		if(node.right != '.') inorder(tree, tree.get(node.right));
	}
	
	static void post(HashMap<Character, Node> tree, Node node) {
		if(node.left != '.') post(tree, tree.get(node.left));
		if(node.right != '.') post(tree, tree.get(node.right));
		sb.append(node.value);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine()); // 노드개수
		HashMap<Character, Node> tree = new HashMap<>();
		
		for(int n=0; n<N; n++) {
			String input = br.readLine();
			char value = input.charAt(0);
			
			Node node = new Node(input.charAt(0));
			node.left = input.charAt(2);
			node.right = input.charAt(4);;
			
			tree.put(value, node);
		}
		
		// pre
		pre(tree, tree.get('A'));
		sb.append("\n");
		
		// inorder
		inorder(tree, tree.get('A'));
		sb.append("\n");
		
		// postorder
		post(tree, tree.get('A'));
		
		System.out.println(sb);
		br.close();
	}

}
