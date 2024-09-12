package SWEA.SWEA_5000_5999.SWEA_5432_쇠막대기자르기_D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_SWEA_5432_쇠막대기자르기_D4_이지희_155ms {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T; t++) {
            String input = br.readLine();
            int count = 0;
            int stack = 0;
            
            for(int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '(') {
                    stack++;
                } else {
                    stack--;
                    if (input.charAt(i - 1) == '(') {
                        count += stack;  // 레이저로 인해 현재 스택에 있는 막대기의 수만큼 추가
                    } else {
                        count++;  // 하나의 막대기의 끝
                    }
                }
            }
            sb.append("#").append(t).append(" ").append(count).append("\n");
        }
        
        System.out.print(sb.toString());
        br.close();
    }
}