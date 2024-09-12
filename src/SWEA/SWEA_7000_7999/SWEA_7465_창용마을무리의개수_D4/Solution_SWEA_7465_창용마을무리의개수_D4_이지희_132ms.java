package SWEA.SWEA_7000_7999.SWEA_7465_창용마을무리의개수_D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 창용 마을에는 N명의 사람이 살고 있다.
 * 사람은 편의상 1번부터 N번 사람까지 번호가 붙어져 있다고 가정한다.
 * 두 사람은 서로를 알고 있는 관계일 수 있고, 아닐 수 있다.
 * 두 사람이 서로 아는 관계이거나 몇 사람을 거쳐서 알 수 있는 관계라면,
 * 이러한 사람들을 모두 다 묶어서 하나의 무리라고 한다.
 * 창용 마을에 몇 개의 무리가 존재하는지 계산하는 프로그램을 작성하라.
 */
public class Solution_SWEA_7465_창용마을무리의개수_D4_이지희_132ms {
	
	static int[] parent;
	static int N;
	
	// 초기화
	static void setInit() {
		parent = new int[N+1];
		// 초기에는 본인이 각 집합의 수장
		for(int n=1; n<=N; n++) {
			parent[n] = n;
		}
	}
	
	// x의 부모님 찾아주기 솔루션
	static int find(int x) {
		if(parent[x] == x) {
			return x;
		}
		
		return parent[x] = find(parent[x]);
	}
	
	// 어... 부모님이 합..쳐져..
	// 합집합
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x > y) parent[x] = y;
		else if(x < y) parent[y] = x;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// 테케
		int T = Integer.parseInt(br.readLine());
		
		// 테스트 반복
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());//사람수
			int M = Integer.parseInt(st.nextToken());//관계수
			
			setInit(); // 부모 초기화 ㅋ 
			
			// 관계 값 받기
			for(int m=0; m<M; m++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				// 합쳐 
				union(x, y);
			}// for m 종료
			
			// 다른 집합 세기
			Set<Integer> set = new HashSet<>();
			for(int n=1; n<=N; n++) {
				set.add(find(n));
			}
			
			sb.append("#").append(t).append(" ").append(set.size()).append("\n");
			
		}// for t 종료
		
		System.out.println(sb.toString());
		br.close();
	}
	
}
