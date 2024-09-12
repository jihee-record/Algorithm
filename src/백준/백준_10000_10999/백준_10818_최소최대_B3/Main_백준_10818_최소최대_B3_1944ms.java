package 백준.백준_10000_10999.백준_10818_최소최대_B3;

import java.util.Arrays;
import java.util.Scanner;

public class Main_백준_10818_최소최대_B3_1944ms {
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		int num = sc.nextInt();
		
		int[] arr = new int[num];
		for(int i=0; i<num; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		System.out.println(arr[0] + " " + arr[num-1]);
		sc.close();
	}
}
