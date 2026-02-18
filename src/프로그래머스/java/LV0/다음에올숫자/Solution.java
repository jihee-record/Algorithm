package 프로그래머스.java.LV0.다음에올숫자;

class Solution {
    public int solution(int[] common) {
        int answer = 0;
        if(common[1] - common[0] == common[2] - common[1]){
            answer = (common[1]-common[0])+common[common.length -1];
        }else{
            answer = (common[1]/common[0])*common[common.length -1];
        }
        return answer;
    }
}