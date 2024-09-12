package 백준.백준_10000_10999.백준_10816_숫자카드2_S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main_백준_10816_숫자카드2_S4_1136ms_hash {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] cardN = br.readLine().split(" ");
		int m = Integer.parseInt(br.readLine());
		String[] cardM = br.readLine().split(" ");
		
		HashMap<String, Integer> hashMap = new HashMap<>(); 
		for(int i=0; i<n; i++) {
			String key = cardN[i]; 
			hashMap.put(key, hashMap.getOrDefault(key, 0)+1);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<m; i++) {
			sb.append(hashMap.getOrDefault(cardM[i], 0) + " ");
		}
		
		System.out.println(sb);
		br.close();
	}
}
