package 백준.백준_3000_3999.백준_3584_가장가까운공통조상_G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_3584_가장가까운공통조상_G4_608ms {
	static int[] tree;
	static int[] degree;
	static int degA;
	
	static int findDegree(int a) {
		int parent = tree[a];
		if(parent != 0) {
			degA++;
			return findDegree(parent);
		}else {
			return degA; 
		}
	}
	
	static int findCommonAncestor(int a, int b) {
		int degreeA = degree[a];
		int degreeB = degree[b];
		int parentA = a;
		int parentB = b;
		
		if(degreeA > degreeB) {
			while(degreeA != degreeB) {
				parentA = tree[parentA]; 
				degreeA--;
			}
		}else if(degreeA < degreeB){
			while(degreeA != degreeB) {
				parentB = tree[parentB];
				degreeB--;
			}
		}
		
		while(parentA != parentB) {
			parentA = tree[parentA]; 
			parentB = tree[parentB];
		}
		
		return parentA;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			tree = new int[N+1];
			for(int i=1; i<N; i++) {
				String[] strArr = br.readLine().split(" "); // 간선
				int A = Integer.parseInt(strArr[0]);
				int B = Integer.parseInt(strArr[1]);
				tree[B] = A;
			}
			
			degree = new int[N+1];
			for(int i=1; i<=N; i++) {
				degA = 0;
				degree[i] = findDegree(i);
			}
			
			String[] strArr = br.readLine().split(" "); // 찾을 노드
			int A = Integer.parseInt(strArr[0]);
			int B = Integer.parseInt(strArr[1]);
			System.out.println(findCommonAncestor(A, B));
		}
		br.close();
	}
}
