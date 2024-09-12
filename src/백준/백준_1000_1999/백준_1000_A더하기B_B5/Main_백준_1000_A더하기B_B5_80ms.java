package 백준.백준_1000_1999.백준_1000_A더하기B_B5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_1000_A더하기B_B5_80ms {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        System.out.println(Integer.parseInt(inputs[0]) + Integer.parseInt(inputs[1]));
        br.close();
    }

}