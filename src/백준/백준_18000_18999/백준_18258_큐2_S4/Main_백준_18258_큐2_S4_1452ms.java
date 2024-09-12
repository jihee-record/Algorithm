package 백준.백준_18000_18999.백준_18258_큐2_S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main_백준_18258_큐2_S4_1452ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Integer> qList = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			String[] input = br.readLine().split(" ");
			switch(input[0]) {
				case "push":
					qList.add(Integer.parseInt(input[1]));
					break;
				case "pop":
					if(qList.isEmpty()) {
						sb.append("-1\n");
					}else {
						int temp = qList.get(0); 
						sb.append(temp).append("\n");
						qList.remove(0);
					}
					break;
				case "size":
					sb.append(qList.size()).append("\n");
					break;
				case "empty":
					if(qList.isEmpty()) {
						sb.append("1\n");
					}else {
						sb.append("0\n");
					}
					break;
				case "front":
					if(qList.isEmpty()) {
						sb.append("-1\n");
					}else {
						sb.append(qList.get(0)).append("\n");
					}
					break;
				case "back":
					if(qList.isEmpty()) {
						sb.append("-1\n");
					}else {
						sb.append(qList.get(qList.size()-1)).append("\n");
					}
					break;
			}
		}
		
		System.out.println(sb);
		br.close();
	}
}
