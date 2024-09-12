package 백준.백준_1000_1999.백준_1717_집합의표현_G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1717_집합의표현_G5_592ms {
	static int[] parent;
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if(x < y) parent[y] = x;
		else if(x > y) parent[x] = y;
	}
	
	static int find(int x) {
		if(x == parent[x]) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		parent = new int[n+1];
		for(int i=1; i<=n; i++) {
			parent[i]=i;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int operation = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if(operation == 0) { 
				union(x, y);
			}else if(find(x) == find(y)) {
				sb.append("YES\n");
			}else {
				sb.append("NO\n");
			}
		}
		
		System.out.println(sb);
		br.close();
	}
}