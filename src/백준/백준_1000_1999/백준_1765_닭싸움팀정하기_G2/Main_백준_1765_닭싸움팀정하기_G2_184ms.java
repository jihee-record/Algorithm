package 백준.백준_1000_1999.백준_1765_닭싸움팀정하기_G2;

import java.io.*;
import java.util.*;

// Union-Find : disjoint set
public class Main_백준_1765_닭싸움팀정하기_G2_184ms {
	static int[] parent;
	static Set<Integer>[] enemies; 
	
	// union
	static void friend(int x, int y) {
		x = find(x);
		y = find(y);
        
		if(x == y) return ;
		
		if(x < y) parent[y] = x;
		else parent[x] = y;
	}
	
	static int find(int x) {
		if(x == parent[x]) 
			return x;
		
		return parent[x] = find(parent[x]);
	}
	
	// transitivity union
	// person : 나, target : 적
	static void enemy(int person, int target) {
		// 적의 적은 나의 친구
		for(int e : enemies[target]) {
			friend(person, e);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		parent = new int[N+1];		
		enemies = (Set<Integer>[]) new HashSet[N + 1];
		
		for(int i=1; i<=N; i++) {
			parent[i]=i;
			enemies[i] = new HashSet<>();
		}
		
		int M = Integer.parseInt(br.readLine());
		
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if(command.equals("F")) {
				friend(x, y);
				
			} else {
				enemy(x, y);
				enemy(y, x);
				enemies[x].add(y);
				enemies[y].add(x);
			}
		}
		
		Set<Integer> set = new HashSet<>();
		for(int i=1; i<=N; i++) {
			set.add(find(i));
		}
		
		System.out.println(set.size());
		br.close();
	}

}