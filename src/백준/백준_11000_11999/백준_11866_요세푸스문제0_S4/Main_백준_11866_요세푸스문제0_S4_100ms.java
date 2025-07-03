package 백준.백준_11000_11999.백준_11866_요세푸스문제0_S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_백준_11866_요세푸스문제0_S4_100ms {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		sb.append("<");
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int n=1; n<=N; n++) {
			list.add(n);
		}
		
		int idx = 0;
		while(true) {
			idx = ((idx + K - 1) % list.size());
			sb.append(list.remove(idx));
			
			if(list.isEmpty()) break; 
			sb.append(", ");
		}
		
		sb.append(">");
		System.out.println(sb.toString());
		br.close();
		
	}

}
