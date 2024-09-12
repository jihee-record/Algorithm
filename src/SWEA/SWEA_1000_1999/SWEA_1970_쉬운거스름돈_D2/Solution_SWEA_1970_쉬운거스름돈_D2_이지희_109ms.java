package SWEA.SWEA_1000_1999.SWEA_1970_쉬운거스름돈_D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;


// 어차피 돈의 종류는 정해져 있고 많지 않고 그래서 배열 안쓰고 직접 계산
public class Solution_SWEA_1970_쉬운거스름돈_D2_이지희_109ms {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(1000);
		//테케
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) { //테케 반복
			int N = Integer.parseInt(br.readLine()); //돈의 금액
			sb.append("#").append(t).append("\n").append(N/50000).append(" ");
			N %= 50000;
			sb.append(N/10000).append(" ");
			N %= 10000;
			sb.append(N/5000).append(" ");
			N %= 5000;
			sb.append(N/1000).append(" ");
			N %= 1000;
			sb.append(N/500).append(" ");
			N %= 500;
			sb.append(N/100).append(" ");
			N %= 100;
			sb.append(N/50).append(" ");
			N %= 50;
			sb.append(N/10).append("\n");
		}// for t  종료
		
		System.out.println(sb.toString());
		br.close();
	}// main()
}// class
