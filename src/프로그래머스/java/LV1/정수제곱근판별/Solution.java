package 프로그래머스.java.LV1.정수제곱근판별;

class Solution {
    public long solution(long n) {
        if(n/(long)Math.sqrt(n) == Math.sqrt(n)){
            return ((long)Math.sqrt(n)+1L)*((long)Math.sqrt(n)+1L);
        }
        return -1;
    }
}