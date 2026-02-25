package 프로그래머스.java.LV1.정수내림차순으로배치하기;

import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String[] sArr = Long.toString(n).split("");
        int[] iArr = new int[sArr.length];
        for(int i=0; i<sArr.length; i++){
            iArr[i] = Integer.parseInt(sArr[i]);
        }
        Arrays.sort(iArr);
        String str = "";
        for(int i=0; i<iArr.length; i++){
            str += Integer.toString(iArr[iArr.length-1-i]);
        }
        answer = Long.parseLong(str);
        return answer;
    }
}