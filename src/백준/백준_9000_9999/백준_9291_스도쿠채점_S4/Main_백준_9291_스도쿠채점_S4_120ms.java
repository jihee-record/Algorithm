package 백준.백준_9000_9999.백준_9291_스도쿠채점_S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_9291_스도쿠채점_S4_120ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			boolean[][] col = new boolean[9][10];
			boolean[][] square = new boolean[9][10]; // square 9개

			boolean flag = true;
			for(int r=0; r<9; r++) {
				st = new StringTokenizer(br.readLine());
				
				if(!flag) continue;
				
				boolean[] row = new boolean[10]; // 지금 살펴볼 행
				int squareR = (r/3) * 3; // 박스 몇번째 행
				for(int c=0; c<9; c++) {
					int v = Integer.parseInt(st.nextToken()); // value
					int s = squareR + c/3; // 
					if(row[v] || col[c][v] || square[s][v]) {
						flag = false;
						break;
					}
					
					row[v] = true;
					col[c][v] = true;
					square[s][v] = true;
				}
			}
			
			sb.append("Case ").append(t).append(": ").append(flag ? "CORRECT" : "INCORRECT").append('\n');
			
			if(t < T) br.readLine();
		}
		
		System.out.println(sb);
		br.close();
	}

}
