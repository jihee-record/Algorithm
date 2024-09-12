package SWEA.SWEA_8000_8999.SWEA_8931_제로_D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
 
public class Solution_SWEA_8931_제로_D3_이지희_200ms {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        int T = Integer.parseInt(br.readLine());
        for(int t = 1 ; t <= T ; t++) {
            int K = Integer.parseInt(br.readLine());
            Stack<Integer> stack = new Stack<>();
            int sum = 0;
            for(int k=0; k<K; k++) {
                int input = Integer.parseInt(br.readLine());
                if(input == 0) {
                    sum -= stack.pop();
                }else {
                    sum += input;
                    stack.push(input);
                }
            }
             
            sb.append("#").append(t).append(" ").append(sum).append("\n");
        }
         
        System.out.println(sb.toString());
        br.close();
    }
}