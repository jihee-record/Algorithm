package 백준.백준_2000_2999.백준_2866_문자열잘라내기_G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_백준_2866_문자열잘라내기_G5_280ms_binary {
	
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
		
		int l = 0, r = N-1;
		int cnt = N-1;
		outloop:
		while(l <= r) {
			int mid = l + (r - l) / 2;
			HashSet<String> set = new HashSet<>();
			for(int m=0; m<M; m++) {
				String subW = anagram[m].substring(mid);
				if (!set.add(subW)) {
					r = mid - 1;
					continue outloop;
				}
			}
			
			cnt = mid;
			l = mid + 1;
		}
		
		System.out.println(cnt);
		br.close();
	}

}
