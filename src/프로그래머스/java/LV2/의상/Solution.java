package 프로그래머스.java.LV2.의상;

import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> hash = new HashMap<>();
        for(int i=0; i<clothes.length; i++) {
        	hash.put(clothes[i][1], hash.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        int comb = 1;
        
        for(int num : hash.values()) {
        	comb = comb * (num+1);
        }
        
        return comb-1;
    }
}