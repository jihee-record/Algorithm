package SWEA.SWEA_2000_2999.SWEA_2001_파리퇴치_D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1 {
    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            for (int row = 0; row < N; row++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int col = 0; col < N; col++) {
                    map[row][col] = Integer.parseInt(st.nextToken());
                }
            }

            int maxFlies = 0;
            for (int i = 0; i <= N - M; i++) {
                for (int j = 0; j <= N - M; j++) {
                    int flies = 0;
                    for (int rowFlies = 0; rowFlies < M; rowFlies++) {
                        for (int colFlies = 0; colFlies < M; colFlies++) {
                            flies += map[i + rowFlies][j + colFlies];
                        }
                    }
                    maxFlies = Math.max(maxFlies, flies);
                }
            }
            System.out.println("#" + t + " " + maxFlies);
        }
        br.close();
    }
}

