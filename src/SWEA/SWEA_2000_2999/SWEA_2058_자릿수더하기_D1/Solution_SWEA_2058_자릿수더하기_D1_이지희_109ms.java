package SWEA.SWEA_2000_2999.SWEA_2058_자릿수더하기_D1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_SWEA_2058_자릿수더하기_D1_이지희_109ms {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        String[] digit = br.readLine().split("");
        for(int i=0; i<digit.length; i++) {
            answer += Integer.parseInt(digit[i]);
        }

        System.out.println(answer);
        br.close();
    }
}
