package SWEA.SWEA_IM.봉사동아리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 봉사동아리_이지희2 {
	static int N, min, max;
	static int[] score;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int TC = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			// 학생수
			N = Integer.parseInt(st.nextToken());
			// 최소인원
			min = Integer.parseInt(st.nextToken());
			// 최대인원
			max = Integer.parseInt(st.nextToken());
			
			String str = br.readLine();
			score = new int[N];
			for(int i=0, idx=0; i<N; i++, idx+=2) {
				score[i] = Integer.parseInt(String.valueOf(str.charAt(idx)));
			}
			
			Arrays.sort(score);
			
			// 0부터 최대 N-3까지 
			// N-2까지
			// N-1
			int result = 1000;
			for(int i=0; i<N-2; i++) {
				for(int j=i+1; j<N-1; j++) {
					// i+1 : 부진반 인원
					// j-i : 보통반 인원
					if(i+1 > max || j-i > max) {
						break;
					}
					
					// 인원이 안 채워지거나 넘치는 경우 넘어가기
					// N-j-1 : 우수반 인원
					if(i+1 < min || j-i < min || N-j-1 > max) {
						continue;
					}
					
					// 점수로 나눌 수 없어서 분반 불가
					if(score[i] == score[i+1] || score[j] == score[j+1]) {
						continue;
					}
					
					int maxCnt = Math.max(Math.max(i+1, j-i), N-j-1);
					int minCnt = Math.min(Math.min(i+1, j-i), N-j-1);
					result = Math.min(maxCnt - minCnt, result);
				}
			}
			
			sb.append("#").append(tc).append(" ");
			if(result == 1000) {
				sb.append(-1);
			}else {
				sb.append(result);
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		br.close();
		
	}

}
