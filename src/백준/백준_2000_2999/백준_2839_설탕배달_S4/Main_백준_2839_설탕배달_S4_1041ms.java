package 백준.백준_2000_2999.백준_2839_설탕배달_S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_2839_설탕배달_S4_1041ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int count = 0 ;
		
		int x = N/5;
		
		while(x >= 0) {
			int r = N - x * 5;
			if(r % 3 == 0) {
				count = x + (r / 3);
				break;
			}else {
				x--;
			}
		}
		
		if(x < 0) System.out.println(-1);
		else System.out.println(count);
		br.close();
	}

}
