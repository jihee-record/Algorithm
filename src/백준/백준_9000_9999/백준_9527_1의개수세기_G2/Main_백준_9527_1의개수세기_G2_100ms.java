package 백준.백준_9000_9999.백준_9527_1의개수세기_G2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_9527_1의개수세기_G2_100ms {
	static long S(long N) {
		if(N <= 0) return 0;
		
		long sum = 0;
		
		while(N > 0) {
			int K = 63 - Long.numberOfLeadingZeros(N);
			long P = 1L << K; // 2^k
			
			long TK = K * (1L << (K-1)); //T[k] = S(2^k -1) = 2 * S(2^(k-1) - 1) + 2^(k-1) = 2*T(k-1) + 2^(k-1) = K * 2^(k-1)
			
			sum += TK;
			sum += (N - P + 1); // P <= N < 2*P, 최상위비트 1의 개수 
			// 예를들어, N=13 -> K=3, P=8, TK=S(7)=12: 3자리까지, 8~13까지 2^3자리 1개수 6개
			// 이후 N-P = 5에 대해 반복 N=5 -> K=2, P=4 TK=S(3)=4: 2자리까지 1의 개수, 4~5까지 2^2자리 1개수 2개
			// N-P = 1 -> K=0, P=1 TK=S(0)=0: 1자리까지 1의 개수, 1~1까지 2^0자리 1개수 : 1개
			// N-P = 0 종료
			
			N -= P;
		}
		
		return sum;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		System.out.println(S(B) - S(A-1)); // A부터 합
		br.close();
	}

}
