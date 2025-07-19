package 백준.백준_1000_1999.백준_1080_행렬_S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1080_행렬_S1_100ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        char[][] A = new char[N][M];
        for(int n=0; n<N; n++) {
        	String str = br.readLine();
        	for(int m=0; m<M; m++) {
        		A[n][m] = str.charAt(m);
        	}
        }
        
        char[][] B = new char[N][M];
        for(int n=0; n<N; n++) {
        	String str = br.readLine();
        	for(int m=0; m<M; m++) {
        		B[n][m] = str.charAt(m);
        	}
        }
		
		int cnt = 0;
		boolean can = true;
		outloop:
		for(int n=0; n<N; n++) {
			for(int m=0; m<M; m++) {
				if(A[n][m] != B[n][m]) {
					if(n+2 >= N || m+2 >= M) {
						can = false;
						break outloop;
					}
					cnt++;
					for(int i=n; i<n+3; i++) {
						for(int j=m; j<m+3; j++) {
							if(A[i][j] == '0') A[i][j] = '1';
							else A[i][j] = '0';
						}
					}
				}
			}
		}
		
		if(!can) cnt = -1;
		System.out.println(cnt);
		br.close();
	}

}
