package 백준.백준_2000_2999.백준_2579_계단오르기_S3;

import java.io.*;

public class Main_백준_2579_계단오르기_S3_64ms {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		//계단의 개수 최대 300
		int[] point = new int[301];
		int[] score = new int[301];
		
		for(int i=1; i<=n; i++) {
			point[i] = Integer.parseInt(br.readLine());
		}
		
		score[1] = point[1];
		score[2] = point[2] + score[1];
		
		for(int i=3; i<=n; i++) {
			score[i] = point[i] + Math.max(point[i-1]+score[i-3], score[i-2]);
		}
		
		System.out.println(score[n]);
		
		br.close();
	}

}