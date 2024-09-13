package SWEA.SWEA_Test.Test2_1_이지희;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Test2_1_이지희 {
    static int N;
    static boolean[][] map;
    static int[] starColCnt; // index:컬럼 > 값 : 컬럼에 쌓인 별의 수
    static int starRowCntBottom; // 어차피 한칸씩 떨어지니까 맨 아래만 채워지는지 알면 돼 

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // T : 테스트 케이스 수
        int T = Integer.parseInt(br.readLine()); 

        // 테스트 케이스 반복
        for (int t = 1; t <= T; t++) {
            // N : 정사각형 게임판 한 변의 길이
            N = Integer.parseInt(br.readLine());
            map = new boolean[N][N];
            starColCnt = new int[N];
            starRowCntBottom = 0;

            String order = br.readLine();

            // order 테트리스 떨구기
            for (int i = 0; i < order.length(); i++) {
                int col = order.charAt(i) - 48;

                // 열에 모두 쌓인게 아니라면
                if (starColCnt[col] < N) {
                    // 별을 쌓았다.
                    int row = N - 1 - starColCnt[col];
                    map[row][col] = true;
                    starColCnt[col]++;

                    // 가장 밑에 있는 row부터 사라질 것이기 때문에 
                    // 지금 떨어뜨린 위치가 바닥이어야 한 줄 삭제할 가능성이 생김
                    if (row == N - 1) {
                        starRowCntBottom++; // 일단 하나 늘었는데
                        if (starRowCntBottom == N) { // 채워졌다면 밑 줄 삭제 후 down
                            // 한 줄 삭제하니까 각 열의 별 수도 1씩 줄어듦
                            for (int s = 0; s < N; s++) {
                                starColCnt[s]--;
                            }
                            // 그리고 한 칸 씩 down 시키기
                            for (int r = N - 1; r > 0; r--) {
                                System.arraycopy(map[r - 1], 0, map[r], 0, N);
                            }
                            // 맨 윗줄은 떨어질거 없이 그냥 없음
                            Arrays.fill(map[0], false);
                            // 이제 바닥의 starRowCnt는 다시 카운트
                            starRowCntBottom = 0;
                            for (int c = 0; c < N; c++) {
                                if (map[N - 1][c]) {
                                    starRowCntBottom++;
                                }
                            }
                        }
                    }
                }
            }

            // 답안 작성
            sb.append("#").append(t).append("\n");
            // 행마다
            for (int r = 0; r < N; r++) {
                // 열마다
                for (int c = 0; c < N; c++) {
                    // 별이 있니
                    if (map[r][c]) {
                        // 있어
                        sb.append("*");
                    } else {
                        // 없어
                        sb.append(" ");
                    }
                }
                // 한 줄 종료
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());
        br.close();
    }
}