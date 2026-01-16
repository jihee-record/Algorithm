package 백준.백준_9000_9999.백준_9466_텀프로젝트_G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_백준_9466_텀프로젝트_G3_1172ms {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		while(T --> 0) {
			int N = Integer.parseInt(br.readLine());
			int[] choice = new int[N+1];
			boolean[] visited = new boolean[N+1];
			boolean[] finished = new boolean[N+1];
			int cycleCnt = 0;
			
			st = new StringTokenizer(br.readLine());
			for(int n=1; n<=N; n++) choice[n] = Integer.parseInt(st.nextToken());
			
			for(int n=1; n<=N; n++) {
				if(visited[n]) continue;
			
				ArrayList<Integer> path = new ArrayList<>();
				int now = n;
				
				while(!visited[now]) {
					path.add(now);
					visited[now] = true;
					now = choice[now];
				}
				
				// 방문했던 애를 만남
				//사이클
				if(!finished[now]) { // 현재 경로에서 만난 사이클이 됨
					int v = now; // 사이클 길이 세기
					int cnt = 1;
					v = choice[v];
					while(v != now) { // 만난때까지
						cnt++;
						v = choice[v];
					}
					cycleCnt += cnt;
				}
				
				for(int i: path) finished[i] = true; // 완료
				
			}
			
			sb.append(N - cycleCnt).append('\n');
		}
		
		System.out.println(sb);
		br.close();
	}

}
