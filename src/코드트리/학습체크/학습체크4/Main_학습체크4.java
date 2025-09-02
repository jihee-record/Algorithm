package 코드트리.학습체크.학습체크4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_학습체크4 {
	
	static int N, K;
    static int[][] drink;
    static int maxDrink = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // N개 종류 용액 구매
		K = Integer.parseInt(br.readLine()); // K병 음료수 제작
		
		drink = new int[K][2]; // K개 종류 음료 2개 재료
		
		for(int k=0; k<K; k++) {
			st = new StringTokenizer(br.readLine(), " ");
			drink[k][0] = Integer.parseInt(st.nextToken());
			drink[k][1] = Integer.parseInt(st.nextToken());
		}
		
		// 2N개 중 N개 선택 -> DFS/백트래킹
        dfs(1, new HashSet<>());

        System.out.println(maxDrink);
		br.close();
		
	}
	
	// 현재 선택 후보 번호, 선택된 집합
    static void dfs(int idx, Set<Integer> chosen) {
        // N개 고르면 음료수 개수 체크
        if(chosen.size() == N) {
            int cnt = 0;
            for(int i=0; i<K; i++) {
                if(chosen.contains(drink[i][0]) && chosen.contains(drink[i][1])) {
                    cnt++;
                }
            }
            maxDrink = Math.max(maxDrink, cnt);
            return;
        }

        // 후보가 2N개라서 idx > 2N 되면 종료
        if(idx > 2*N) return;

        // 1) 선택
        chosen.add(idx);
        dfs(idx+1, chosen);

        // 2) 선택 안 함
        chosen.remove(idx);
        dfs(idx+1, chosen);
    }

}
