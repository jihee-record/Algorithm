package 백준.백준_10000_10999.백준_10430_나머지_B5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_10430_나머지_B5_104ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int ans1 = (A + B) % C;
		int ans2 = (A * B) % C;
		
		sb.append(ans1).append('\n');
		sb.append(ans1).append('\n');
		sb.append(ans2).append('\n');
		sb.append(ans2).append('\n');
		System.out.print(sb);
		br.close();
	}

}
