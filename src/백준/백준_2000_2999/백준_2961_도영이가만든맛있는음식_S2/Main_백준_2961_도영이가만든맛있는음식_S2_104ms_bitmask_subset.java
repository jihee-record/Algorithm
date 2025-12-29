package 백준.백준_2000_2999.백준_2961_도영이가만든맛있는음식_S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2961_도영이가만든맛있는음식_S2_104ms_bitmask_subset {
	static class Food {
		int sour, bitter;
		
		Food(int sour, int bitter){
			this.sour = sour;
			this.bitter = bitter;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 1<=N<=10
		Food[] food = new Food[N]; 
		
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			
			int sour = Integer.parseInt(st.nextToken());
			int bitter = Integer.parseInt(st.nextToken());
			
			food[n] = new Food(sour, bitter);
		}
		
		int midDiff = 1000000000; // INF
		
		for(int mask = 1; mask < (1 << N); mask++) { // 0 제외 ( 미선택 경우 없음 ), 부분집합 2^N개
			int totalSour = 1;
			int totalBitter = 0;
			
			for(int i=0; i<N; i++) { // N개 선택에 따라
				if((mask & (1 << i)) != 0) { // mask에서 선택 여부 확인
					totalSour *= food[i].sour;
					totalBitter += food[i].bitter;
				}
			}
			
			midDiff = Math.min(Math.abs(totalSour - totalBitter), midDiff);
		}
		
		System.out.println(midDiff);
		br.close();
	}

}
