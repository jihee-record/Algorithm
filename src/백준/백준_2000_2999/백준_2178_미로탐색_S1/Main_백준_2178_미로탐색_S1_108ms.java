package 백준.백준_2000_2999.백준_2178_미로탐색_S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_2178_미로탐색_S1_108ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        char[][] map = new char[N][M];
        for(int n=0; n<N; n++) {
        	String str = br.readLine();
        	for(int m=0; m<M; m++) {
        		map[n][m] = str.charAt(m);
        	}
        }
        
        int[][] count = new int[N][M];
        
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {0, 0}); // x, y
        count[0][0] = 1;
        
        while(!q.isEmpty()) {
        	int[] now = q.poll();
        	int x = now[0];
        	int y = now[1];
        	
        	if(x == N-1 && y == M-1) {
        		System.out.println(count[x][y]);
        		return;
        	}
        	
        	for(int i=0; i<4; i++) {
        		int nx = x + dx[i];
        		int ny = y + dy[i];
        		
        		if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
        		if(map[nx][ny] == '0' || count[nx][ny] != 0) continue;
        		
        		count[nx][ny] = count[x][y] + 1;
        		q.add(new int[] {nx, ny, count[nx][ny]});
        		
        	}
        	
        }
		br.close();
	}

}
