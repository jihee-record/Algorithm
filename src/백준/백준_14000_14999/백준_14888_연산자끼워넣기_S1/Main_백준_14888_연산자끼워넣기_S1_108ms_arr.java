package 백준.백준_14000_14999.백준_14888_연산자끼워넣기_S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_14888_연산자끼워넣기_S1_108ms_arr {
	static int N, max, min;
	static int[] number, opCnt, used;
	
	static void dfs(int idx, int result) {
		if(idx == N) {
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}
		
//		if(idx >= N-1) return;
		
		if(used[0] < opCnt[0]) {
			used[0]++;
			dfs(idx + 1, result + number[idx]);
			used[0]--;
		}
		
		if(used[1] < opCnt[1]) {
			used[1]++;
			dfs(idx + 1, result - number[idx]);
			used[1]--;
		}
		
		if(used[2] < opCnt[2]) {
			used[2]++;
			dfs(idx + 1, result * number[idx]);
			used[2]--;
		}
		
		if(used[3] < opCnt[3]) {
			used[3]++;
			dfs(idx + 1, result / number[idx]);
			used[3]--;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
				
		N = Integer.parseInt(br.readLine());
		number = new int[N];
		opCnt = new int[4]; // + - * /
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n=0; n<N; n++) {
			number[n] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			opCnt[i] = Integer.parseInt(st.nextToken());
		}
		
		used = new int[4];
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		dfs(1, number[0]);
		
		sb.append(max).append("\n").append(min);
		System.out.println(sb);
		br.close();
	}

}
