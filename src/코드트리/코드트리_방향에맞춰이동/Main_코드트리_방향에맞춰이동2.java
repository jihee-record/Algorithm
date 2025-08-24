package 코드트리.코드트리_방향에맞춰이동;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_코드트리_방향에맞춰이동2 {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
        int n = Integer.parseInt(br.readLine());
        int dx=0, dy=0;
        
        for (int i = 0; i < n; i++) {
        	String input = br.readLine();
            char direction = input.charAt(0);
            int distance = Integer.parseInt(input.split(" ")[1]);
            
            switch(direction) {
            case 'N':
            	dy = dy + distance;
            	break;
            case 'E':
            	dx = dx + distance;
            	break;
            case 'W':
            	dx = dx - distance;
            	break;
            case 'S':
            	dy = dy - distance;
            }
        }
        
        System.out.println(dx + " " + dy);
        br.close();
    }
}