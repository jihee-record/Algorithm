package 프로그래머스.프로그래머스_PCCP_기출1회.프로그래머스_PCCP_기출1회_1;

class Solution_프로그래머스_PCCP_기출1회_1 {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int now = health; // 초기 체력

        for(int i=0; i<attacks.length; i++){
            int diff = attacks[i][0] -1; // [0]: sec, [1]: damage
            if(i > 0) diff -= attacks[i-1][0]; 
            
            int recover = diff * bandage[1] + (diff / bandage[0]) * bandage[2];
            now = Math.min(health, now + recover);
            
            now -= attacks[i][1];

            if(now <= 0) return -1;
        }

        return now;
    }
}