package 백준.백준_7000_7999.백준_7785_회사에있는사람_S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main_백준_7785_회사에있는사람_S5 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		Set<String> set = new TreeSet<>();
		
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			if(st.nextToken().equals("enter")) {
				set.add(name);
			}else {
				set.remove(name);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		
		
		
		
		br.close();
	}
}
