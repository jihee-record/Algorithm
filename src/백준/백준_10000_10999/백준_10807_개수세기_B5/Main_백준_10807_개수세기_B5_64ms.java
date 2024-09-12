
package 백준.백준_10000_10999.백준_10807_개수세기_B5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_10807_개수세기_B5_64ms {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String[] inputArr = br.readLine().split(" ");
		String V = br.readLine();
		
		int count = 0;
		for(int i=0; i<N; i++) {
			if(inputArr[i].equals(V)) count++;
		}
		
		System.out.println(count);
		br.close();
	}
}