package 백준.백준_14000_14999.백준_14425_문자열집합_S4;

import java.io.*;
import java.util.HashSet;

public class Main_백준_14425_문자열집합_S4_284ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputCnt = br.readLine().split(" ");
		int n = Integer.parseInt(inputCnt[0]);
		int m = Integer.parseInt(inputCnt[1]);
		
		HashSet<String> hash = new HashSet<>();
		for(int i=0; i<n; i++) {
			hash.add(br.readLine());
		}
		
		int result = 0;
		for(int i=0; i<m; i++) {
			if(hash.contains(br.readLine())) {
				result++;
			}
		}
		
		System.out.println(result);
		br.close();
	}
}
