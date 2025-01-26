package SWEA.SWEA_8000_8999.SWEA_8275_햄스터_D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_8275_햄스터_D4_이지희_660ms {
	static int[][] memo;
	static int[] result;
	static int N, X, M, maxCnt;
	
	static void findHamsters(int[] now, int idx, int nowSum) {
		if(idx == N) {
			if(canBe(now) && nowSum > maxCnt) {
				// 어차피 오름차순 체크니까 ...
				maxCnt = nowSum;
				result = now.clone();
			};
			return;
		}
		
		if(nowSum + (N-idx) * X <= maxCnt) {
			return;
		}
		
		for(int i=0; i<=X; i++) {
			now[idx] = i;
			findHamsters(now, idx + 1, nowSum + i);
		}
	}
	
	static boolean canBe(int[] now) {
		for(int m=0; m<M; m++) {
			int sum = 0;
			for(int n=memo[m][0]; n<=memo[m][1]; n++) {
				sum += now[n];
			}
			if(sum != memo[m][2]) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 햄스터 우리 수
			X = Integer.parseInt(st.nextToken()); // 한 개 우리에 있을 수 있는 최대 햄스터 수
			M = Integer.parseInt(st.nextToken()); // 메모(방정식) 개수
			
			result = new int[N];
			maxCnt = -1;
			memo = new int[M][3]; // m개 방정식 , 3 :a, b, c
			
			for(int m=0; m<M; m++) {
				st = new StringTokenizer(br.readLine());
				memo[m][0]  = Integer.parseInt(st.nextToken()) - 1; // 1~n번 우리로 돼있어서
				memo[m][1]  = Integer.parseInt(st.nextToken()) - 1;
				memo[m][2]  = Integer.parseInt(st.nextToken());
			}// for m : 메모 받기 종료
			
			findHamsters(new int[N], 0, 0);
			
			if(maxCnt == -1) {
				sb.append(-1);
			} else {
				for(int n=0; n<N; n++) {
					sb.append(result[n]).append(" ");
				}
			}
			sb.append("\n");
			
		}// for t 종료
		
		System.out.println(sb.toString());
		br.close();
	}

}
