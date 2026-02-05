package 백준.백준_10000_10999.백준_14719_빗물_G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_14719_빗물_G5_96ms {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		int answer = 0;
		
		st = new StringTokenizer(br.readLine());
		int[] h = new int[W];
		for(int w=0; w<W; w++) h[w] = Integer.parseInt(st.nextToken());
		
		if(W <= 2) {
			System.out.println(0);
			return;
		}
		
		int l = 0, r = W - 1;
		int maxL = 0, maxR = 0;
		
		// 한 칸씩 빗물을 얼마나 가둘 수 있는지 보는거니까. 저 멀리라도 양쪽이 막히기만 하면 됨
		while(l < r) {
			if(h[l] <= h[r]) { // 오른쪽이 막혀 있음
				if(h[l] >= maxL) maxL = h[l]; // 왼쪽으로 빗물이 흐름
				else answer += maxL - h[l]; // 왼쪽에 더 높은 벽이 있어서 사이로 빗물이 고임
				l++;
				
			} else { // 왼쪽이 막혀 있음
				if(h[r] >= maxR) maxR = h[r];
				else answer += maxR - h[r];
				r--;
			}
		}
		
		System.out.println(answer);
		br.close();
		
		
	}

}
