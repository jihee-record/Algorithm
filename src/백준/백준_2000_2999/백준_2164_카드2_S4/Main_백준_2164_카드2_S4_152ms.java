package 백준.백준_2000_2999.백준_2164_카드2_S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_백준_2164_카드2_S4_152ms {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=n; i++) {
        	queue.add(i);
        }
        
        while(queue.size()>1) {
        	queue.poll();
        	if(queue.size() == 1) {
        		break;
        	}
        	int k = queue.poll();
        	queue.add(k);
        }
        
        System.out.println(queue.peek());
        br.close();
    }
}
