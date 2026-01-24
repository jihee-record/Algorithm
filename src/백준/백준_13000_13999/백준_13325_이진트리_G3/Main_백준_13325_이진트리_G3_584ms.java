package 백준.백준_13000_13999.백준_13325_이진트리_G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 한 자리 자연수가 아니라서 charAt으로 하면 안됨.
public class Main_백준_13325_이진트리_G3_584ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
 		int N = (int)Math.pow(2, K+1) - 1; // 총 N-1개 노드
		int[] arr = new int[N];
 		int[] dp = new int[N + 1]; // n번 노드에서 리프까지 경로 - 리프노드는 모두 0
 		
		int kSum = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n=1; n<N; n++) arr[n] = Integer.parseInt(st.nextToken());

		for(int k=K-1; k>=0; k--) { // 리프 노드 제외 나머지 노드 
			int cnt = (int)Math.pow(2, k); // 이번 층 개수 // cnt - 1 이번 층 첫번째 간선 순번
			int limit = 2 * cnt;
			for(int i=cnt; i<limit ; i++) { 
				
				for(int j=0; j<2; j++) { // 한 서브트리의 좌우 비교
					int e = i * 2 - j; // e번째 간선
					dp[i] = Math.max(dp[i], dp[e + 1] + arr[e]);
				}
				
				kSum += (dp[i] - dp[2*i]);
				kSum += (dp[i] - dp[2*i + 1]);
			}
		}
				
		System.out.println(kSum);
		br.close();
	}

}
