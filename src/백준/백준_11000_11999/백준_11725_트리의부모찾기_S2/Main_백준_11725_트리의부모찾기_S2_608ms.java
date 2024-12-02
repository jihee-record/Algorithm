package 백준.백준_11000_11999.백준_11725_트리의부모찾기_S2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_백준_11725_트리의부모찾기_S2_608ms {
	static List<Integer>[] linkedNodes;
	static int[] parentNode;
	
	static void findParent(int currentNode, int parent) {
		for(int node : linkedNodes[currentNode]) {
			if(node != parent) {
				parentNode[node] = currentNode;
				findParent(node, currentNode);
			}
		}
	}
	
	
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		linkedNodes = new ArrayList[N+1];
		parentNode = new int[N+1];
		
		for(int n=1; n<=N; n++) {
			linkedNodes[n] = new ArrayList<>();
		}
		
		for(int n=1; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			linkedNodes[u].add(v);
			linkedNodes[v].add(u);
		}
		
		findParent(1, 0);
		
		for(int n=2; n<=N; n++) {
			sb.append(parentNode[n]).append("\n");
		}
		
		System.out.println(sb.toString());
		br.close();
	}
}
