package 백준.백준_2000_2999.백준_2566_최댓값_B3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2566_최댓값_B3_이지희_64ms {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int max = 0;
		int row = 0;
		int col = 0;
		for(int i=1; i<10; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=1; j<10; j++) {
				int k = Integer.parseInt(st.nextToken());
				if(k >= max) {
					max = k;
					row = i;
					col = j;
				}
			}
		}
		
		sb.append(max).append("\n").append(row).append(" ").append(col).append("\n");
		System.out.println(sb.toString());
	}

}
