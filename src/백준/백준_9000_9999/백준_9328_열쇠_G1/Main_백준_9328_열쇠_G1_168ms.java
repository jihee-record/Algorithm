package 백준.백준_9000_9999.백준_9328_열쇠_G1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

// 와ㅏㅏㅏ 예제 계속 틀려서 한참 봤는데 초기 이후 queue 에 아무것도 추가하지 않음 
// 시간 초과 : 건물 출입구 다 저장했지만, 분리된 출입구 아니면 중복이 너무 발생함 <- 패딩
public class Main_백준_9328_열쇠_G1_168ms {
	static int H, W;
	static char[][] map;
	static int[] dh = {-1, 1, 0, 0};
	static int[] dw = {0, 0, -1, 1};
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		while(T --> 0) {
//			System.out.println("TEST " + t);
			st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			// 좌우 패딩
			int HP = H + 2, WP = W + 2;
			map = new char[HP][WP];
			Arrays.fill(map[0], '.');
			Arrays.fill(map[HP - 1], '.');
			
			for(int h=1; h<=H; h++) {
				Arrays.fill(map[h], '.');
				String input = br.readLine();
				for(int w=1; w<=W; w++) {
					map[h][w] = input.charAt(w - 1);
				}
			}
			
			String keyInput = br.readLine();
			boolean[] hasKey = new boolean[26];
			if(!keyInput.equals("0")) {
//				System.out.print("열쇠 추가) ");
				for(int i=0; i<keyInput.length(); i++) {
					int c = keyInput.charAt(i) - 'a'; // 0 ~ 25 
					hasKey[c] = true;
//					System.out.print(c + ", ");
				}
//				System.out.println();
			}
			
			
				
			ArrayDeque<int[]>[] doors = new ArrayDeque[26];
			for(int i=0; i<26; i++) doors[i] = new ArrayDeque<>(); // 열쇠 1개당 문이 여러개일 수 있고, 들어가지 못한 문만 기록
			
			boolean[][] visited = new boolean[HP][WP];
			ArrayDeque<int[]> queue = new ArrayDeque<>();
			visited[0][0] = true;
			queue.add(new int[] {0, 0});

			int cnt = 0;
			
			while(!queue.isEmpty()) {
				int[] now = queue.poll();
				int h = now[0];
				int w = now[1];
				
				char c = map[h][w];
				
				if(c == '*') continue;
//						System.out.println(h+"-"+w+": "+c);
				if(c >= 'A' && c <= 'Z') { // 문
					int k = c - 'A';
					if(!hasKey[k]) {
						doors[k].add(new int[] {h, w});
						continue; // 문이고 열쇠가 없으면 못 들어감  
					}
				}
				
				else if(c >= 'a' && c <= 'z') { // 열쇠 갈취
					int k = c - 'a';
					hasKey[k] = true;
					while(!doors[k].isEmpty()) {
						int[] door = doors[k].poll();
						visited[door[0]][door[1]] = true;
						queue.add(door);
					}
				}

				else if(c == '$') cnt++; // 서류

				map[h][w] = '.';  // 막힌 곳 빼고 문 열었거나, 열쇠를 가져갔거나, 서류를 훔쳤거나 이젠 볼일 없이 그냥 통로로 변신 
				
				for(int d=0; d<4; d++) {
					int nh = h + dh[d];
					int nw = w + dw[d];
//							System.out.println(nh + ", " + nw);
					if(nh < 0 || nh >= HP || nw < 0 || nw >= WP) continue;
//							System.out.println(map[nh][nw] + " :" + visited[nh][nw]);
					if(visited[nh][nw]) continue;
					if(map[nh][nw] == '*') continue;

					visited[nh][nw] = true;
					queue.add(new int[] {nh, nw});
				}
			}
			
			sb.append(cnt).append('\n');
		}
		
		System.out.println(sb);
		br.close();
	}

}
