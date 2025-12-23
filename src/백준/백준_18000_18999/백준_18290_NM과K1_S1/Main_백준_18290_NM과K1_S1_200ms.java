package 백준.백준_18000_18999.백준_18290_NM과K1_S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_18290_NM과K1_S1_200ms {
	static int N, M, K;
	static int[][] arr, select;
	static int maxSum;
	
	// 오른쪽 방향으로 - 오른쪽 끝에 다다르면 행 아래로 내려감
	static void calcul(int r, int c, int depth, int sum) {
		if(depth == K) {
			maxSum = Math.max(sum, maxSum);
			return;
		}
		
		if(r >= N) return;
		if(c >= M) {
			calcul(r + 1, 0, depth, sum);
			return;
		}
		
		// 이번꺼 선택되나? (왼쪽, 위랑만 안겹치면돼)
		boolean flag = true;
		for(int i=0; i<depth; i++) {
			if(r - 1 == select[i][0] && c == select[i][1]) {
				flag = false;
				break;
			}
			
			if(r == select[i][0] && c - 1 == select[i][1]){
				flag = false;
				break;
			}
		}
		
		if(flag) {
			select[depth][0] = r;
			select[depth][1] = c;
			
			// 선택 
			calcul(r, c + 1, depth + 1, sum + arr[r][c]);
		}

		// 미선택
		calcul(r, c + 1, depth, sum);
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m=0; m<M; m++) arr[n][m] = Integer.parseInt(st.nextToken());
		}
		
		maxSum = Integer.MIN_VALUE;
		select = new int[K][2]; // K개 r, c
		calcul(0, 0, 0, 0);
		
		System.out.println(maxSum);
		br.close();
	}

}
