package 프로그래머스.java.LV0.배열의평균값;

class Solution {
    public double solution(int[] numbers) {
        double sum = 0;
    
        for(int i=0; i<numbers.length; i++){
            sum += (double)numbers[i] ; 
        } 
        
        double answer = sum/numbers.length;
        return answer;
    }
}