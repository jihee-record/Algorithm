package 프로그래머스.java.LV1.콜라츠추측;

class Solution {
    public int solution(int num) {
        long n = (long)num;
        int c=0;
        while(true){
            if(n == 1){
                break;
            }else if(n%2 == 0){
                n = n/2;
            }else{
                n = 3*n + 1;
            }
            c++;
            if(c >= 500){
                return -1;
            }
        }
        return c;
    }
}