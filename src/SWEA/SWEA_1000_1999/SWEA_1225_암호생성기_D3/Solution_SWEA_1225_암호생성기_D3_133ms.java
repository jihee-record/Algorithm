package SWEA.SWEA_1000_1999.SWEA_1225_암호생성기_D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Solution_SWEA_1225_암호생성기_D3_133ms {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
         
        for(int t=1; t<=10; t++) {
            Integer.parseInt(br.readLine()); //int T = 
            Queue<Integer> q = new LinkedList<>();
             
            st = new StringTokenizer(br.readLine(), " ");
            for(int i=0; i<8; i++) {
                q.add(Integer.parseInt(st.nextToken()));
            }
             
            outerLoop:
            while(true) {
                for(int i=1; i<=5; i++) {
                    int digit = q.poll();
                    if(digit - i <= 0) {
                        q.add(0);
                        break outerLoop;
                    }
                    q.add(digit-i);
                }
            }
             
            //
            sb.append("#").append(t).append(" ");
            while(!q.isEmpty()) {
                sb.append(q.poll()).append(" ");
            }
            sb.append("\n");
             
        }// testcase :t
         
        System.out.println(sb.toString());
        br.close();
    }
}