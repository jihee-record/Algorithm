package SWEA.SWEA_2000_2999.SWEA_2001_파리퇴치_D2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution0 {
	
	static int N, M;
    static int[][] map;
    static int[][] prefixSum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            prefixSum = new int[N + 1][N + 1];

            for (int row = 0; row < N; row++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int col = 0; col < N; col++) {
                    map[row][col] = Integer.parseInt(st.nextToken());
                    prefixSum[row + 1][col + 1] = map[row][col] + prefixSum[row][col + 1] + prefixSum[row + 1][col] - prefixSum[row][col];
                }
            }

            int maxFlies = 0;

            for (int i = 0; i <= N - M; i++) {
                for (int j = 0; j <= N - M; j++) {
                    int flies = prefixSum[i + M][j + M] - prefixSum[i][j + M] - prefixSum[i + M][j] + prefixSum[i][j];
                    maxFlies = Math.max(maxFlies, flies);
                }
            }

            sb.append("#").append(t).append(" ").append(maxFlies).append("\n");
        }
        bw.write(sb.toString());
		
		bw.flush();
		bw.close();
		br.close();
    }
}
