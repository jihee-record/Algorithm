package 백준.백준_9000_9999.백준_9328_열쇠_G1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_백준_9328_열쇠_G1_980ms{
    static int H, W;
    static char[][] map;
    static int[] dh = {-1, 1, 0, 0};
    static int[] dw = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            map = new char[H][W];
            for (int h = 0; h < H; h++) {
                String input = br.readLine();
                for (int w = 0; w < W; w++) {
                    map[h][w] = input.charAt(w);
                }
            }

            String keyInput = br.readLine();
            boolean[] hasKey = new boolean[26];
            if (!keyInput.equals("0")) {
                for (int i = 0; i < keyInput.length(); i++) {
                    hasKey[keyInput.charAt(i) - 'a'] = true;
                }
            }

            // 출입구(테두리) 모으기
            ArrayList<int[]> exits = new ArrayList<>();
            for (int w = 0; w < W; w++) {
                if (map[0][w] != '*') exits.add(new int[]{0, w});
                if (map[H - 1][w] != '*') exits.add(new int[]{H - 1, w});
            }
            for (int h = 1; h < H - 1; h++) {
                if (map[h][0] != '*') exits.add(new int[]{h, 0});
                if (map[h][W - 1] != '*') exits.add(new int[]{h, W - 1});
            }

            int docs = 0;

            // phase 반복: 새 키를 얻을 때만 다시 돈다
            boolean changed = true;
            while (changed) {
                changed = false;

                boolean gotNewKeyThisPhase = false;

                exitloop:
                for (int i = 0; i < exits.size(); i++) {
                    int[] start = exits.get(i);
                    int sh = start[0], sw = start[1];

                    if (map[sh][sw] == '*') continue; // 벽이면 스킵

                    boolean[][] visited = new boolean[H][W];
                    ArrayDeque<int[]> q = new ArrayDeque<>();

                    // ✅ enqueue 시점 방문 처리 (MLE 방지)
                    visited[sh][sw] = true;
                    q.add(new int[]{sh, sw});

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        int h = cur[0], w = cur[1];

                        char c = map[h][w];

                        // 문
                        if (c >= 'A' && c <= 'Z') {
                            if (!hasKey[c - 'A']) {
                                // 키 없으면 여기서 막힘 (visited는 이미 찍혀있어 재큐잉 폭발 없음)
                                continue;
                            }
                            // ✅ 문 열었으면 통로로 만들어야 함
                            map[h][w] = '.';
                        }
                        // 키
                        else if (c >= 'a' && c <= 'z') {
                            int idx = c - 'a';
                            if (!hasKey[idx]) {
                                hasKey[idx] = true;
                                changed = true;              // 새 키 -> phase 다시 탐색 필요
                                gotNewKeyThisPhase = true;
                            }
                            // ✅ 키 먹은 자리도 통로
                            map[h][w] = '.';

                            // 새 키를 얻은 경우: 이번 phase 탐색 더 해봤자 문 상태가 바뀌니 바로 다시 시작
                            if (gotNewKeyThisPhase) break exitloop;
                        }
                        // 문서
                        else if (c == '$') {
                            docs++;
                            // ✅ 문서 먹은 자리도 통로 (중복 카운트 방지)
                            map[h][w] = '.';
                        }

                        // 인접 확장
                        for (int d = 0; d < 4; d++) {
                            int nh = h + dh[d];
                            int nw = w + dw[d];

                            if (nh < 0 || nh >= H || nw < 0 || nw >= W) continue;
                            if (map[nh][nw] == '*') continue;
                            if (visited[nh][nw]) continue;

                            visited[nh][nw] = true; // ✅ enqueue 시점
                            q.add(new int[]{nh, nw});
                        }
                    }
                }
            }

            sb.append(docs).append('\n');
        }

        System.out.print(sb);
    }
}
