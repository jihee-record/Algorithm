package SWEA.SWEA_Event.No2_SSAFY에간임스;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_No2_SSAFY에간임스_191ms_array {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		String[][] skills = new String[N][2];
		
		for(int n=0; n<N; n++) {
			skills[n] = br.readLine().split(" ");
		}
		
		Arrays.sort(skills, (o1, o2) -> {
			int order1 = Integer.parseInt(o1[1]);
			int order2 = Integer.parseInt(o2[1]);
			if(order1 != order2) return order1 - order2;
			else return o1[0].compareTo(o2[0]);
		});
		
		for(int n=0; n<N; n++) {
			sb.append(skills[n][0]).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}

}
