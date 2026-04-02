package 백준.백준_2000_2999.백준_2866_문자열잘라내기_G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_백준_2866_문자열잘라내기_G5_284ms_bottomup {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] word = new String[N];
		for(int n=0; n<N; n++) word[n] = br.readLine();
		
		String[] anagram = new String[M];
		
		for(int m=0; m<M; m++) {
			StringBuilder sb = new StringBuilder();
			for(int n=0; n<N; n++) sb.append(word[n].charAt(m));
			anagram[m] = sb.toString();
		}
		
		outloop:
		for(int n=N-1; n>0; n--) {
			HashSet<String> set = new HashSet<>();
			for(int m=0; m<M; m++) {
				String subW = anagram[m].substring(n);
				if (!set.add(subW)) continue outloop;
			}
			System.out.println(n);
			return;
		}
		
		System.out.println(0);
		br.close();
	}

}
