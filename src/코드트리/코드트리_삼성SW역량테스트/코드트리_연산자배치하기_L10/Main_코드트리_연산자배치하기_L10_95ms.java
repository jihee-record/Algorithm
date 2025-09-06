package 코드트리.코드트리_삼성SW역량테스트.코드트리_연산자배치하기_L10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_코드트리_연산자배치하기_L10_95ms {
	static int N, plus, minus, multiple, min, max;
	static int[] number, operation;
	
	static void dfs(int idx, int plusCnt, int minusCnt, int multipleCnt) {
		if(plusCnt == plus && minusCnt == minus && multipleCnt == multiple) {
			calculate();
			return;
		}
		
		if(idx >= N-1) return; // 연산자는 N-1개
		
		if(plusCnt < plus) {
//			operation[idx] = 0 ; // default
			dfs(idx + 1, plusCnt + 1, minusCnt, multipleCnt);
		}
		
		if(minusCnt < minus) {
			operation[idx] = 1;
			dfs(idx + 1, plusCnt, minusCnt + 1, multipleCnt);
			operation[idx] = 0;
		}
		
		if(multipleCnt < multiple) {
			operation[idx] = 2;
			dfs(idx + 1, plusCnt, minusCnt, multipleCnt + 1);
			operation[idx] = 0;
		}
	}
	
	static void calculate() {
		int result = number[0];
		for(int n=1; n<N; n++) {
			switch(operation[n-1]) {
			case 0: // +
				result += number[n];
				break;
			case 1: // -
				result -= number[n];
				break;
			case 2: // *
				result *= number[n];
				break;
			}
		}
		
		min = Math.min(min, result);
		max = Math.max(max, result);
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		number = new int[N];
		operation = new int[N-1];
		
		st = new StringTokenizer(br.readLine());
		for(int n=0; n<N; n++) {
			number[n] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		plus = Integer.parseInt(st.nextToken());
		minus = Integer.parseInt(st.nextToken());
		multiple = Integer.parseInt(st.nextToken());
		
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		
		dfs(0, 0, 0, 0);
		
		System.out.println(min + " " + max);
		br.close();
		
	}

}
