package SWEA.SWEA_1000_1999.SWEA_1228_암호문1_D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_SWEA_1228_암호문1_D3_이지희_105ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int t=1; t<=10; t++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			List<String> list = new LinkedList<>();
			for(int n=0; n<N; n++) {
				list.add(st.nextToken());
			}
			
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int n=0; n<N; n++) {
				st.nextToken();
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				for(int i=x; i<x+y; i++) {
					list.add(i, st.nextToken());
				}
			}
			
			
			sb.append("#").append(t);
			for(int i=0; i<10; i++) {
				sb.append(" ").append(list.get(i));
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		br.close();
	}
}
