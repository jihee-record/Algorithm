package 백준.백준_10000_10999.백준_10798_세로읽기_B1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_10798_세로읽기_B1_이지희_68ms {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[][] input = new String[5][15];
		int colMax = 1; // 최대 열 개수
		for(int i=0; i<5; i++) {
			String[] temp = br.readLine().split("");
			colMax = Math.max(colMax, temp.length);
			for(int j=0; j<temp.length; j++) {
				input[i][j] = temp[j];
			}
		}
		
		for(int c=0; c<colMax; c++) {
			for(int r=0; r<5; r++) {
				if(input[r][c] != null) {
					sb.append(input[r][c]);
				}
			}
		}
		
		System.out.println(sb.toString());
	}
	
}
