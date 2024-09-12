package 백준.백준_5000_5999.백준_5430_AC_G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main_백준_5430_AC_G5_820ms {
    
    static StringBuilder AC(Deque<String> deq, String[] p) {
        StringBuilder sb = new StringBuilder();
        int reverseCount = 0; // R이 나올 때마다 증가
        
        for (int i = 0; i < p.length; i++) {
            if (p[i].equals("R")) {
                reverseCount++;
            } else {
                if (deq.isEmpty()) {
                    return sb.append("error");
                } else {
                    if (reverseCount % 2 == 0) {
                        deq.removeFirst();
                    } else {
                        deq.removeLast();
                    }
                }
            }
        }
        
        // 최종 방향 설정
        if (reverseCount % 2 != 0) {
            reverseDeque(deq);
        }
        
        sb.append("[");
        while (!deq.isEmpty()) {
            sb.append(deq.removeFirst());
            if (!deq.isEmpty()) sb.append(",");
        }
        sb.append("]");
        
        return sb;
    }
    
    static void reverseDeque(Deque<String> deq) {
        LinkedList<String> temp = new LinkedList<>();
        while (!deq.isEmpty()) {
            temp.add(deq.removeLast());
        }
        deq.addAll(temp);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < T; i++) {
            String[] p = br.readLine().split("");
            int n = Integer.parseInt(br.readLine());
            Deque<String> deq = new LinkedList<>();
            
            String input = br.readLine();
            if (n > 0) {
                String[] values = input.substring(1, input.length() - 1).split(",");
                for (String value : values) {
                    deq.add(value);
                }
            }

            result.append(AC(deq, p)).append("\n");
        }
        
        System.out.println(result.toString());
        br.close();
    }
}
