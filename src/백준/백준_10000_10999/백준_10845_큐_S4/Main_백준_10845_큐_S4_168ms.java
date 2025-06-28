package 백준.백준_10000_10999.백준_10845_큐_S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_10845_큐_S4_168ms {
	
	static StringBuilder sb;
	
	static int[] queue;
	static int head = 0;
	static int rear = 0; //다음위치 
	
	static void push(int x) {
		queue[rear] = x;
		rear++;
	}
	
	// 앞에 있는 정수 빼기
	static int pop() {
		if(size() == 0) return -1;
		
		int x = queue[head];
		head++;
		return x;
	}
	
	static int size() {
		return rear - head;
	}
	
	static int empty() {
		return size() == 0 ? 1 : 0;
	}
	
	static int front() {
		if(size() == 0) return -1;
		return queue[head];
	}
	
	static int back() {
		if(size() == 0) return -1;
		return queue[rear-1];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		queue = new int[N];
		
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			
			switch(st.nextToken()) {
			case "push":
				push(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				sb.append(pop()).append("\n");
				break;
			case "size":
				sb.append(size()).append("\n");
				break;
			case "empty":
				sb.append(empty()).append("\n");
				break;
			case "front":
				sb.append(front()).append("\n");
				break;
			case "back":
				sb.append(back()).append("\n");
				break;
			}
		}
		
		System.out.println(sb.toString());
		br.close();
	}

}
