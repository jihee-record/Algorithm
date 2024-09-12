package SWEA.SWEA_2000_2999.SWEA_2805_농작물수확하기_D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Solution_SWEA_2805_농작물수확하기_D3_이지희_161ms {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        int T = Integer.parseInt(br.readLine());
         
        for(int t=1; t<=T; t++) {
            int N = Integer.parseInt(br.readLine());
             
            int income = 0;
            for(int r=0; r<N; r++) {
                String[] tokens = br.readLine().split("");
                for(int c=0; c<N; c++) {
                    if(r+c >= N/2 && r+c <= (N-1) + N/2
                        && r-c >= -N/2 && r-c <= N/2) {
                        income += Integer.parseInt(tokens[c]);
                    }
                }
            }
             
            sb.append("#").append(t).append(" ").append(income).append("\n");
        }
     
        System.out.println(sb.toString());
        br.close();
    }
}