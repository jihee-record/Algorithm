package SWEA.SWEA_Event.No2_SSAFY에간임스;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution_No2_SSAFY에간임스_tree {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		Map<Integer, TreeSet<String>> map = new TreeMap<>(); 
		int N = Integer.parseInt(br.readLine());
		
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			String skill = st.nextToken();
			int order = Integer.parseInt(st.nextToken());
			if(map.containsKey(order)) {
				map.get(order).add(skill);
			}else {
				TreeSet<String> set = new TreeSet<>();
				set.add(skill);
				map.put(order, set);
			}
		}
		
		for(int n=0; n<N; n++) {
			TreeSet<String> set = map.get(n);
			if(set.size() == 1) {
				sb.append(set.pollFirst()).append("\n");
			} else {
				for(String skill : set) {
					sb.append(skill).append("\n");
				}
			}
		}
		System.out.println(sb.toString());
		br.close();
	}

}
