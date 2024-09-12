package 백준.백준_10000_10999.백준_10816_숫자카드2_S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_10816_숫자카드2_S4_1208ms_array {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] cardN = br.readLine().split(" ");
		int m = Integer.parseInt(br.readLine());
		String[] cardM = br.readLine().split(" ");
		
		//-10000000<=n<=10000000, 0<=n+10000000<=20000000  
		int[] cntN = new int[20000001];
		for(int i=0; i<n; i++) {
			cntN[Integer.parseInt(cardN[i])+10000000]++;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<m; i++) {
			sb.append(cntN[Integer.parseInt(cardM[i])+10000000] + " ");
		}
		
		System.out.println(sb);
		br.close();
	}
}
