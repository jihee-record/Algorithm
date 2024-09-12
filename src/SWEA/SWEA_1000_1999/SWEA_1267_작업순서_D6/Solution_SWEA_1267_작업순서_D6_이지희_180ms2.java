package SWEA.SWEA_1000_1999.SWEA_1267_작업순서_D6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_1267_작업순서_D6_이지희_180ms2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int t = 1; t <= 10; t++) { //테케
        	sb.append("#").append(t);
        	st = new StringTokenizer(br.readLine(), " ");
            int V = Integer.parseInt(st.nextToken()); // 정점의 개수 
            int E = Integer.parseInt(st.nextToken()); // 간선의 개수
            int[][] map = new int[V+1][V+1]; // 1번부터
            int[] degree = new int[V+1]; // 1번부터
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < E; i++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map[a][b] = 1; // a->b
                degree[b]++;
            }
            Queue<Integer> q = new LinkedList<Integer>();
            for (int i = 1; i <= V; i++) {
                if (degree[i] == 0) { // 진입차수 0 : 처음에 시작할 애들
                    q.offer(i);
                }
            }
            while(!q.isEmpty()) {
                int v = q.poll();
                sb.append(" ").append(v);
                for (int i = 1; i <= V; i++) {
                    if (map[v][i] == 1) { // 인접 정점 
                    	degree[i]--; // 수행했으니까 1 빼줌
                        if (degree[i] == 0) { // 사전 작업 완료했으면 다음에 일할 차례
                            q.offer(i);
                        }
                    }
                }
            }
            sb.append("\n");
        } // for t 종료
        System.out.print(sb.toString());
    } // main()
} // class