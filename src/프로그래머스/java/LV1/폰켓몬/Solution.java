package 프로그래머스.java.LV1.폰켓몬;

import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        int N = nums.length;
		HashSet<Integer> kind = new HashSet<>();
		
		for(int i=0; i<N; i++) {
			kind.add(nums[i]);
		}
		
		int K = kind.size();
		
		if(K<N/2) return K;
		else return N/2;
    }
}