package 코드트리.방향에맞춰이동;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main_방향에맞춰이동3 {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
        int n = Integer.parseInt(br.readLine());
        
        int[] dx = {0, 1, -1, 0}, dy = {1, 0, 0, -1};
        int nx = 0, ny = 0;
        
        
        Map<Character, Integer> dirMap = new HashMap<>();
        dirMap.put('N', 0);
        dirMap.put('E', 1);
        dirMap.put('W', 2);
        dirMap.put('S', 3);
        
        
        
        for (int i = 0; i < n; i++) {
        	String input = br.readLine();
            int dir = dirMap.get(input.charAt(0));
            int distance = Integer.parseInt(input.split(" ")[1]);
            
            nx += distance * dx[dir];
            ny += distance * dy[dir];
        }
        
        System.out.println(nx + " " + ny);
        br.close();
    }
}