package 코드트리.코드트리_삼성SW역량테스트.코드트리_조삼모사_L9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 조합
public class Main_코드트리_조삼모사_L9_423ms {
	static int N, minP;
	static int[][] P;
	static boolean[] work; // true : 오전, false : 오후
	
	static void dfs(int idx, int cnt) { // 오전 개수
		if (cnt == N/2) {
			calculate();
			return;
		}
		
		if(idx >= N) return;
		
		work[idx] = true;
		dfs(idx + 1, cnt + 1);
		
		work[idx] = false;
		dfs(idx + 1, cnt);
	}
	
	static void calculate() {
		int amSum = 0, pmSum = 0;
		for(int i = 0; i < N; i++) {
			for(int j = i + 1; j < N; j++) {
				if(work[i] && work[j]) { // 둘다 오전
					amSum = amSum + P[i][j] + P[j][i]; 
				}else if(!work[i] && !work[j]) {
					pmSum = pmSum + P[i][j] + P[j][i]; 
				}
			}
		}
		minP = Math.min(minP, Math.abs(amSum - pmSum));
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		P = new int[N][N];
		work = new boolean[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				P[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		minP = Integer.MAX_VALUE;
		dfs(0, 0);
		
		System.out.println(minP);
		br.close();
	}

}
