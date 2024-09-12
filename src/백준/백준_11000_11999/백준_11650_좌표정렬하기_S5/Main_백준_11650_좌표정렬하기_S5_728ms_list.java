package 백준.백준_11000_11999.백준_11650_좌표정렬하기_S5;

import java.io.*;
import java.util.*;

public class Main_백준_11650_좌표정렬하기_S5_728ms_list {
	
	static class Coordinates {
		int x;
		int y;
		
		Coordinates(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Coordinates> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
        	String[] coordiArr = br.readLine().split(" ");
			int x = Integer.parseInt(coordiArr[0]);
			int y = Integer.parseInt(coordiArr[1]);
			Coordinates coordi = new Coordinates(x, y);
			list.add(coordi);
        }
        
        Collections.sort(list, new Comparator<Coordinates>() {
			@Override
			public int compare(Coordinates a, Coordinates b) {
				if(a.x != b.x) {
					return Integer.compare(a.x, b.x);
				}else {
					return Integer.compare(a.y, b.y);
				}
			}
		});
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<list.size(); i++) {
        	sb.append(list.get(i).x).append(" ").append(list.get(i).y).append("\n");
        }
        
        System.out.println(sb);
        br.close();
    }
}
