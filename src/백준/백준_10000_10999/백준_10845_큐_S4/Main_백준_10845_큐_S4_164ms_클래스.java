package 백준.백준_10000_10999.백준_10845_큐_S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_10845_큐_S4_164ms_클래스 {
	
	static class CustomQueue {
		int[] arr;
		int head = 0;
		int rear = 0; //다음위치 
		
		public CustomQueue(int N) {
			arr = new int[N];
		}
		
		void push(int x) {
			arr[rear++] = x;
		}
		
		int pop() {
			return size() == 0 ? -1 : arr[head++];
		}
		
		int size() {
			return rear - head;
		}
		
		int empty() {
			return size() == 0 ? 1 : 0;
		}
		
		int front() {
			return size() == 0 ? -1 : arr[head];
		}
		
		int back() {
			return size() == 0 ? -1 : arr[rear - 1];
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		CustomQueue queue = new CustomQueue(N);
		
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			
			switch(st.nextToken()) {
			case "push":
				queue.push(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				sb.append(queue.pop()).append("\n");
				break;
			case "size":
				sb.append(queue.size()).append("\n");
				break;
			case "empty":
				sb.append(queue.empty()).append("\n");
				break;
			case "front":
				sb.append(queue.front()).append("\n");
				break;
			case "back":
				sb.append(queue.back()).append("\n");
				break;
			}
		}
		
		System.out.println(sb.toString());
		br.close();
	}

}
