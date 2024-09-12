package SWEA.SWEA_1000_1999.SWEA_1204_최빈값구하기_D2;

import java.io.*;

public class Solution_SWEA_1204_최빈값구하기_D2_124ms {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            br.readLine();
            String[] scores = br.readLine().split(" ");
            int[] scoreCnt = new int[101];
            for(String score : scores) {
                scoreCnt[Integer.parseInt(score)]++;
            }

            int maxIndex = 0;
            for(int i=100; i>=0; i--) {
                if(scoreCnt[i] > scoreCnt[maxIndex]) {
                    maxIndex = i;
                }
            }
            System.out.println("#"+t+" "+maxIndex);
        }

        br.close();
    }
}