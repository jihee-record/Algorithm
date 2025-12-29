package 백준.백준_2000_2999.백준_2961_도영이가만든맛있는음식_S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2961_도영이가만든맛있는음식_S2_100ms_bitmask {
	static int N, midDiff;
	static Food[] food;
	
	static class Food {
		int sour, bitter;
		
		Food(int sour, int bitter){
			this.sour = sour;
			this.bitter = bitter;
		}
	}
	
	
	static void calcul(int idx, int selected, int totalSour, int totalBitter) {
		if(idx == N) {
			if(selected != 0) {
				midDiff = Math.min(Math.abs(totalSour - totalBitter), midDiff);
			}
			return;
		}
		
		calcul(idx + 1, selected | (1 << (idx + 1)), totalSour * food[idx].sour, totalBitter + food[idx].bitter);
		calcul(idx + 1, selected, totalSour, totalBitter);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 1<=N<=10
		food = new Food[N]; 
		
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			
			int sour = Integer.parseInt(st.nextToken());
			int bitter = Integer.parseInt(st.nextToken());
			
			food[n] = new Food(sour, bitter);
		}
		
		midDiff = 1000000000; // INF
		calcul(0, 0, 1, 0);
		
		System.out.println(midDiff);
		br.close();
	}

}
