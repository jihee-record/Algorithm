package 백준.백준_1000_1999.백준_1182_부분수열의합_S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_백준_1182_부분수열의합_S2_132ms {
	
	static List<Integer> list;
	static int S, cnt;
	
	static void check(int idx, int sum) {
		if(idx == list.size()) {
			if(sum == S) cnt++;
			return;
		}
		
		check(idx+1, sum);
		check(idx+1, sum + list.get(idx));
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		st.nextToken();
		S = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			int k = Integer.parseInt(st.nextToken());
			list.add(k);
		}
		
		check(0, 0);
		if(S == 0) cnt--;
		
		System.out.println(cnt);
		br.close();
	}

}
