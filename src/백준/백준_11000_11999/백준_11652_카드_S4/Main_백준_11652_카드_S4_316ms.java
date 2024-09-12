package 백준.백준_11000_11999.백준_11652_카드_S4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main_백준_11652_카드_S4_316ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Map<Long, Integer> map = new HashMap<>();
		for(int n=0; n<N; n++) {
			long k = Long.parseLong(br.readLine());
			if(map.containsKey(k)) map.put(k, map.get(k)+1);
			else map.put(k, 1);
		}
		
		long number = Long.MAX_VALUE;
		int count = 0;
		for(long key : map.keySet()) {
			int keyCount = map.get(key);  
			if(keyCount > count) {
				count = keyCount;
				number = key;
			} else if(keyCount == count) {
				number = Math.min(key, number);
			}
		}
		
		System.out.println(number);
		br.close();
	}
}
