package 백준.백준_13000_13999.백준_13458_시험감독_B2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_13458_시험감독_B2_408ms_BufferedReader {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n=0; n<N; n++) 
			A[n] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		long result = N; //N개의 시험장에 반드시 총감독은 있으므로 최소 N명
		for(int n=0; n<N; n++) {
			
			A[n] -= B; //B명은 총감독이 감독해 //나머지 부감독이 몇명 필요할지
			if(A[n]<= 0) continue;
			result += A[n]/C; // C명씩 감독관이 나눠 받아
			if(A[n]%C > 0) result++; // 안나눠떨어지면 한명더 있어야지
		}
		
		System.out.println(result);
		br.close();
	}

}
