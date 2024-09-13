package SWEA.SWEA_Test.Test2_2_이지희;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test2_2_이지희 {
	static int N, M, K; //N : 참가자 수 , M : 시상자 수 K : 시상자 등번호 합
	static int[] number; // 등번호 배열
	static int[] factorial = {1, 1, 2, 6, 24, 120, 720, 5040, 403200};
	static int result;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		//T: 테케
		int T = Integer.parseInt(br.readLine());

		// 테케 반복
		for(int t=1; t<=T; t++) {
			// N, M, K 받기
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			number = new int[N];
			result = 0; 
			
			
			// 시상자들의 등번호 받기
			st = new StringTokenizer(br.readLine());
			// 등번호 배열에 저장
			for(int n=0; n<N; n++) {
				number[n] = Integer.parseInt(st.nextToken());
			}// for n 종료
			
			comb(0, 0, 0);
			
			// 순서를 고려해서 M!를 곱해
			result *= factorial[M];
			
			sb.append("#").append(t).append(" ");
			if(result == 0) sb.append(-1).append("\n");
			else sb.append(result).append("\n");
		}// for t 종료
		System.out.println(sb.toString());
		br.close(); //
	} // main()
	
	//N개 중에서 M개를 순서를 고려하여 뽑는 방법의 수 중에 조건을 만족하는(합이 K인)
	static void comb(int idx, int cnt, int sum) {
		// M번째 선택이었는데
		if(cnt == M) {
			//딱 K만큼 더했다면 ok 
			if(sum == K) {
				result ++ ;
				return;
			// 아니면 실패 / fail/
			}else {
				return;
			}
		}
		
		// 끝까지갔는데 M명을 못채웠어
		if(idx == N) {
			return ;
		}
		
		// M개 채우기 전
		// 이번 번호에서 더하지 않았어 다음에 더해볼게
		comb(idx+1, cnt, sum);
		
		// 이번 번호에서 더했어 
		comb(idx+1, cnt+1, sum + number[idx]);
	}
	
	static int permut(int m) {
		if(m == 1) {
			return 1;
		}
		
		return permut(m-1)*m;
	}
	
}// class
