package 프로그래머스.java.LV1.자릿수더하기;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        String str = Integer.toString(n);
        String[] sArr = str.split("");
        
        for(int i=0; i<sArr.length; i++){
            answer += Integer.parseInt(sArr[i]);
        }

        return answer;
    }
}