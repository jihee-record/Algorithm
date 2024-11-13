package A_TEST.SWEA_1824_혁진이의프로그램검증_D4;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_SWEA_1824_혁진이의프로그램검증_D4 {
    static int[] dr = {-1, 1, 0, 0}; // 상, 하, 좌, 우 방향
    static int[] dc = {0, 0, -1, 1}; // 상, 하, 좌, 우 방향
    static int R, C;
    static String[][] commands;
    static Set<String>[][] already;

    static class State {
        int r, c, d, n;
        State(int r, int c, int d, int n) {
            this.r = r;
            this.c = c;
            this.d = d;
            this.n = n;
        }
    }

    static boolean bfs(int startR, int startC) {
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(startR, startC, 3, 0)); // 초기 상태: 오른쪽(3) 방향, 메모리 0

        while (!queue.isEmpty()) {
            State current = queue.poll();
            int r = current.r, c = current.c, d = current.d, n = current.n;
            String state = r + "-" + c + "-" + d + "-" + n;
            
            // 이미 방문한 상태면 건너뜀
            if (already[r][c].contains(state)) continue;
            already[r][c].add(state);

            String command = commands[r][c];
            switch (command) {
                case "@": // 종료 명령어
                    return true;
                case "0": case "1": case "2": case "3": case "4": 
                case "5": case "6": case "7": case "8": case "9":
                    n = Integer.parseInt(command); // 메모리에 숫자 저장
                    break;
                case "<": d = 2; break; // 왼쪽 방향 전환
                case ">": d = 3; break; // 오른쪽 방향 전환
                case "^": d = 0; break; // 위쪽 방향 전환
                case "v": d = 1; break; // 아래쪽 방향 전환
                case "_":
                    d = (n == 0) ? 3 : 2; // 메모리가 0이면 오른쪽, 아니면 왼쪽
                    break;
                case "|":
                    d = (n == 0) ? 1 : 0; // 메모리가 0이면 아래쪽, 아니면 위쪽
                    break;
                case "?": // 네 방향을 각각 큐에 추가하여 탐색
                    for (int i = 0; i < 4; i++) {
                        int nr = (r + dr[i] + R) % R;
                        int nc = (c + dc[i] + C) % C;
                        queue.add(new State(nr, nc, i, n));
                    }
                    continue;
                case ".": // 아무 동작도 하지 않음
                    break;
                case "+": // 메모리 값 증가 (0 ~ 15)
                    n = (n == 15) ? 0 : n + 1;
                    break;
                case "-": // 메모리 값 감소 (15 ~ 0)
                    n = (n == 0) ? 15 : n - 1;
                    break;
            }

            // 다음 위치로 이동
            int nr = (r + dr[d] + R) % R;
            int nc = (c + dc[d] + C) % C;
            queue.add(new State(nr, nc, d, n));
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            commands = new String[R][C];
            already = new HashSet[R][C];
            for (int i = 0; i < R; i++) {
                commands[i] = br.readLine().split("");
                for (int j = 0; j < C; j++) {
                    already[i][j] = new HashSet<>();
                }
            }

            // 초기 상태: (0, 0) 위치에서 BFS 시작
            sb.append("#").append(t).append(" ").append(bfs(0, 0) ? "YES" : "NO").append("\n");
        }

        System.out.print(sb.toString());
        br.close();
    }
}
