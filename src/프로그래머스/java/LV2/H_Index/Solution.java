package 프로그래머스.java.LV2.H_Index;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
	
	public static int solution(int[] citations) {
		int l = citations.length;
		
		if(l==1 && citations[0]!=0) {
			return 1;
		}
		
		ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<l; i++) {
        	list.add(citations[i]);
        }
        
        Collections.sort(list, Comparator.reverseOrder());
        
        if(list.get(l-1) >= l) {
        	return l;
        }
        
        int h = 0;
        for(int i=0; i<l; i++) {
        	if(list.get(i)<i) {
        		h = Math.min(i, list.get(i-1));
        		break;
        	}
        }
        
        return h;
    }
}