package 백준.백준_11000_11999.백준_11650_좌표정렬하기_S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main_백준_11650_좌표정렬하기_S5_904ms_treeset {
	
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
        TreeSet<Coordinates> tree = new TreeSet<>((a,b) -> {
        	if(a.x != b.x) {
				return Integer.compare(a.x, b.x);
			}else {
				return Integer.compare(a.y, b.y);
			}
		});
        for(int i=0; i<n; i++) {
        	String[] coordiArr = br.readLine().split(" ");
			int x = Integer.parseInt(coordiArr[0]);
			int y = Integer.parseInt(coordiArr[1]);
			Coordinates coordi = new Coordinates(x, y);
			tree.add(coordi);
        }
        
        
        StringBuilder sb = new StringBuilder();
        while(!tree.isEmpty()) {
        	Coordinates coordi = tree.pollFirst();
        	sb.append(coordi.x).append(" ").append(coordi.y).append("\n");
		}
        
        System.out.println(sb);
        br.close();
    }
}
