package 백준.백준_9000_9999.백준_9093_단어뒤집기_B1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_9093_단어뒤집기_B1_468ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		while(N --> 0) {
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				String str = st.nextToken();
				for(int n=str.length()-1; n>=0; n--) {
					sb.append(str.charAt(n));
				}
				sb.append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}

}
