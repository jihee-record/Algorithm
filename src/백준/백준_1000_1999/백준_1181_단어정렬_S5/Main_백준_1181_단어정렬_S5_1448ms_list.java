package 백준.백준_1000_1999.백준_1181_단어정렬_S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main_백준_1181_단어정렬_S5_1448ms_list {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
        	String str = br.readLine();
        	if(!list.contains(str)) {
        		list.add(str);
        	}
        }
        
        Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				if(a.length() != b.length()) {
					return Integer.compare(a.length(), b.length());
				}else {
					return a.compareTo(b);
				}
			}
		});
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<list.size(); i++) {
        	sb.append(list.get(i)).append("\n");
        }
        
        System.out.println(sb);
        br.close();
    }
}
