package 백준.백준_2000_2999.백준_2295_세수의합_G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main_백준_2295_세수의합_G4_292ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // N >= 5
		int[] arr = new int[N];
		
		for(int n=0; n<N; n++) {
			arr[n] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		HashSet<Integer> set = new HashSet<>();
		for(int n=0; n<N; n++) {
			for(int m=n; m<N; m++) {
				set.add(arr[n] + arr[m]);
			}
		}
		
		for(int n=N-1; n>0; n--) {
			for(int k=n-1; k>=0; k--) {
				if(set.contains(arr[n]-arr[k])) {
					System.out.println(arr[n]);
					return;
				}
			}
		}
		
		br.close();
	}

}
