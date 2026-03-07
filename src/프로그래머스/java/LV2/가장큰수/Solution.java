package 프로그래머스.java.LV2.가장큰수;

import java.util.*;

class Solution {
    public static String solution(int[] numbers) {
        String answer = "";
        
        PriorityQueue<Integer> pQue = new PriorityQueue<>(new Comparator<Integer>() {
        	
        	@Override
        	public int compare(Integer o1, Integer o2) {
        		String sa = Integer.toString(o1);
        		String sb = Integer.toString(o2);
        		
        		int ab = Integer.parseInt(sa+sb);
        		int ba = Integer.parseInt(sb+sa);
        		
        		if(ab > ba) {
        			return -1;
        		}
        		
        		if(ab < ba) {
        			return 1;
        		}
        		
        		return 0;
        	}
        });
        
        int zeros = 0;
        int nums_length = numbers.length;
        for(int i=0; i<nums_length; i++) {
        	int k = numbers[i];
        	if(k == 0) {
        		zeros++;
        	}
        	pQue.offer(k);
        }
        
        if(zeros == nums_length) {
        	return "0";
        }
        
        while(!pQue.isEmpty()) {
        	answer += Integer.toString(pQue.poll());
        }
        
        
        return answer;
    }
}