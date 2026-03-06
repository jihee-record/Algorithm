package 프로그래머스.java.LV1.하샤드수;

class Solution {
    public boolean solution(int x) {
        
        String[] sArr = Integer.toString(x).split("");
        int h = 0;
        
        for(int i=0; i<sArr.length; i++){
            h += Integer.parseInt(sArr[i]);
        }        
        
        if(x%h != 0){
            return  false;
        }
        
        return true;
    }
}