package 프로그래머스.java.LV1.두정수사이의합;

class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        
        int max = b;
        int min = a;
        if(a == b) return a;
        else if(a>b) {
            min = b;
            max = a;
        }
        
        for(int i=min; i<=max; i++){
            answer = answer + (long)i;
        }
        return answer;
    }
}