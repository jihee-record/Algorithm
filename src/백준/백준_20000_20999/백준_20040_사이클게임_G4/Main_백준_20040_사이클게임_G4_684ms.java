package 백준.백준_20000_20999.백준_20040_사이클게임_G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_20040_사이클게임_G4_684ms {
	static int[] parent;
	static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if(x < y) parent[y] = x;
		else if(x > y) parent[x] = y;
	}
	
	static int find(int x) {
		if(x == parent[x]) return x;
		return parent[x] = find(parent[x]);
	}
	

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int result = 0;
        
        parent = new int[n];
        for(int i=1; i<n; i++) {
        	parent[i] = i;
        }
        
        for(int i=1; i<=m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if(find(a) == find(b)) {
            	result = i;
            	break;
            }else {
            	union(a, b);
            }
        }
        
        System.out.println(result);
        br.close();
    }
}