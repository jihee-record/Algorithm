package 프로그래머스.java.LV1.평균구하기;

class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        for(int i=0; i<arr.length; i++){
            answer += arr[i];
        }
        answer = answer/(double)arr.length;
        return answer;
    }
}