package A_TEST.SWEA_1824_혁진이의프로그램검증_D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

@SuppressWarnings("unchecked")
public class Solution_SWEA_1824_혁진이의프로그램검증_D4 {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int d, R, C, number, r, c;
	static String[][] commands;
	static Set<Integer>[][] already;
	
	static void nextCoordi() {
		r = (r + dr[d]) % R;
		c = (c + dc[d]) % C;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			boolean flag = true;
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			commands = new String[R][C];
			for(int n=0; n<R; n++) {
				commands[n] = br.readLine().split("");
			}

			already = new HashSet[R][C];
			for(int n=0; n<R; n++) {
				for(int m=0; m<C; m++) {
					already[n][m] = new HashSet<>();
				}
			}
			
			number = 0; // 초기값 0
			d = 3; // 초기 방향 오른쪽
			
			r=0; c=0; // 초기 좌표
			
			while(flag) {
				if(commands[r][c].equals("@")) {
					sb.append("YES");
					break;
				}
				
				switch(commands[r][c]) {
				case "0":
				case "1":
				case "2":
				
				case "3": 
				case "4": 
				case "5": 
				case "6": 
				case "7": 
				case "8": 
				case "9":
					number = Integer.parseInt(commands[r][c]);
					break;
				case "<":
					d = 2;
					break;
				case ">":
					d = 3;
					break;
				case "^":
					d = 0;
					break;
				case "v":
					d = 1;
					break;
				case "_":
					if(already[r][c].contains(number)) {
						sb.append("NO");
						flag = false;
					}else {
						already[r][c].add(number);
						if(number == 0) d = 3;
						else d = 2;
					}
					break;
				case "|":
					if(already[r][c].contains(number)) {
						sb.append("NO");
						flag = false;
					}else {
						already[r][c].add(number);
						if(number == 0) d = 1;
						else d = 0;
					}
					break;
				case "?":
					d = (int)(Math.random() * 4);
					break;
				case ".":
					break;
				case "+":
					if(number == 15) number = 0;
					else number ++;
					break;
				case "-":
					if(number == 0) number = 15;
					else number --;
				}
				
				nextCoordi();
			}
			
			sb.append("\n");
			
		}
		
		System.out.println(sb.toString());
		br.close();
	}

}
