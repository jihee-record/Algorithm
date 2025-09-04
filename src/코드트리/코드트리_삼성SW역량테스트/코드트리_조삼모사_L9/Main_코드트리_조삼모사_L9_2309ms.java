package 코드트리.코드트리_삼성SW역량테스트.코드트리_조삼모사_L9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 조합
public class Main_코드트리_조삼모사_L9_2309ms {
	static int N, minP;
	
	static void combination(int idx, int[][] P, Set<Integer> am, Set<Integer> pm, int amSum, int pmSum) {
		if(am.size() == N / 2 && pm.size() == N / 2) {
			minP = Math.min(minP, Math.abs(amSum - pmSum));
			return;
		}

		if(idx >= N) return;
		if(am.size() > N / 2 || pm.size() > N /2) return ;
		
		int amPlus = 0;
		for(int a : am) {
			amPlus += P[a][idx];
			amPlus += P[idx][a];
		}
		am.add(idx);
		combination(idx + 1, P, am, pm, amSum + amPlus, pmSum);
		am.remove(idx);
		
		int pmPlus = 0;
		for(int b : pm) {
			pmPlus += P[b][idx];
			pmPlus += P[idx][b];
		}
		pm.add(idx);
		combination(idx + 1, P, am, pm, amSum, pmSum + pmPlus);
		pm.remove(idx);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		int[][] P = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				P[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		minP = Integer.MAX_VALUE;
		combination(0, P, new HashSet<Integer>(), new HashSet<Integer>(), 0, 0);
		
		System.out.println(minP);
		br.close();
	}

}
