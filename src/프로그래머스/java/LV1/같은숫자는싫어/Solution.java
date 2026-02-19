package 프로그래머스.java.LV1.같은숫자는싫어;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public static int[] solution(int[] arr) {
        int[] answer;
        
        Deque<Integer> deq = new LinkedList<>();
        deq.offerFirst(-1);

        for(int i=0; i<arr.length; i++) {
        	if(deq.peekLast()!=arr[i]) deq.offerLast(arr[i]);
        }
        
        deq.pollFirst();

        answer = new int[deq.size()];
        for(int i=0; i<answer.length; i++) {
        	answer[i] = deq.pollFirst();
        }
        
        return answer;
    }
    

}