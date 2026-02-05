package 백준.백준_10000_10999.백준_14719_빗물_G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_14719_빗물_G5_104ms {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		int answer = 0;
		
		int maxH = 0;
		boolean foundLeft = false;
		int left = 0, right = 0;
		
		int[] block = new int[W];
		st = new StringTokenizer(br.readLine());
		for(int w=0; w<W; w++) {
			block[w] = Integer.parseInt(st.nextToken());
			if(block[w] == 0) continue;

			if(!foundLeft) {
				foundLeft = true;
				left = w; // 시작
			}
			
			right = w;
			maxH = Math.max(maxH, block[w]); // 불필요한 높이까지 체크하지 않도록
		}
		
		for(int h=0; h<maxH; h++) {
			foundLeft = false;
			int l = 0, r = 0, cnt = 0;
			for(int w=left; w<=right; w++) {
				if(block[w] == 0) {
					cnt++;
					continue;
				}
				
				if(--block[w] == 0) continue; 
				
				if(!foundLeft) {
					foundLeft = true;
					l = w; // 시작
				}
				
				r = w;
			}
			
			left = l; right = r; answer += cnt;
		}
		
		System.out.println(answer);
		br.close();
		
		
	}

}
