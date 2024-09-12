package 백준.백준_11000_11999.백준_11203_numbersOnATree_S5;

import java.io.*;

public class Main_백준_11203_numberOnATree_S5_80ms {
	/*
	 * h = 높이
	 * now : '나' 현재 번호 (시작번호 = 루트노드)
	 * i = R 이동 횟수 (오른쪽으로 이동한 횟수)
	 * k = 현재 내 층수
	 */
	public static void main(String[] args) throws IOException {     
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// inputArr : 입력 " "(공백)으로 쪼갠 배열
		// [0]:높이, [1]:이동(LR--)
		String[] inputArr = br.readLine().split(" ");
		int h = Integer.parseInt(inputArr[0]);
		long now = (long)Math.pow(2, h+1) -1;
		
		// 이동이 있을때만, length = 0 : 이동 없음
		if(inputArr.length > 1) {
			// moveArr : 이동방향 배열
			String[] moveArr = inputArr[1].split("");
			long i = 1;
			for(int k=0; k<moveArr.length; k++) {	
				if(moveArr[k].equals("L")) {	// L 이동
					now = now - (long)Math.pow(2, k) -i +1;
					i = i*2 -1;
				}else {	// R 이동
					now = now - (long)Math.pow(2, k) -i;
					i = i*2;
				}
			}
		}
		System.out.println(now);
		br.close();
	}
}
