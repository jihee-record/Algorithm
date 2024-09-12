package SWEA.SWEA_1000_1999.SWEA_1216_회문2_D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int t=1; t<=10; t++) {
			br.readLine();
			char[][] grid = new char[100][100]; 
			for(int i=0; i<100; i++) {
				 String input = br.readLine();
				 for(int j=0; j<100; j++) {
					 grid[i][j] = input.charAt(j);
				 }
			}

	        sb.append("#").append(t).append(" ").append(findLongestPalindrome(grid)).append("\n");
		}
		System.out.println(sb.toString());
		
		br.close();
	}
	
    // 가장 긴 회문을 찾아보자
    public static int findLongestPalindrome(char[][] grid) {
        int maxLength = 0;

        // 가로 방향
        for (int i = 0; i < grid.length; i++) {
            String row = new String(grid[i]);
            maxLength = Math.max(maxLength, getMaxPalindromeLength(row));
        }

        // 세로 방향
        for (int col = 0; col < grid[0].length; col++) {
            StringBuilder sb = new StringBuilder();
            for (int row = 0; row < grid.length; row++) {
                sb.append(grid[row][col]);
            }
            String colStr = sb.toString();
            maxLength = Math.max(maxLength, getMaxPalindromeLength(colStr));
        }

        return maxLength;
    }

    // 주어진 문자열에서 가장 긴 회문의 길이를 반환
    public static int getMaxPalindromeLength(String s) {
        int maxLength = 0;
        int n = s.length();
        // DP 배열
        boolean[][] dp = new boolean[n][n];

        // 길이가 1인 회문
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            maxLength = 1;
        }

        // 길이가 2인 회문
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                maxLength = 2;
            }
        }

        // 길이가 3 이상인 회문
        for (int length = 3; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    maxLength = length;
                }
            }
        }

        return maxLength;
    }
}