package 프로그래머스.java.LV1.x만큼간격이있는n개의숫자;

class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        for(int i=0; i<n; i++){
            answer[i] = (long)x*(1+i);
        }
        return answer;
    }
}