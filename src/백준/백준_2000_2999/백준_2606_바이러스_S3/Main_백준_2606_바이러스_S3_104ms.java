package 백준.백준_2000_2999.백준_2606_바이러스_S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_2606_바이러스_S3_104ms {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int R = Integer.parseInt(br.readLine());
		
		ArrayList<Integer>[] coms = new ArrayList[N+1];
		for(int n=1; n<=N; n++) {
			coms[n] = new ArrayList<>();
		}
		
		for(int r=0; r<R; r++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			coms[a].add(b);
			coms[b].add(a);
		}
		
		boolean[] visited = new boolean[N+1];
		Queue<Integer> q = new ArrayDeque<>();
		q.add(1);
		
		while(!q.isEmpty()) {
			int me = q.poll();
			
			if(!visited[me]) {
				q.addAll(coms[me]);
				visited[me] = true;
			}
		}
		
		int count = 0;
		for(int n=2; n<=N; n++) {
			if(visited[n]) count++;
		}
		
		System.out.println(count);
		br.close();
	}

}
