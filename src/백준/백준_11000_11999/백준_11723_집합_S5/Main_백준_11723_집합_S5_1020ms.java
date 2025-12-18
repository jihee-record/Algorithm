package 백준.백준_11000_11999.백준_11723_집합_S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_11723_집합_S5_1020ms {
	static StringBuilder sb;
	static boolean[] S;
	
	static void add(int x) {
		S[x] = true;
	}
	
	static void remove(int x) {
		S[x] = false;
	}
	
	static void check(int x) {
		if(S[x]) sb.append(1);
		else sb.append(0);
		
		sb.append('\n');
	}
	
	static void toggle(int x) {
		S[x] = !S[x];
	}
	
	static void all() {
		Arrays.fill(S, true);
	}
	
	static void empty() {
		Arrays.fill(S, false);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;
		
		S = new boolean[21];

		int M = Integer.parseInt(br.readLine());
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			switch(command) {
			case "add":
				add(Integer.parseInt(st.nextToken()));
				break;
			case "remove":
				remove(Integer.parseInt(st.nextToken()));
				break;
			case "check":
				check(Integer.parseInt(st.nextToken()));
				break;
			case "toggle":
				toggle(Integer.parseInt(st.nextToken()));
				break;
			case "all":
				all();
				break;
			case "empty":
				empty();
				break;
			}
		}
		
		System.out.println(sb);
		br.close();
	}

}
