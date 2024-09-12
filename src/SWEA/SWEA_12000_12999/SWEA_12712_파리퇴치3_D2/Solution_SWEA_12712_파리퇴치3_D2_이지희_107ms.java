package SWEA.SWEA_12000_12999.SWEA_12712_파리퇴치3_D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_SWEA_12712_파리퇴치3_D2_이지희_107ms {
     
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
         
        int T = Integer.parseInt(br.readLine());
         
        for(int t=1; t<=T; t++) {
            st = new StringTokenizer(br.readLine());
             
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
             
            int[][] flies = new int[N][N];
             
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    flies[i][j] = Integer.parseInt(st.nextToken());
                }
            }
             
            // 최대 파리수를 구해라
            int maxFlies = 0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    // 가로세로 십자가
                    int sum = flies[i][j]; //가운데
                    for(int k=1; k<M; k++) {
                        if(j-k >= 0) sum += flies[i][j-k]; // 상
                        if(j+k < N) sum += flies[i][j+k]; // 하
                        if(i-k >= 0) sum += flies[i-k][j]; //좌
                        if(i+k < N) sum += flies[i+k][j]; //우
                    }
                    maxFlies = Math.max(maxFlies, sum);
                     
                    // 초기화 - 대각선
                    sum = flies[i][j]; //가운데
                    for(int k=1; k<M; k++) {
                        if(i-k >= 0 && j-k >= 0) sum += flies[i-k][j-k]; // 왼쪽 위
                        if(i-k >= 0 && j+k < N) sum += flies[i-k][j+k]; // 오른쪽 위
                        if(i+k < N && j-k >= 0) sum += flies[i+k][j-k]; // 왼쪽 아래
                        if(i+k < N && j+k < N) sum += flies[i+k][j+k]; // 오른쪽 아래
                    }
                    maxFlies = Math.max(maxFlies, sum);
                }
            }
             
            sb.append("#").append(t).append(" ").append(maxFlies).append("\n");
        }
         
        System.out.println(sb.toString());
        br.close();
    }
}