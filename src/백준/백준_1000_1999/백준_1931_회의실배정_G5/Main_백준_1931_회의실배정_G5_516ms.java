package 백준.백준_1000_1999.백준_1931_회의실배정_G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_백준_1931_회의실배정_G5_516ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		List<int[]> list = new ArrayList<>();
		
		while(N --> 0) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int finish = Integer.parseInt(st.nextToken());
			list.add(new int[] {start, finish});
		}
		
		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				if(a[1] == b[1]) return a[0] - b[0];
				return a[1] - b[1];
			}
		});
		
		int cnt = 0;
		int finish = 0;
		for(int[] now : list) {
			if(now[0] < finish) continue;
			finish = now[1];
			cnt++;
		}
		
		System.out.println(cnt);
		br.close();
	}

}
