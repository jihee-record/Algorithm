package 프로그래머스.java.LV3.이중우선순위큐;

import java.util.PriorityQueue;

class Solution {
    public static int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        //오름차순
        PriorityQueue<Integer> lowerQue = new PriorityQueue<>();
        //내림차순
        PriorityQueue<Integer> upperQue = new PriorityQueue<>((o1, o2) ->(o2 - o1));
        
        for(int i=0; i<operations.length; i++) {
        	String op = operations[i];
        	
        	switch(op) {
        		case "D 1":
        			try {
        				int k = upperQue.poll();
        				lowerQue.remove(k);
        			} catch(Exception e) {
        				
        			}
        			break;
        		
        		case "D -1":
        			try {
        				int k = lowerQue.poll();
        				upperQue.remove(k);
        			} catch(Exception e) {
        				
        			}
        			break;
        		
        		default:
        			int addNumber = Integer.parseInt(op.substring(2));
        			lowerQue.offer(addNumber);
        			upperQue.offer(addNumber);
        	}
        }
        
        if(!lowerQue.isEmpty()) {
        	answer[1] = lowerQue.peek();
        	answer[0] = upperQue.peek();
        }
        
        return answer;
    }
}