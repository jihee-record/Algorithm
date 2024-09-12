package SWEA.SWEA_1000_1999.SWEA_1861_정사각형방_D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1861_정사각형방_D4_이지희_152ms {
	public static class Room{
		int row, col;
		public Room() {}
		public Room(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int[][] room;
	static Room[] location;
	static int N;
	static int index; // 확인 중인 숫자
	
	static int search(int start) {
		index = start;
		int r = location[index].row; // 현재 위치 r
		int c = location[index].col; // 현재 위치 c

		boolean flag = true;
		while(flag) {
			for(int i=0; i<4; i++) {
				int newR = r + direction[i][0];
				int newC = c + direction[i][1];
				
				if(room[newR][newC] == index + 1) {
					r = newR;
					c = newC;
					index ++;
					break; // for 종료 > 다음 방 탐색
				}
				if(i == 3) flag = false; // 여기까지 왔다면 어디로도 못가는거야
			}//for i 종료
		}
		return index - start + 1;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine()); // 테케
		
		for(int t=1; t<=T; t++) { // 테케 반복
			N = Integer.parseInt(br.readLine());
			room = new int[N+2][N+2];
			
			int size = N*N;
			location = new Room[size+1]; // 각 숫자(index)별 위치, 각 entry의 숫자가 다르다는 것을 이용 
			
			for(int r=1; r<=N; r++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int c=1; c<=N; c++) {
					room[r][c] = Integer.parseInt(st.nextToken());
					location[room[r][c]] = new Room(r, c);
				}// for c 종료
			}// for r 종료
			
			int maxCount = 1;
			int roomNumber = 1;
			for(int i=1; i<=size; i++) {
				int count = search(i);
				if(maxCount < count) {
					maxCount = count;
					roomNumber = i;
				}
				i = index; //지금까지 놀러간 방 다음 방 번호
			}
			sb.append("#").append(t).append(" ").append(roomNumber).append(" ").append(maxCount).append("\n");
		}// for t 종료
		System.out.println(sb.toString());
		br.close();
	}//main()
}//class
