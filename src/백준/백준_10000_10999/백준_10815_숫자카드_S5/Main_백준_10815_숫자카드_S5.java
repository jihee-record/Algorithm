package 백준.백준_10000_10999.백준_10815_숫자카드_S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_백준_10815_숫자카드_S5 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		Set<Integer> cards = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		
		for(int n=0; n<N; n++) {
			cards.add(Integer.parseInt(st.nextToken()));
		}
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		for(int m=0; m<M; m++) {
			if(cards.contains(Integer.parseInt(st.nextToken()))) {
				sb.append("1 ");
			}else {
				sb.append("0 ");
			}
		}
		
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
		br.close();
	}

}
