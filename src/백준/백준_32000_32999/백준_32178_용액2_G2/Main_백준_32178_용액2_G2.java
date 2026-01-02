package 백준.백준_32000_32999.백준_32178_용액2_G2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 0에 가까운 구간합 
public class Main_백준_32178_용액2_G2 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N+1][N+1];
		
		int ev = Integer.MAX_VALUE;
		int absEv = Integer.MAX_VALUE;
		int l = 0, r = 0;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n=1; n<=N; n++) {
			arr[n][n] = Integer.parseInt(st.nextToken());
			for(int j=1; j<n; j++) {
				arr[n-j][n] = arr[n-j+1][n] + arr[n-j][n-j];
				if(Math.abs(arr[n-j][n]) < absEv) {
					ev = arr[n-j][n];
					absEv = Math.abs(ev);
					l = n-j;
					r = n;
				}
			}
		}
		
		sb.append(ev).append("\n").append(l).append(" ").append(r);
		System.out.println(sb.toString());
		br.close();
	}
}
