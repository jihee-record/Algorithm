package SWEA.SWEA_2000_2999.SWEA_2072_홀수만더하기_D1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_SWEA_2072_홀수만더하기_D1_이지희_99ms {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int result = 0;
            String line = br.readLine();
            int length = line.length();
            int number = 0;
            boolean isNegative = false;
            for (int i = 0; i < length; i++) {
                char ch = line.charAt(i);
                if (ch == ' ') {
                    if (number % 2 == 1) {
                        result += number;
                    }
                    number = 0;
                    isNegative = false;
                } else if (ch == '-') {
                    isNegative = true;
                } else {
                    number = number * 10 + (ch - '0');
                    if (isNegative) {
                        number = -number;
                        isNegative = false;
                    }
                }
            }
            if (number % 2 == 1) {
                result += number;
            }
            System.out.println("#" + t + " " + result);
        }
        br.close();
    }
}