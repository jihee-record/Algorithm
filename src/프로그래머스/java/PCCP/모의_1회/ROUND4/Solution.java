package 프로그래머스.java.PCCP.모의_1회.ROUND4;

import java.util.*;

class Solution {
    public long[] solution(int[][] program) {
        long[] answer = new long[11];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if(a[1] == b[1]) return Integer.compare(a[0], b[0]);
            else return Integer.compare(a[1], b[1]); // 호출 우선
        });

        for(int i=0; i<program.length; i++){
            pq.add(program[i]);
        }

        int t = 0;
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            if(t <= now[1]) { // 바로 시작 가능
                t = now[1] + now[2]; // 호출 시각 + 소요 시간
            } else { // 대기 해야하는데 그 사이에 우선순위가 높은 일이 호출되었을 수 있음
                answer[now[0]] += t - now[1]; // 현재 대시간 시간
                now[1] = t; // 다시 순서 조정
                pq.add(now);
            }
        }

        answer[0] = t;
        return answer;
    }
}