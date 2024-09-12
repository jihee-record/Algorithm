package 백준.백준_2000_2999.백준_2752_세수정렬_B4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_2752_세수정렬_B4_80ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sArr = br.readLine().split(" ");
		int[] iArr = new int[3];
		iArr[0] = Integer.parseInt(sArr[0]);
		iArr[1] = Integer.parseInt(sArr[1]);
		iArr[2] = Integer.parseInt(sArr[2]);
		Arrays.sort(iArr);
		for(int i=0; i<3; i++) {
			System.out.print(iArr[i] + " ");
		}
		br.close();
	}
}
