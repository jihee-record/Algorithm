package SWEA.SWEA_4000_4999.SWEA_4613_러시아국기같은깃발_D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//완전탐색
public class Solution_SWEA_4613_러시아국기같은깃발_D4_이지희_108ms {
	static char[][] flag;
	static int[][] cntColor; // [n][c] : n번째줄 c컬러 개수 (c: 0=W 1=B 2=R)
	static int N, M;
	
	static int coloring(int I, int J) {
		int cnt = 0;
		// 0부터 I줄까지 W로 칠하기 
		// I+1부터 J줄까지 B로 칠하기 
		// J+1부터 N-1까지 R로 칠하기
		for(int i=0; i<=I; i++) {
			cnt = cnt + cntColor[i][1] + cntColor[i][2];
		}
		for(int j=I+1; j<=J; j++) {
			cnt = cnt + cntColor[j][0] + cntColor[j][2];
		}
		for(int k=J+1; k<N; k++) {
			cnt = cnt + cntColor[k][0] + cntColor[k][1];
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st ;
		int T = Integer.parseInt(br.readLine());
	
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			flag = new char[N][M];
			cntColor = new int[N][3];
			for(int n=0; n<N; n++) {
				//flag[n] = br.readLine().split("");
				String input = br.readLine();
				for(int m=0; m<M; m++) {
					char c = input.charAt(m);
					flag[n][m] = c;
					switch(c) {
					case 'W':
						cntColor[n][0]++;
						break;
					case 'B':
						cntColor[n][1]++;
						break;
					case 'R':
						cntColor[n][2]++;
						break;
					}
				}
			}
				
			
			int cntMin = Integer.MAX_VALUE; // 최소 색칠 횟수
			for(int i=0; i<N-2; i++) { //W
				for(int j=i+1; j<N-1; j++) { //B
					cntMin = Math.min(cntMin, coloring(i, j));
				}
			}
			
			sb.append("#").append(t).append(" ").append(cntMin).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
}
