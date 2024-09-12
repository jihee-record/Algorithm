package SWEA.SWEA_IM.LED스위치켜기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LED스위치_이지희 {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 
		
		// 테스트 반복 시작
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());// 방의 개수
			
			int[] asis = new int[N+1]; // index : 방번호 asis : 현재 방의 상태
			//int[] tobe = new int[N+1]; // index : 방번호 tobe : 결과적으로 되어야 하는 상태 
			
			st = new StringTokenizer(br.readLine());
			int count = 0;
			for(int n=1; n<=N; n++) {
				//tobe[n] = Integer.parseInt(st.nextToken());
				// 어차피 앞에서부터 조작해줘야해. 왜냐면 앞에꺼는 뒤에꺼 누른다고 안바뀌니까 - 받자마자 스위치 조작
				// tobe 상태랑 asis 상태가 다르면 스위치를 눌러서 맞춰줘야해
				int tobe = Integer.parseInt(st.nextToken());
				if(tobe != asis[n]) {
					count ++;
					for(int i=n; i<=N; i=i+n) { // 배수인 것 마다
						asis[i] = asis[i] == 0 ? 1 : 0;
					}
				}
			}
			sb.append("#").append(t).append(" ").append(count).append("\n");
		}// test 종료
		
		System.out.println(sb.toString());
		br.close();
		
	}// main()

}//class
