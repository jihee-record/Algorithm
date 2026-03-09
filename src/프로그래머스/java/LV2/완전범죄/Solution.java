package 프로그래머스.java.LV2.완전범죄;

import java.util.*;


class Solution {
    int n, m;
	int[][] info;
	int minA = Integer.MAX_VALUE;
	Map<String, Integer> complete = new HashMap<>(); // 상태저장
	
	public int solution(int[][] info, int n, int m) {
		this.n = n;
		this.m = m;
		this.info = info;
        
        thief(0, 0, 0);
        
        if(minA > 120) return -1;
        return minA;
    }
	
	/**
	 * 
	 * @param index : 어떤 보물
	 * @param bSum : B가 남긴 흔적 합
	 * @param bSet : B가 훔친 보물 집합
	 * @return
	 */
	public void thief (int index, int bSum, int aSum) {
		if(aSum >= n) return; // a가 잡혀서 끝 - 종료
		if(bSum >= m) return; // 불가능한 조합 - 종료
		
		if(index == info.length) {
			minA = Math.min(aSum, minA);
			return; // 조합 종료
		}
		
		String key = index + " " + aSum + " " + bSum;
		// 이미 체크했는데 기존 값이 더 작으면 - 종료
		if(complete.containsKey(key) && complete.get(key) <= aSum) return;
		// 체크할거면
		complete.put(key, aSum);
		
		// 다음 원소 b훔침 조합
		thief(index+1, bSum + info[index][1], aSum);
		
		// 다음 원소 a훔침 조합
		thief(index+1, bSum, aSum + info[index][0]);
		
	}
}