package SWEA.SWEA_1000_1999.SWEA_1873_상호의배틀필드_D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_SWEA_1873_상호의배틀필드_D3_이지희_113ms {
	
	// 방향 (위, 아래, 왼쪽, 오른쪽)
    static final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;
    // 전차 이동 방향
    static final int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static final int[] dy = {0, 0, -1, 1};
    // 전차 방향 모양
    static final char[] tankShape = {'^', 'v', '<', '>'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int t = 1; t <= T; t++) {
        	String[] temp = br.readLine().split(" ");
            int H = Integer.parseInt(temp[0]); // 맵의 높이
            int W = Integer.parseInt(temp[1]); // 맵의 너비
            char[][] map = new char[H][W]; // 게임 맵
            int tankX = 0, tankY = 0, direction = 0;

            // 맵 입력 및 전차 위치 찾기
            for (int i = 0; i < H; i++) {
                String row = br.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = row.charAt(j);
                    switch (map[i][j]) {
                    case '^':
                        tankX = i;
                        tankY = j;
                        direction = UP;
                        break;
                    case 'v':
                        tankX = i;
                        tankY = j;
                        direction = DOWN;
                        break;
                    case '<':
                        tankX = i;
                        tankY = j;
                        direction = LEFT;
                        break;
                    case '>':
                        tankX = i;
                        tankY = j;
                        direction = RIGHT;
                        break;
                    }
                }
            }

            int N = Integer.parseInt(br.readLine()); // 입력 명령 개수
            String commands = br.readLine(); // 명령어 입력

            // 명령 처리
            for (int i = 0; i < N; i++) {
                char command = commands.charAt(i);

                if (command == 'S') {
                    // 포탄 발사
                    shoot(map, H, W, tankX, tankY, direction);
                } else {
                    // 방향 전환 및 이동
                    direction = changeDirection(command);
                    map[tankX][tankY] = tankShape[direction]; // 전차의 방향을 바꿈
                    int nx = tankX + dx[direction];
                    int ny = tankY + dy[direction];

                    // 이동 가능 여부 체크
                    if (nx >= 0 && nx < H && ny >= 0 && ny < W && map[nx][ny] == '.') {
                        map[tankX][tankY] = '.'; // 전차가 떠난 자리는 평지로 바꿈
                        map[nx][ny] = tankShape[direction]; // 전차 이동
                        tankX = nx;
                        tankY = ny;
                    }
                }
            }

            // 결과 출력
            sb.append("#").append(t).append(" ");
            for (int i = 0; i < H; i++) {
                sb.append(map[i]).append("\n");
            }
        }
        
        System.out.println(sb.toString());
        br.close();
    }

    // 명령에 따라 방향 변경
    public static int changeDirection(char command) {
        if (command == 'U') return UP;
        if (command == 'D') return DOWN;
        if (command == 'L') return LEFT;
        if (command == 'R') return RIGHT;
        return -1;
    }

    // 포탄 발사 함수
    public static void shoot(char[][] map, int H, int W, int x, int y, int direction) {
        int nx = x + dx[direction];
        int ny = y + dy[direction];

        // 포탄이 맵 밖으로 나가지 않고 벽에 부딪힐 때까지 직진
        while (nx >= 0 && nx < H && ny >= 0 && ny < W) {
            if (map[nx][ny] == '*') { // 벽돌 벽이면 파괴
                map[nx][ny] = '.';
                break;
            } else if (map[nx][ny] == '#') { // 강철 벽이면 아무 일도 없음
                break;
            }
            nx += dx[direction];
            ny += dy[direction];
        }
    }
}
