package 백준.백준_7000_7999.백준_7568_덩치_S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_7568_덩치_S5_104ms {
	static class Person{
		int w;  // 몸무게
		int h; // 키
		
		Person(int w, int h){
			this.w = w;
			this.h = h;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Person[] p = new Person[N];
		
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			p[n] = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		for(int i=0; i<N; i++) {
			int count = 1;
			for(int j=0; j<N; j++) {
				if(i == j) continue;
				if(p[i].w < p[j].w && p[i].h < p[j].h) count++;
			}
			sb.append(count).append(" ");
		}
		
		System.out.println(sb.toString());
		br.close();
	}

}
