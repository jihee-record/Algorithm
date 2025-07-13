package 백준.백준_1000_1999.백준_1406_에디터_S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main_백준_1406_에디터_S2_620ms_ListIterator {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		LinkedList<Character> list = new LinkedList<>();
		String str = br.readLine();
		for(char c : str.toCharArray()) {
			list.add(c);
		}
		
		ListIterator<Character> it = list.listIterator(list.size());
		
		int N = Integer.parseInt(br.readLine());
		while(N --> 0) {
			String[] command = br.readLine().split(" ");
			
			switch(command[0]) {
			case "L":
				if(it.hasPrevious()) it.previous();
				break;
			case "D":
				if(it.hasNext()) it.next();
				break;
			case "B": /////////////////////////// backspace
				if(it.hasPrevious()) {
					it.previous();
					it.remove();
				}
				break;
			case "P":
				it.add(command[1].charAt(0));
				break;
			}
		}
		
		for(char c : list) sb.append(c);
		System.out.println(sb.toString());
		br.close();
	}

}
