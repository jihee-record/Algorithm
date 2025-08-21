package 백준.백준_16000_16999.백준_16194_카드구매하기2_S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_16194_카드구매하기2_S1_128ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] price = new int[N+1];
		for(int n=1; n<=N; n++) {
			price[n] = Integer.parseInt(st.nextToken());
			for(int k=1; k<n; k++) {
				price[n] = Math.min(price[n], price[n-k] + price[k]);
			}
		}
		
		System.out.println(price[N]);
		br.close();
	}

}
