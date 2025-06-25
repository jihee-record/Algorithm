package 백준.백준_2000_2999.백준_2309_일곱난쟁이_B1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main_백준_2309_일곱난쟁이_B1_104ms_tree {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] number = new int[9];
		int total = 0;
		for(int k=0; k<9; k++) {
			number[k] = Integer.parseInt(br.readLine());
			total += number[k];
		}
		
		int i, j=0;
		outloop:
		for(i=0; i<8; i++) {
			for(j=i+1; j<9; j++) {
				if(total - (number[i] + number[j]) == 100) {
					break outloop;
				}
			}
		}
		
		TreeSet<Integer> seven = new TreeSet<>();
		for(int k=0; k<9; k++) {
			if(k == i || k == j) {
				continue;
			}
			
			seven.add(number[k]);
		}
		
		for (int num: seven) {
			System.out.println(num);
		}
		
		br.close();
	}

}
