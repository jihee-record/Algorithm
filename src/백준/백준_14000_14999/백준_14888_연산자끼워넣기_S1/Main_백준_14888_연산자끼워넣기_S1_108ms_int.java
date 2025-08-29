package 백준.백준_14000_14999.백준_14888_연산자끼워넣기_S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_14888_연산자끼워넣기_S1_108ms_int {
	static int N, max, min, plus, minus, multiple, divide;
	static int[] number;
	
	static void dfs(int idx, int plusCnt, int minusCnt, int multipleCnt, int divideCnt, int result) {
		if(idx == N) {
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}
		
		if(plusCnt < plus) {
			dfs(idx + 1, plusCnt + 1, minusCnt, multipleCnt, divideCnt, result + number[idx]);
		}
		
		if(minusCnt < minus) {
			dfs(idx + 1, plusCnt, minusCnt + 1, multipleCnt, divideCnt, result - number[idx]);
		}
		
		if(multipleCnt < multiple) {
			dfs(idx + 1, plusCnt, minusCnt, multipleCnt + 1, divideCnt, result * number[idx]);
		}
		
		if(divideCnt < divide) {
			dfs(idx + 1, plusCnt, minusCnt, multipleCnt, divideCnt + 1, result / number[idx]);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
				
		N = Integer.parseInt(br.readLine());
		number = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n=0; n<N; n++) {
			number[n] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		plus = Integer.parseInt(st.nextToken());
		minus = Integer.parseInt(st.nextToken());
		multiple = Integer.parseInt(st.nextToken());
		divide = Integer.parseInt(st.nextToken());
		
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		dfs(1, 0, 0, 0, 0, number[0]);
		
		sb.append(max).append("\n").append(min);
		System.out.println(sb);
		br.close();
	}

}
