package 백준.백준_17000_17999.백준_17626_FourSquares_S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 의식의 흐름 60분
public class Main_백준_17626_FourSquares_S3_152ms2 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N + 1];
		Arrays.fill(dp, 4);
		dp[0] = 0;
		
		int limit = (int)Math.sqrt(N);
        int[] sq = new int[limit + 1];
        for (int i = 1; i <= limit; i++) sq[i] = i * i;

        for (int n = 1; n <= N; n++) {
            for (int i = 1; i <= limit && sq[i] <= n; i++) {
                dp[n] = Math.min(dp[n], dp[n - sq[i]] + 1);
                if (dp[n] == 1) break; 
            }
        }
		
		System.out.println(dp[N]);
		br.close();
	}

}
