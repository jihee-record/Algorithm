//package 코드트리.학습체크.학습체크5;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.HashSet;
//import java.util.Set;
//import java.util.StringTokenizer;
//
//public class Main_학습체크5 {
//	
//	static int N;
//	static int[][] value;
//	static int maxValue = 0;
//	
//	public static void main(String[] args) throws IOException {
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		
//		int N = Integer.parseInt(br.readLine());
//		value = new int[N][3];
//		
//		for(int n=0; n<N; n++) {
//			st = new StringTokenizer(br.readLine(), " ");
//			value[n][0] = Integer.parseInt(st.nextToken());
//			value[n][1] = Integer.parseInt(st.nextToken());
//			value[n][2] = Integer.parseInt(st.nextToken());
//		}
//		
//		dfs(0, new HashSet<>());
//		
//		System.out.println(maxValue);
//		br.close();
//	}
//	
//	static void dfs(int idx, int nowValue, Set<Integer> chosen) {
//		if(idx == N) { // 모든 바구니에서 공을 선택 했음
//			maxValue = Math.max(nowValue, maxValue);
//			return;
//		}
//		
//        for(int i=0; i<K; i++) {
//            if(chosen.contains(drink[i][0]) && chosen.contains(drink[i][1])) {
//            	sum += value[i][]
//            }
//        }
//        maxDrink = Math.max(maxDrink, cnt);
//        return;
//
//        // 후보가 2N개라서 idx > 2N 되면 종료
//        if(idx > 2*N) return;
//
//        // 1) 선택
//        chosen.add(idx);
//        dfs(idx+1, chosen);
//
//        // 2) 선택 안 함
//        chosen.remove(idx);
//        dfs(idx+1, chosen);
//    }
//	
//
//}
