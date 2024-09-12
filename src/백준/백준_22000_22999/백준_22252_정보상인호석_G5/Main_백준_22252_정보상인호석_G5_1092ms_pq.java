package 백준.백준_22000_22999.백준_22252_정보상인호석_G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_백준_22252_정보상인호석_G5_1092ms_pq {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long result = 0;

		HashMap<String, PriorityQueue<Integer>> info = new HashMap<>();
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String type = st.nextToken();
			String keyword = st.nextToken();
			int count = Integer.parseInt(st.nextToken());
			if(type.equals("1")) {
				PriorityQueue<Integer> pq = info.getOrDefault(keyword, new PriorityQueue<>((a, b) -> Integer.compare(b, a)));
                for (int j = 0; j < count; j++) {
                    pq.add(Integer.parseInt(st.nextToken()));
                }
                info.put(keyword, pq);
			}else {
				PriorityQueue<Integer> pq = info.get(keyword);
				if(pq == null) continue;
				for (int j = 0; j < count && !pq.isEmpty(); j++) {
                    result += pq.poll();
                }
			}
		}
		
		System.out.println(result);
		br.close();
	}
}
