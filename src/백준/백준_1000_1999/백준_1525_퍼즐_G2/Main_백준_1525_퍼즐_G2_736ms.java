package 백준.백준_1000_1999.백준_1525_퍼즐_G2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_백준_1525_퍼즐_G2_736ms {
	static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		String ans = "123456780";
		String puzzle = ""; 
		for(int r=0; r<3; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<3; c++) {
				puzzle = puzzle + st.nextToken(); // 012345678
			}
		}
		
		HashMap<String, Integer> solving = new HashMap<>();
		solving.put(puzzle, 0);
		
		ArrayDeque<String> queue = new ArrayDeque<>();
		queue.add(puzzle);
		
		while(!queue.isEmpty()) {
			String now = queue.poll();
			int cnt = solving.get(now);
			
			if(now.equals(ans)) {
			    System.out.println(cnt);
			    return;
			}
			
			int idx = now.indexOf("0");
			
			int r = idx / 3;
			int c = idx % 3;
			
			for(int d=0; d<4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr < 0 || nr >= 3 || nc < 0 || nc >= 3) continue;
				
				int nIdx = nr * 3 + nc;
				
				char[] arr = now.toCharArray();
				char temp = now.charAt(nIdx);
				arr[nIdx] = arr[idx];
				arr[idx] = temp;
				
				String nxt = new String(arr);
				if(!solving.containsKey(nxt)) {
					queue.add(nxt);
					solving.put(nxt, cnt + 1);
				}
			}
		}
		
		System.out.println(-1);
		br.close();
	}

}
