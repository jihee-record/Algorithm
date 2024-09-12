package SWEA.SWEA_1000_1999.SWEA_1216_회문2_D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution0 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int t=1; t<=10; t++) {
			sb.append("#").append(Integer.parseInt(br.readLine()));
			char[][] grid = new char[100][100]; 
			for(int i=0; i<100; i++) {
				 String input = br.readLine();
				 for(int j=0; j<100; j++) {
					 grid[i][j] = input.charAt(j);
				 }
			}

	        sb.append(" ").append(findLongestPalindrome(grid).length()).append("\n");
		}
		System.out.print(sb.toString());
		
		br.close();
	}
	// 회문인지 체크
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        // 양쪽끝에서 부터 맞는지 안쪽으로 들어가면서 체크
        while (left < right) {
        	// 회문이 아님
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    // 가장 긴 회문을 찾아보자
    public static String findLongestPalindrome(char[][] grid) {
        int maxLength = 0;
        String maxPalindrome = "";

        // 가로
        for (int i = 0; i < grid.length; i++) {
            String row = new String(grid[i]);
            int n = row.length();
            // 긴 것부터 체크 > 긴 것이 발견되면 같은 라인에서 그보다 짧은 건 체크하지 않음
            for (int length = n; length > 0; length--) {
                for (int start = 0; start <= n - length; start++) {
                    String substring = row.substring(start, start + length);
                    if (isPalindrome(substring)) {
                        if (length > maxLength) {
                            maxLength = length;
                            maxPalindrome = substring;
                        }
                        break; 
                    }
                }
            }
        }

        // 세로
        for (int col = 0; col < grid[0].length; col++) {
            StringBuilder sb = new StringBuilder();
            for (int row = 0; row < grid.length; row++) {
                sb.append(grid[row][col]);
            }
            String colStr = sb.toString();
            int n = colStr.length();
            for (int length = n; length > 0; length--) {
                for (int start = 0; start <= n - length; start++) {
                    String substring = colStr.substring(start, start + length);
                    if (isPalindrome(substring)) {
                        if (length > maxLength) {
                            maxLength = length;
                            maxPalindrome = substring;
                        }
                        break;
                    }
                }
            }
        }

        return maxPalindrome;
    }
}
