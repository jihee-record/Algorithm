package SWEA.SWEA_2000_2999.SWEA_2001_파리퇴치_D2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
  
public class Solution_SWEA_2001_파리퇴치_D2_이지희_109ms {
    static int N, M;
    static int[][] map;
      
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
          
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            for(int row=0; row<N; row++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int col=0; col<N; col++) {
                    map[row][col] = Integer.parseInt(st.nextToken());
                }
            }
            int maxFlies = 0;
            for(int i=0; i<N; i++) { //행을 따라 내려가면서 check
                for(int j=0; j<N; j++) { //열을 따라 이동하면서 check
                    int flies = 0;
                    for(int r=0 ; r<M; r++) { //파리채 영역 행
                        if(i+r>=0 && i+r<N) {
                            for(int c = 0; c<M; c++) { //파리채 영역 열
                                if(j+c>=0 && j+c<N) {
                                    flies += map[i+r][j+c];
                                }
                            }
                        }
                    }
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