package 프로그래머스.java.PCCP.모의_1회.ROUND3;

class Solution2 {
	String[] snd = {"RR", "Rr", "Rr", "rr"};
	
    public String[] solution(int[][] queries) {
       String[] answer = new String[queries.length];
       
       outloop:
       for(int t=0; t<queries.length; t++) {
    	   int n = queries[t][0];
    	   int p = queries[t][1] - 1; // mod
    	   
    	   if(n == 1) {
    		   answer[t] = "Rr";
    		   continue;
    	   }
    	   
    	   int[][] qr = new int[n][2]; // q, r mod 4
    	   for(int i=n-1; i>=1; i--) { // n-1 : n세대 
    		   qr[i][0] = p / 4;
    		   qr[i][1] = p % 4;
    		   p /= 4;
    	   }
    	   
    	   for(int i=1; i<n; i++) {
    		   if(qr[i][1] == 0 || qr[i][1] == 3) {
        		   answer[t] = snd[qr[i][1]]; // RR, rr -> 고정
        		   continue outloop;
        	   }
    	   }
    	   
    	   answer[t] = snd[qr[n-1][1]];
       }
       
       return answer;
    }
}