package SWEA.SWEA_1000_1999.SWEA_1230_암호문3_D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_SWEA_1230_암호문3_D3_이지희 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// 테스트케이스 10개
		for(int t=1; t<=10; t++) {
			int N = Integer.parseInt(br.readLine()); // 암호문 개수
			
			st = new StringTokenizer(br.readLine());
			List<String> list = new LinkedList<>(); // 암호문 리스트
			for(int n=0; n<N; n++) {
				list.add(st.nextToken());
			}// n 반복 종료
			
			int Cmd = Integer.parseInt(br.readLine()); // 명령어 개수
			st = new StringTokenizer(br.readLine());
			for(int cmd=0; cmd<Cmd; cmd++) {
				String keyword = st.nextToken();
				switch(keyword) {
				case "I": // 삽입
					int X = Integer.parseInt(st.nextToken());
					int Y = Integer.parseInt(st.nextToken());
					for(int y=0; y<Y; y++) {
						list.add(X+y, st.nextToken()); 
					}
					break;
				case "D":
					X = Integer.parseInt(st.nextToken());
					Y = Integer.parseInt(st.nextToken());
					for(int y=0; y<Y; y++) {
						list.remove(X); 
					}
					break;
				case "A":
					Y = Integer.parseInt(st.nextToken());
					for(int y=0; y<Y; y++) {
						list.add(st.nextToken()); 
					}
					break;
				} // 명령어 switch
			}// cmd 반복 종료
			
			sb.append("#").append(t);
			for(int i=0; i<10; i++) {
				sb.append(" ").append(list.get(i));
			}
			sb.append("\n");
			
		} // t 반복 종료
		
		System.out.println(sb.toString());
		br.close();
	}
}
