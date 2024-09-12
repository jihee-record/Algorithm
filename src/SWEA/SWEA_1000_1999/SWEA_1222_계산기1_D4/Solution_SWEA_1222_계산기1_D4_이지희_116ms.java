package SWEA.SWEA_1000_1999.SWEA_1222_계산기1_D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_SWEA_1222_계산기1_D4_이지희_116ms {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
         
        for(int t=1; t<=10; t++) {
            int result = 0;
            br.readLine();
            st = new StringTokenizer(br.readLine(), "+");
            while(st.hasMoreTokens()) {
                result += Integer.parseInt(st.nextToken());
            }
            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
         
        System.out.println(sb.toString());
        br.close();
    }
}