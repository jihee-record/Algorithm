package 프로그래머스.java.LV2.더맵게;

import java.util.PriorityQueue;

public class Solution {
	
	public static int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pQue = new PriorityQueue<>();
        
        for(int i : scoville) {
        	pQue.offer(i);
        }
        
        while(pQue.peek()<K) {
        	if(pQue.size() == 1) {
        		return -1;
        	}
        	int a = pQue.poll();
        	int b = pQue.poll();
        	pQue.offer(a+b*2);
        	answer++;
        }
        
        return answer;
    }

}