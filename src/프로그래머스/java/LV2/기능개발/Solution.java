package 프로그래머스.java.LV2.기능개발;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public int[] solution(int[] progresses, int[] speeds) {
         ArrayList<Integer> list = new ArrayList<>();	
        Queue<Integer> que = new LinkedList<>();
        
        for(int i=0; i<progresses.length; i++) {
        	int a = progresses[i];
        	int b = speeds[i];
        	if((100-a)%b>0) {
        		que.offer((100-a)/b + 1);
        	}else {
        		que.offer((100-a)/b);
        	}
        }
        
        int dayCount = 0;
        int date = que.peek();
        for(int i=0; i<progresses.length; i++) {
        	if(que.peek()>date) {
        		list.add(dayCount);
        		date = que.poll();
        		dayCount = 1;
        	}
        	else {
        		que.remove();
        		dayCount ++;
        	}
        }
        
        list.add(dayCount);
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
        	answer[i] = list.get(i);
        }
        
        return answer;
    }
}