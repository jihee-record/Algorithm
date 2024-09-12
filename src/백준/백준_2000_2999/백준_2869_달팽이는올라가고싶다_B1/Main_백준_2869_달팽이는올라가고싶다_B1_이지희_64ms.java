package 백준.백준_2000_2999.백준_2869_달팽이는올라가고싶다_B1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2869_달팽이는올라가고싶다_B1_이지희_64ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		if((V-B)%(A-B) != 0) System.out.println(((V-B)/(A-B)) + 1);
		else System.out.println(((V-B)/(A-B)));
		br.close();
	}
}
