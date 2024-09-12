package 백준.백준_17000_17999.백준_17608_막대기_B2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_백준_17608_막대기_B2_224ms_list {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 막대기의 길이 list
		List<Integer> list = new ArrayList<>();
		// 막대기의 개수
		int n = Integer.parseInt(br.readLine());
		// n개 막대기의 길이 (왼쪽부터 list.[0])
		for(int i=0; i<n; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		// 가장 오른쪽(list의 마지막) 막대기부터 지금까지 막대 길이의 최대값
		int max = 0;
		// 지금까지 보이는 막대 개수
		int count = 0;
		
		for(int i=n-1; i>=0; i--) {
			// 지금까지 막대길이보다 긴 막대면 보일 것이다(count++)
			if(list.get(i) > max) {
				count++;
				max = list.get(i);
			}
		}
		
		System.out.println(count);
		br.close();
	}
}
