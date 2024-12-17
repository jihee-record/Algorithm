package 백준.백준_10000_10999.백준_10775_공항_G2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_10775_공항_G2 {
	static int[] gate;
	
	static int find(int x) {
		if(gate[x] == x) return x;
		return gate[x] = find(gate[x]);
	}
	
	static void union(int x, int y) {
		gate[x] = y;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int result = 0;
		
		int G = Integer.parseInt(br.readLine()); //게이트수
		int P = Integer.parseInt(br.readLine()); //비행기수
		
		gate = new int[G+1]; // 0제외 1~ G칸에 비행기 배정
		
		for(int i=1; i<=G; i++) {
			gate[i] = i;
		}
		
		int max = Math.max(G, P); //어차피 최대 게이트 개수까지밖에 못받음
		for(int p=0; p<max; p++) {
			int n = Integer.parseInt(br.readLine());
			
			int g = find(n);
			
			// 할 데 없고
			if(g == 0) {
				break;
			}
			
			// 배정하고
			union(g, g-1);;
			result++;
			
		}
		System.out.println(result);
		br.close();
	}

}
