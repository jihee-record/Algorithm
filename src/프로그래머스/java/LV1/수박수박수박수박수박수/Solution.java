package 프로그래머스.java.LV1.수박수박수박수박수박수;

class Solution {
    public String solution(int n) {
    	StringBuilder sb = new StringBuilder();
    	int k = n/2;
    	for(int i=0; i<k; i++) sb.append("수박");
    	if(n % 2 == 1) sb.append("수");
        return sb.toString();
    }
}