package 프로그래머스.프로그래머스_PCCP_기출1회.프로그래머스_PCCP_기출1회_2;

import java.util.ArrayDeque;

class Solution_프로그래머스_PCCP_기출1회_2 {
    public int solution(int[][] land) {
        int answer = 0;

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int N = land.length;
        int M = land[0].length;
        boolean[][] visited = new boolean[N][M];
        int[] sum = new int[M]; // 각 열마다 획득 가능한 덩어리 양
        for(int n=0; n<N; n++){
            for(int m=0; m<M; m++){
                if(visited[n][m]) continue;
                visited[n][m] = true;
                if(land[n][m] == 0) continue;
                
                boolean[] isContained = new boolean[M]; // 각 열에 포함 돼 있는지
                ArrayDeque<int[]> queue = new ArrayDeque<>();
                queue.add(new int[] {n, m});
                isContained[m] = true;
                int size = 1;
                while(!queue.isEmpty()){
                    int[] now = queue.poll();
                    int r = now[0];
                    int c = now[1];

                    for(int i=0; i<4; i++){
                        int nr = r + dr[i];
                        int nc = c + dc[i];

                        if(nr < 0 || nr >= N || nc <0 || nc >= M) continue;
                        if(visited[nr][nc]) continue;
                        visited[nr][nc] = true;

                        if(land[nr][nc] == 0) continue;
                        if(!isContained[nc]) isContained[nc] = true; 
                        queue.add(new int[] {nr, nc});
                        size++; // 덩어리 크기
                    }
                }

                for(int i=0; i<M; i++){
                    if(isContained[i]) sum[i] += size;
                }
            }
        }

        for(int i=0; i<M; i++){
            answer = Math.max(sum[i], answer);
        }
        return answer;
    }
}