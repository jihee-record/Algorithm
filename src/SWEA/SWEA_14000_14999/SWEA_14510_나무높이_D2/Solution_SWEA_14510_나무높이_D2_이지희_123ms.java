package SWEA.SWEA_14000_14999.SWEA_14510_나무높이_D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 나무높이
 */
public class Solution_SWEA_14510_나무높이_D2_이지희_123ms {
    
    static int[] tree; // 나무 높이들
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine()); // T : 테스트 케이스 수
        
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine()); // N : 나무의 개수 
            tree = new int[N]; // 나무 높이 초기화
            
            st = new StringTokenizer(br.readLine(), " "); // 나무 높이 입력
            int goalHeight = 0;
            for (int n = 0; n < N; n++) {
                tree[n] = Integer.parseInt(st.nextToken());
                goalHeight = Math.max(goalHeight, tree[n]);
            }
            
            // 나무를 키워야 하는 총 높이
            int odd = 0;
            int even = 0;
            int remain = 0;
            for (int n = 0; n < N; n++) {
            	int diff = goalHeight - tree[n];
            	remain += diff;
            	odd += diff%2 ;
            	even += diff/2 ; // 5이면 odd에 1 even에 2 추가 
            }
            
            int days = 0; 
            if(odd > even) {
            	days = odd*2 -1;
            }else {
            	days = remain/3*2 + remain%3;
            }

            sb.append("#").append(t).append(" ").append(days).append("\n");
        }

        System.out.println(sb.toString());
        br.close();
    }
}
