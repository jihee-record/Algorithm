package 프로그래머스.java.PCCP.모의_1회.ROUND2;

class Solution {
    static int max;
    static int N, M;
    static boolean[] visited;

    static int solution(int[][] ability) {
        max = 0;
        N = ability.length; // 학생 수
        M = ability[0].length; // 종목 개수
        visited = new boolean[M]; // 배정 여부 (종목)

        dfs(0, 0, 0, ability);
        return max;
    }

    static void dfs(int idx, int cnt, int sum, int[][] ability){
        if(cnt == M){ // 배정 완료
            max = Math.max(max, sum);
            return;
        }

        if(idx == N) return;
        if(N - idx < M - cnt) return; // 나머지 다 선택해도 배정 불가

        for(int m=0; m<M; m++){
            if(visited[m]) continue; // 이미 배정된 종목 넘어가고
            visited[m] = true; // 아니면 배정해보자
            dfs(idx + 1, cnt + 1, sum + ability[idx][m], ability);
            visited[m] = false; // 복원
        }

        dfs(idx + 1, cnt, sum, ability); // 배정 안하는 경우

    }
}

