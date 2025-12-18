package 백준.백준_11000_11999.백준_11723_집합_S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_11723_집합_S5_968ms {
	static StringBuilder sb;
	static int S;
	
	static void add(int x) {
		S |= (1 << (x-1));
	}
	
	static void remove(int x) {
		S &= ~(1 << (x-1));
	}
	
	static void check(int x) {
		if((S & (1 << (x-1))) != 0) sb.append(1);
		else sb.append(0);
		
		sb.append('\n');
	}
	
	static void toggle(int x) {
		S ^= (1 << (x-1));
	}
	
	static void all() {
		S = 1048575; // (1 << 20) -1
	}
	
	static void empty() {
		S = 0;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;
		
		S = 0;

		int M = Integer.parseInt(br.readLine());
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			switch(command.charAt(0)) {
			case 'a':
				if(!st.hasMoreTokens()) all();
				else add(Integer.parseInt(st.nextToken()));
				break;
			case 'r':
				remove(Integer.parseInt(st.nextToken()));
				break;
			case 'c':
				check(Integer.parseInt(st.nextToken()));
				break;
			case 't':
				toggle(Integer.parseInt(st.nextToken()));
				break;
			case 'e':
				empty();
				break;
			}
		}
		
		System.out.print(sb);
		br.close();
	}

}
