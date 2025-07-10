package 백준.백준_11000_11999.백준_11399_ATM_S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main_백준_11399_ATM_S4_116ms {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		TreeSet<Integer> set = new TreeSet<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n=0; n<N; n++) {
			int time = Integer.parseInt(st.nextToken());
			set.add(time);
			map.put(time, map.getOrDefault(time, 0) + 1);
		}
		
		int result = 0;
		for(int s : set) {
			for(int i=0; i<map.get(s); i++) {
				result += (s * (N--));
			}
		}
		
		System.out.println(result);
		br.close();
		
	}

}
