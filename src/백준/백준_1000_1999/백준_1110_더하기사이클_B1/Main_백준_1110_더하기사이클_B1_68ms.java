
package 백준.백준_1000_1999.백준_1110_더하기사이클_B1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_1110_더하기사이클_B1_68ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		String[] str = new String[2];
		
		if(input.length() == 1) {
			str[0] = "0";
			str[1] = input;
		}else {
			str = input.split("");
		}
		int i=0;
		while(true) {
			i++;
			int num = Integer.parseInt(str[0]) + Integer.parseInt(str[1]);
			if(num < 10) {
				str[0] = str[1];
				str[1] = Integer.toString(num);
			}else {
				str[0] = str[1];
				str[1] = Integer.toString(num).split("")[1];
			}
			if(Integer.parseInt(input) == Integer.parseInt(str[0] + str[1])) {
				break;
			}
		}
		
		System.out.println(i);
		br.close();
	}
}
