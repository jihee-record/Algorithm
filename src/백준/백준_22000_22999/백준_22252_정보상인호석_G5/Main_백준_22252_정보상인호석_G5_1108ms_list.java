package 백준.백준_22000_22999.백준_22252_정보상인호석_G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main_백준_22252_정보상인호석_G5_1108ms_list {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long result = 0;

		HashMap<String, List<Integer>> info = new HashMap<>();
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String type = st.nextToken();
			String keyword = st.nextToken();
			int count = Integer.parseInt(st.nextToken());
			if(type.equals("1")) {
				List<Integer> list = info.getOrDefault(keyword, new ArrayList<>());
                for (int j = 0; j < count; j++) {
                	list.add(Integer.parseInt(st.nextToken()));
                }
                Collections.sort(list, Collections.reverseOrder());
                info.put(keyword, list);
			}else {
				List<Integer> list = info.get(keyword);
				if(list == null) continue;
				for (int j = 0; j < count && !list.isEmpty(); j++) {
                    result += list.remove(0);
                }
			}
		}
		
		System.out.println(result);
		br.close();
	}
}
