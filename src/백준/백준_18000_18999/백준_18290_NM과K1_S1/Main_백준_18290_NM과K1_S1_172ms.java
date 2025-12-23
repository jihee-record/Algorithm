package 백준.백준_18000_18999.백준_18290_NM과K1_S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_18290_NM과K1_S1_172ms {
	static int N, M, K;
	static int[][] arr;
	static boolean[][] visited; // 선택된 위치
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
		if(r > 0 && visited[r-1][c]) flag = false; // 위
		if(c > 0 && visited[r][c-1]) flag = false; // 왼
		
		if(flag) {
			visited[r][c] = true;
			// 선택 
			calcul(r, c + 1, depth + 1, sum + arr[r][c]);
			visited[r][c] = false; // 복원
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
		visited = new boolean[N][M];
		calcul(0, 0, 0, 0);
		
		System.out.println(maxSum);
		br.close();
	}

}
