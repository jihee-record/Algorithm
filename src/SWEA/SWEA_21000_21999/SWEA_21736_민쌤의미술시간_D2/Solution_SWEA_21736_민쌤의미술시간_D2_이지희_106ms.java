package SWEA.SWEA_21000_21999.SWEA_21736_민쌤의미술시간_D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_21736_민쌤의미술시간_D2_이지희_106ms {
   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringBuilder sb = new StringBuilder();
       StringTokenizer st;

       int T = Integer.parseInt(br.readLine());

       for (int t = 1; t <= T; t++) {
           st = new StringTokenizer(br.readLine());
           int N = Integer.parseInt(st.nextToken()); // 행
           int M = Integer.parseInt(st.nextToken()); // 열
           int K = Integer.parseInt(st.nextToken()); // 작업 횟수

           int[][] drawing = new int[N][M]; // 색칠할 도화지
           int[] coloring = new int[11]; // 색상별 색칠 횟수
           coloring[0] = N * M; // 처음에는 모든 도화지가 흰색(0번 색상)

           int[][] work = new int[K][5];
           for (int k = 0; k < K; k++) { // 작업
               st = new StringTokenizer(br.readLine());
               work[k][0] = Integer.parseInt(st.nextToken());  // startRow
               work[k][1] = Integer.parseInt(st.nextToken());  // startCol
               work[k][2] = Integer.parseInt(st.nextToken());  // endRow
               work[k][3] = Integer.parseInt(st.nextToken());  // endCol
               work[k][4] = Integer.parseInt(st.nextToken());  // color

               boolean flag = true;
               for (int i = 0; i < k; i++) { // 여태 작업 영역을 확인
                   if ((work[i][0] <= work[k][0] && work[i][1] >= work[k][0]) 
                           ||(work[i][2] <= work[k][2] && work[i][2] >= work[k][2])
                           ||(work[i][1] <= work[k][1] && work[i][1] >= work[k][1])
                           ||(work[i][3] <= work[k][3] && work[i][3] >= work[k][3])) {
                       if (work[i][4] > work[k][4]) { // 이미 더 진한 색이 칠해져 있으면
                           flag = false;
                           break;
                       }
                   }
               }

               if (flag) {
                   for (int r = work[k][0]; r <= work[k][2]; r++) {
                       for (int c = work[k][1]; c <= work[k][3]; c++) {
                           coloring[drawing[r][c]]--; // 기존 색상 카운트 감소
                           drawing[r][c] = work[k][4]; // 새 색상으로 칠하기
                           coloring[work[k][4]]++; // 새 색상 카운트 증가
                       }
                   }
               }
           }

           int maxArea = 0; // 최대 색상 영역을 찾기 위한 초기값
           for (int i = 0; i <= 10; i++) {
               maxArea = Math.max(maxArea, coloring[i]);
           }

           sb.append("#").append(t).append(" ").append(maxArea).append("\n");
       }
       System.out.println(sb.toString());
       br.close();
   }
}
