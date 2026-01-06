package 백준.백준_9000_9999.백준_9291_스도쿠채점_S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_백준_9291_스도쿠채점_S4_136ms {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int[][] matrix;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			sb.append("Case ").append(t).append(": ");
			
			matrix = new int[9][9];
			for(int r=0; r<9; r++) {
				String line = br.readLine();
				while (line != null && line.trim().isEmpty()) { // 빈 줄/공백 줄 스킵
			        line = br.readLine();
			    }
				st = new StringTokenizer(line);
				for(int c=0; c<9; c++) {
					matrix[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			HashSet<Integer>[][] square = new HashSet[3][3];
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					square[i][j] = new HashSet<>();
				}
			}
			
			boolean flag = true;
			outloop:
			for(int i=0; i<9; i++) { // 행열
				HashSet<Integer> row = new HashSet<>(); // 가로줄
				HashSet<Integer> col = new HashSet<>(); // 세로줄
				for(int j=0; j<9; j++) {
					row.add(matrix[i][j]);
					col.add(matrix[j][i]);
					square[i/3][j/3].add(matrix[i][j]);
					
					if(row.size() <= j || col.size() <= j) { // 컷 
						flag = false;
						break outloop;
					}
				}
			}
			
			if(!flag) {
				sb.append("INCORRECT").append('\n');
				continue;
			}
			
			outloop:
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					if(square[i][j].size() < 9) {
						flag = false;
						break outloop;
					}
				}
			}
			
			sb.append(flag ? "CORRECT" : "INCORRECT").append('\n');
		}
		
		System.out.println(sb);
		br.close();
	}

}
