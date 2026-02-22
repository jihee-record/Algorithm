package 프로그래머스.java.LV1.문자열내p와y의개수;

class Solution {
    boolean solution(String s) {
    
        String[] sArr = s.split("");
        int p=0; int y=0;
        for(int i=0; i<sArr.length; i++){
            switch(sArr[i]){
                case "P" :
                    p++;
                    break;
                case "p" :
                    p++;
                    break;
                case "Y" :
                    y++;
                    break;
                case "y" :
                    y++;
                    break;
            }
        
        }
        if(p != y) {
            return false;
        }

        return true;
    }
}