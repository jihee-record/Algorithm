package 백준.백준_1000_1999.백준_1764_듣보잡_S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Main_백준_1764_듣보잡_S4_208ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] caseArr = br.readLine().split(" ");
		int n = Integer.parseInt(caseArr[0]);
		int m = Integer.parseInt(caseArr[1]);
		HashSet<String> set = new HashSet<>();
		List<String> result = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<n; i++) {
			set.add(br.readLine());
		}
		
		for(int i=0; i<m; i++) {
			String name = br.readLine();
			if(set.contains(name)) {
				result.add(name);
			}
		}
		
		Collections.sort(result);
		int size = result.size();
		sb.append(size).append("\n");
		for(int i=0; i<size; i++) {
			sb.append(result.get(i)).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
}