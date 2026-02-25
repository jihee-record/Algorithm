package 프로그래머스.java.LV1.자연수뒤집어배열로만들기;

class Solution {
    public int[] solution(long n) {
        String[] sArr = (Long.toString(n)).split("");
        int k = sArr.length;
        int[] answer = new int[k];
        for(int i=0; i<k; i++){
            answer[i] = Integer.parseInt(sArr[k-i-1]);
        }
        return answer;
    }
}