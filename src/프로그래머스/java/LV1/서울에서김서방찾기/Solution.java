package 프로그래머스.java.LV1.서울에서김서방찾기;

class Solution {
    public String solution(String[] seoul) {
        String ans="";
        for(int i=0; i<seoul.length; i++){
            if(seoul[i].equals("Kim")){
                ans = "김서방은 " + i +"에 있다";
            }
        }
        return ans;
    }
}