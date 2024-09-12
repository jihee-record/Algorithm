package 백준.백준_1000_1999.백준_1976_여행가자_G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_백준_1976_여행가자_G4_116ms {
	static int[] parent;
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x == y) return;
		if(x < y) parent[y] = x;
		else parent[x] = y;
	}
	
	static int find(int x) {
		if(x == parent[x]) return x;
		x = parent[x];
		return find(parent[x]);
	}
	
	public static void main(String[] args) throws IOException{
		boolean trip = true;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		parent = new int[N+1];
		for(int i=1; i<=N; i++) {
			parent[i] = i;
		}
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=1; j<i; j++) {
				if(st.nextToken().equals("1")) {
					union(i, j);
				}
			}
		}
		
		List<Integer> list = new ArrayList<>();
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<M; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		for(int i=1; i<M; i++) {
			if(find(list.get(i)) != find(list.get(i-1))) {
				trip = false;
				break;
			}
		}
		
		if(trip) System.out.println("YES");
		else System.out.println("NO");
		br.close();
	}
}