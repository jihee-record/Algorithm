package 프로그래머스.java.LV3.징검다리건너기;

class Solution {
    public int solution(int[] stones, int k) {
        int left = 1; // 최소 인원
        int right = 200000000; // 최대 인원
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2; // 중간값 계산

            if (canCross(stones, k, mid)) {
                // mid명이 건널 수 있다면 더 많은 인원을 시도
                answer = mid;
                left = mid + 1;
            } else {
                // mid명이 건널 수 없다면 인원을 줄임
                right = mid - 1;
            }
        }

        return answer;
    }

    private boolean canCross(int[] stones, int k, int mid) {
        int consecutiveZeros = 0;

        for (int stone : stones) {
            if (stone - mid <= 0) {
                consecutiveZeros++; // 현재 디딤돌을 건널 수 없음
                if (consecutiveZeros >= k) {
                    return false; // 연속된 0이 k 이상이면 건널 수 없음
                }
            } else {
                consecutiveZeros = 0; // 다시 초기화
            }
        }

        return true; // 모든 디딤돌을 건너는 데 성공
    }
}