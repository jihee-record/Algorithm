package 백준.백준_28000_28999.백준_28455_unionMaplestory_B2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main_백준_28455_unionMaplestory_B2_80ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Integer> level = new ArrayList<>();
		int sumLevel = 0;
		int sumStat = 0;
		for(int i=0; i<n; i++) {
			level.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(level, Comparator.reverseOrder());
		for(int i=0; i<Math.min(42, level.size()); i++) {
			int l = level.get(i);
			sumLevel += l;
			if(l >= 250) sumStat += 5;
			else if (l >= 200) sumStat += 4;
			else if (l >= 140) sumStat += 3;
			else if (l >= 100) sumStat += 2;
			else if (l >= 60) sumStat += 1;
		}
		
		System.out.println(sumLevel + " " + sumStat);
		br.close();
	}
}
