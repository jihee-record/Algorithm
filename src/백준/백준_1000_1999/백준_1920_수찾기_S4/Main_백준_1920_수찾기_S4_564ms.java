package 백준.백준_1000_1999.백준_1920_수찾기_S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_백준_1920_수찾기_S4_564ms {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Set<Integer> exist = new HashSet<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n=0; n<N; n++) {
			exist.add(Integer.parseInt(st.nextToken()));
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int m=0;  m<M; m++) {
			sb.append(exist.contains(Integer.parseInt(st.nextToken())) ? 1 : 0).append("\n");
		}
		
		System.out.println(sb.toString());
		br.close();
		
	}

}
