package 백준.백준_17000_17999.백준_17254_키보드이벤트_S4;

import java.io.*;
import java.util.*;

public class Main_백준_17254_키보드이벤트_S4_284ms_pq {
	
	static class Input{
		int keyboard;
		int time;
		String alphabet;
		
		Input(int keyboard, int time, String alphabet){
			this.keyboard = keyboard;
			this.time = time;
			this.alphabet = alphabet;
		}
	}
	
	/*
	 * n : 키보드 개수
	 * m : 키보드 누르는 횟수
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] cntArr = br.readLine().split(" ");
		//int n = Integer.parseInt(cntArr[0]);
		int m = Integer.parseInt(cntArr[1]);
		
		// 시간 우선, 동시에 눌렀으면 키보드 번호가 작은 것부터
		PriorityQueue<Input> pq = new PriorityQueue<>((a,b) -> {
			if (a.time != b.time) {
                return Integer.compare(a.time, b.time); 
            } else {
                return Integer.compare(a.keyboard, b.keyboard); 
            }
		});
		
		for(int i=0; i<m; i++) {
			String[] inputArr = br.readLine().split(" ");
			int keyboard = Integer.parseInt(inputArr[0]);
			int time = Integer.parseInt(inputArr[1]);
			String alphabet = inputArr[2];

			Input input = new Input(keyboard, time, alphabet);
			pq.add(input);
		}
		
		while(!pq.isEmpty()) {
			Input input = pq.poll();
			System.out.print(input.alphabet);
		}
		br.close();
	}
}
