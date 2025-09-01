package 백준.백준_14000_14999.백준_14889_스타트와링크_S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_14889_스타트와링크_S1_440ms {
	static int N, minDiff;
	static int[][] S;
	static boolean[] team;
	
	static void dfs(int idx, int cnt) {
		if(cnt == N/2) {
			calculate();
			return;
		}
		
		if(idx >= N) return;
		
		team[idx] = true;
		dfs(idx + 1, cnt + 1);
		
		team[idx] = false;
		dfs(idx + 1, cnt);
	}
	
	
	static void calculate() {
		int a = 0, b = 0;
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				if(team[i] && team[j]) a = a + S[i][j] + S[j][i];
				else if(!team[i] && !team[j]) b = b + S[i][j] + S[j][i];
			}
		}
		
		minDiff = Math.min(minDiff, Math.abs(a - b));
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		S = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		team = new boolean[N];
		minDiff = Integer.MAX_VALUE;

		dfs(0, 0);
		
		System.out.println(minDiff);
		br.close();
	}

}
