package 프로그래머스.java.LV1.개인정보수집유효기간;

import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public static int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer;
        
        ArrayList<Integer> list = new ArrayList<>();
        
        int year = Integer.parseInt(today.substring(0, 4));
        int month = Integer.parseInt(today.substring(5, 7));
        int date = Integer.parseInt(today.substring(8));
        
        HashMap<String, Integer> termsMap = new HashMap<>();
        for(int i=0; i<terms.length; i++) {
        	termsMap.put(terms[i].substring(0, 1), Integer.parseInt(terms[i].substring(2)));
        }
        
        for(int i=0; i<privacies.length; i++) {
        	int p_year = Integer.parseInt(privacies[i].substring(0, 4));
        	int p_date = Integer.parseInt(privacies[i].substring(8, 10));
        	String p_kind = privacies[i].substring(11);
        	if(termsMap.containsKey(p_kind)) {
        	
	        	int p_month = Integer.parseInt(privacies[i].substring(5, 7));
	        	int p_month_q = (p_month + termsMap.get(p_kind) - 1)/12;
	        	int p_month_r = ((p_month + termsMap.get(p_kind))%12 + p_month)%12; 
	        	if(p_month_q > 0) {
	        		if(p_year + 1 < year) list.add(i+1);
	        		else if(p_year + 1 == year) {
	        			if(p_month_r < month) list.add(i+1);
	        			else if(p_month_r == month && p_date <=date) list.add(i+1);
	        		}
	        	}
	        	
	        	else {
	        		if(p_year < year) list.add(i+1);
	        		else if(p_year == year) {
	        			if(p_month_r < month) list.add(i+1);
		    			else if(p_month_r == month && p_date <= date) list.add(i+1);
	        		}
	        	}
        	
        	}
        }
        
        
        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
        	answer[i] = list.get(i);
        }
        
        return answer;
    }
}