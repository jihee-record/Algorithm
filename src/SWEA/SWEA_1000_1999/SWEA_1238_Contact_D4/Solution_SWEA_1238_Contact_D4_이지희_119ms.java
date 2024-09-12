package SWEA.SWEA_1000_1999.SWEA_1238_Contact_D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

@SuppressWarnings("unchecked")
public class Solution_SWEA_1238_Contact_D4_이지희_119ms {
	static int N, S; // N : 길이 S : 시작점
	static LinkedList<Integer> adj[];
	static int[] rank;
	static void contact(int s){
		Queue<Integer> queue = new LinkedList<>();
		rank[s] = 1;
		queue.add(s);
		while(!queue.isEmpty()) {
			s = queue.poll();
			for(int n : adj[s]) {
				if(rank[n] == -1) {
					rank[n] = rank[s] + 1;
					queue.add(n);
				}
			}
		}
	}
	
	static int lastMember() {
		int last = 1; 
		for(int i=1; i<=100; i++) {
			if(rank[last] <= rank[i]) last = i;
		}
		return last;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int t=1; t<=10; t++) { // 테스트 케이스
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			int relCnt = N/2;
			adj = new LinkedList[101]; // 숫자가 100까지라고 하네
			rank = new int[101];
			Arrays.fill(rank, -1);
			for(int i=1; i<=100; i++) {
				adj[i] = new LinkedList<>(); // 점.
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<relCnt; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adj[from].add(to); // from 점에 연결되는 to 간선 추가
			}
			contact(S);
			sb.append("#").append(t).append(" ").append(lastMember()).append("\n");
		}// for t 종료
		
		System.out.println(sb.toString());
		br.close();
	}// main()
}// class
