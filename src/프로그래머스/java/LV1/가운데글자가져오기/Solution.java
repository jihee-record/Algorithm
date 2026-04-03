package 프로그래머스.java.LV1.가운데글자가져오기;

class Solution {
    public String solution(String s) {
    	int l = s.length();
    	int mid = l / 2;
        
    	if(l % 2 != 0) return s.substring(mid, mid + 1);
    	else return s.substring(mid - 1, mid + 1);
    }
}