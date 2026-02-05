package 백준.백준_10000_10999.백준_14719_빗물_G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_14719_빗물_G5_fail {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		int answer = 0;
		
		st = new StringTokenizer(br.readLine());
		int maxHIdx = 0;
		int maxH = Integer.parseInt(st.nextToken()); // 첫번째 높이
		int block = 0;
		for(int w=1; w<W; w++) {
			int h = Integer.parseInt(st.nextToken());
			
			if(h >= maxH) { // 정산, 갱신 // min(h, maxH) = maxH
				answer += (w - maxHIdx - 1) * maxH - block; // 발생 면적 - 블록
				block = 0; // 블록 초기화
				maxHIdx = w;
				maxH = h;
			}else {
				block += h;
			}
			
			if(w == W-1 && maxHIdx != w) { // 마지막 채우기
				answer += h * (w - maxHIdx) - block; // 마지막 블록까지 포함돼있어서 가로 길이 -1 필요없음
			}
		}
		
		System.out.println(answer);
		br.close();
		
		
	}

}
