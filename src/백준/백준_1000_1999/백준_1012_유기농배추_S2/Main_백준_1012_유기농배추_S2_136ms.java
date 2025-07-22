package 백준.백준_1000_1999.백준_1012_유기농배추_S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_1012_유기농배추_S2_136ms {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); // 가로
            int N = Integer.parseInt(st.nextToken()); // 세로
            int K = Integer.parseInt(st.nextToken()); // 배추 개수

            int[][] map = new int[M][N];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            int cnt = 0;
            Queue<int[]> q = new ArrayDeque<>();

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 1) { // 아직 안 간 배추
                        cnt++;
                        map[i][j] = 0;
                        q.add(new int[]{i, j});

                        while (!q.isEmpty()) {
                            int[] now = q.poll();
                            int x = now[0], y = now[1];

                            for (int d = 0; d < 4; d++) {
                                int nx = x + dx[d];
                                int ny = y + dy[d];

                                if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                                if (map[nx][ny] == 0) continue;

                                map[nx][ny] = 0; // 방문 처리
                                q.add(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.print(sb);
    }
}
