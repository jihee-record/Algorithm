package 백준.백준_11000_11999.백준_11279_최대힙_S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_백준_11279_최대힙_S2_292ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
		
		for(int n=0; n<N; n++) {
			int x = Integer.parseInt(br.readLine());
			
			if(x == 0) {
				if(pq.isEmpty()) sb.append("0\n");
				else sb.append(pq.poll()).append("\n");
			}else {
				pq.add(x);
			}
		}
		
		System.out.println(sb.toString());
		br.close();
	}

}
