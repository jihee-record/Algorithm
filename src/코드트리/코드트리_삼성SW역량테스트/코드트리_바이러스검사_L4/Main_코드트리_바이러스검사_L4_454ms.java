package 코드트리.코드트리_삼성SW역량테스트.코드트리_바이러스검사_L4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_코드트리_바이러스검사_L4_454ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] customers = new int[N];
		for(int n=0; n<N; n++) {
			customers[n] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int leader = Integer.parseInt(st.nextToken());
		int member = Integer.parseInt(st.nextToken());
		
		long cnt = 0;
		for(int n=0; n<N; n++) {
			cnt ++;
			if(customers[n] <= leader) continue;
			cnt += (customers[n] - leader + member - 1) / member;
		}
		
		System.out.println(cnt);
		br.close();
	}

}
