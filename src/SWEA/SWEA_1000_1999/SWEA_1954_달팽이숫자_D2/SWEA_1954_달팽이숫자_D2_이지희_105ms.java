package SWEA.SWEA_1000_1999.SWEA_1954_달팽이숫자_D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class SWEA_1954_달팽이숫자_D2_이지희_105ms {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        int T = Integer.parseInt(br.readLine());
         
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] snail = new int[N][N];
             
            // 시작 숫자 : 1, now, col : 시작 위치 [0][0], direction : 방향 (dRow, dCol)
            int number = 1, row = 0, col = 0, direction = 0;
             
            // 오른쪽, 아래, 왼쪽, 위 순서로 이동
            int[] dRow = {0, 1, 0, -1};
            int[] dCol = {1, 0, -1, 0};
             
           // int maxNumber = N * N;
            while (number <= N * N) {
                // 숫자 채우고 다음에 채울 숫자로(+1)
                snail[row][col] = number++;
                 
                int nextRow = row + dRow[direction];
                int nextCol = col + dCol[direction];
                 
                // nextRow, nextCol로 지정된 숫자가 map 안에 들어오는 유효 숫자인지 체크
                // 아직 방문하지 않은 위치 체크
                if (nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < N && snail[nextRow][nextCol] == 0) {
                    row = nextRow;
                    col = nextCol;
                } else {
                    // 모퉁이에서 방향 꺾기 
                    // 다음 방향 direction : 3 > 다음은 배열의 index : 0으로 되어야하므로 나머지 연산으로 적용
                    direction = (direction + 1) % 4;
                    row += dRow[direction];
                    col += dCol[direction];
                }
            }
             
            sb.append("#").append(t).append("\n");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append(snail[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }
         
        System.out.print(sb.toString());
        br.close();
    }
}
