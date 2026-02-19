package 프로그래머스.java.LV1.K번째수;

import java.util.*;

public class Solution {
	public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        List<Integer> list;

        for(int i=0; i<commands.length; i++) {
        	list = new ArrayList<>();
        	for(int j=commands[i][0]-1; j<commands[i][1]; j++) {
        		list.add(array[j]);
        	}
        	Collections.sort(list);
        	answer[i] = list.get(commands[i][2]-1);
        }
        
        return answer;
    }
}