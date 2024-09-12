package SWEA.SWEA_1000_1999.SWEA_1216_회문2_D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//Manacher's Algorithm
public class Solution_SWEA_1216_회문2_D3_이지희_152ms {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= 10; t++) {
            sb.append("#").append(Integer.parseInt(br.readLine()));
            char[][] grid = new char[100][100];
            for (int i = 0; i < 100; i++) {
                String input = br.readLine();
                for (int j = 0; j < 100; j++) {
                    grid[i][j] = input.charAt(j);
                }
            }

            sb.append(" ").append(findLongestPalindrome(grid)).append("\n");
        }
        System.out.print(sb.toString());
        br.close();
    }

    public static int findLongestPalindrome(char[][] grid) {
    	// 회문 최소 길이 1
        int maxLength = 1;

        // 가로 회문 체크
        for (int i = 0; i < 100; i++) {
            maxLength = Math.max(maxLength, manacher(grid[i]));
        }

        // 세로 회문 체크
        for (int col = 0; col < 100; col++) {
            char[] colArray = new char[100];
            for (int row = 0; row < 100; row++) {
                colArray[row] = grid[row][col];
            }
            maxLength = Math.max(maxLength, manacher(colArray));
        }

        return maxLength;
    }

    // 회문의 최장 길이 반환
    public static int manacher(char[] s) {
        int n = s.length;
        int[] p = new int[n];
        int c = 0, r = 0;
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            int mirror = 2 * c - i;

            if (i < r) {
                p[i] = Math.min(r - i, p[mirror]);
            }

            // 홀수 길이
            while (i + p[i] + 1 < n && i - p[i] - 1 >= 0 && s[i + p[i] + 1] == s[i - p[i] - 1]) {
                p[i]++;
            }

            // 짝수 길이
            if (i + p[i] > r) {
                c = i;
                r = i + p[i];
            }

            maxLength = Math.max(maxLength, p[i]);
        }

        return maxLength * 2 + 1;
    }
}