package 백준.백준_11000_11999.백준_11203_numbersOnATree_S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_11203_numberOnATree_S5_80ms2 {
	/*
	 * inputArr : 입력배열 ([0] : 높이, [1] : 이동경로
	 * moveArr : 이동방향배열
	 *  
	 * h = 높이
	 * root : 루트노드번호
	 * i = 루트 위치를 1번이라고 할 때 현재 위치
	 */
	public static void main(String[] args) throws IOException {     
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputArr = br.readLine().split(" ");
		int h = Integer.parseInt(inputArr[0]);
		long root = (long)Math.pow(2, h+1) -1;
		long i = 1;
		if(inputArr.length > 1) {
			String[] moveArr = inputArr[1].split("");
			for(int k=0; k<moveArr.length; k++) {	
				if(moveArr[k].equals("L")) {
					i = i*2;
				}else {
					i = i*2 + 1;
				}
			}
		}
		System.out.println(root - i + 1);
		br.close();
	}
}
