package 코드트리.코드트리_방향에맞춰이동;

import java.util.Scanner;

public class Main_코드트리_방향에맞춰이동 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int dx=0, dy=0;
        
        for (int i = 0; i < n; i++) {
            char direction = sc.next().charAt(0);
            int distance = sc.nextInt();
            
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
        sc.close();
    }
}