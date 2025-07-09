package 백준.백준_11000_11999.백준_11047_동전0_S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_11047_동전0_S4_104ms {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int count = 0;
		
		int[] coin = new int[N];
		for(int n=0; n<N; n++) {
			coin[n] = Integer.parseInt(br.readLine());
		}
		
		while(K > 0) {
			count += (K/coin[--N]);
			K %= coin[N];
		}
		
		System.out.println(count);
		br.close();
		
	}

}
