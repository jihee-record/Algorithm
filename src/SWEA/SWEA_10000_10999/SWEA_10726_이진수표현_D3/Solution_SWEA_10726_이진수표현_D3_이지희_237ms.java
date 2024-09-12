package SWEA.SWEA_10000_10999.SWEA_10726_이진수표현_D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_SWEA_10726_이진수표현_D3_이지희_237ms {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
         
        //테케 수
        int T = Integer.parseInt(br.readLine());
 
        // 테케
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
             
            st = new StringTokenizer(br.readLine()); // 한줄받아자르기
            int N = Integer.parseInt(st.nextToken()); //
            int M = Integer.parseInt(st.nextToken());
 
            // 1<<N :  1000000~0 (0이 N개)
            // compare : 1111111~1 (1이 N개)
            int compare = (1 << N) - 1;
 
            if ((M & compare) == compare) {
                sb.append("ON").append("\n");
            } else {
                sb.append("OFF").append("\n");
            }
        }//for t 종료
 
        System.out.println(sb.toString());
        br.close();
    }// main()
}// class
