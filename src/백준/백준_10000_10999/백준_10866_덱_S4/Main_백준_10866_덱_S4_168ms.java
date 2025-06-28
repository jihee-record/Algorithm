package 백준.백준_10000_10999.백준_10866_덱_S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_10866_덱_S4_168ms {
	
	static class CustomDeque {
		int[] arr;
		int head;
		int rear;
		
		CustomDeque(int N){
			arr = new int[2*N]; // N이 처음 그 앞에 붙이면 N-1 뒤에 붙이면 N+1
			head = N; // 현재 가장 앞 원소 위치 
			rear = N; // 가장 뒤 원소 다음 위치
		}
		
		void push_front(int x) {
			arr[--head] = x;
		}
		
		void push_back(int x) {
			arr[rear++] = x;
		}
		
		int size() {
			return rear - head;
		}
		
		int empty() {
			return size() == 0 ? 1 : 0;
		}
		
		int pop_front() {
			return empty() == 1 ? -1 : arr[head++];
		}
		
		int pop_back() {
			return empty() == 1 ? -1 : arr[--rear];
		}
		
		int front() {
			return empty() == 1 ? -1 : arr[head];
		}
		
		int back() {
			return empty() == 1 ? -1 : arr[rear - 1];
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		CustomDeque deq = new CustomDeque(N);
		
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			
			switch(st.nextToken()) {
			case "push_front":
				deq.push_front(Integer.parseInt(st.nextToken()));
				break;
			case "push_back":
				deq.push_back(Integer.parseInt(st.nextToken()));
				break;
			case "size":
				sb.append(deq.size()).append("\n");
				break;
			case "empty":
				sb.append(deq.empty()).append("\n");
				break;
			case "pop_front":
				sb.append(deq.pop_front()).append("\n");
				break;
			case "pop_back":
				sb.append(deq.pop_back()).append("\n");
				break;
			case "front":
				sb.append(deq.front()).append("\n");
				break;
			case "back":
				sb.append(deq.back()).append("\n");
				break;
			}
		}
		
		
		System.out.println(sb.toString());
		br.close();
		
	}

}
