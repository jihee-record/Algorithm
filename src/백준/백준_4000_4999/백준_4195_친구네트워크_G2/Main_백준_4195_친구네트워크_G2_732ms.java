package 백준.백준_4000_4999.백준_4195_친구네트워크_G2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_백준_4195_친구네트워크_G2_732ms {
    static Map<String, String> parent; 
    static Map<String, Integer> networkSize; 

    static void union(String a, String b) {
        String rootA = find(a); 
        String rootB = find(b); 

        if (!rootA.equals(rootB)) {
            parent.put(rootB, rootA);
            networkSize.put(rootA, networkSize.get(rootA) + networkSize.get(rootB)); 
        }
    }

    static String find(String x) {
        if (!parent.containsKey(x)) {
            parent.put(x, x); 
            networkSize.put(x, 1); 
            return x;
        }

        if (x.equals(parent.get(x))) { 
            return x;
        }

        parent.put(x, find(parent.get(x)));
        return parent.get(x);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int i = 0; i < t; i++) {
            int f = Integer.parseInt(br.readLine()); // 친구 관계의 수
            parent = new HashMap<>();
            networkSize = new HashMap<>();

            for (int j = 0; j < f; j++) {
            	StringTokenizer st = new StringTokenizer(br.readLine());
                String userA = st.nextToken();
                String userB = st.nextToken();

                union(userA, userB); 
                sb.append(networkSize.get(find(userA))).append("\n"); 
            }
        }

        System.out.println(sb);
        br.close();
    }
}
