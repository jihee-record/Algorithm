package 백준.백준_28000_28999.백준_28278_스택2_S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main_백준_28278_스택2_S4_4448ms {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> stack = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++) {
            String[] input = br.readLine().split(" ");
            switch(input[0]) {
                case "1":
                    stack.add((Integer.parseInt(input[1])));
                    break;
                case "2":
                    if(stack.size() > 0){
                        int x = stack.get(stack.size()-1);
                        stack.remove(stack.size()-1);
                        System.out.println(x);
                    }else{
                        System.out.println(-1);
                    }
                    break;
                case "3":
                    System.out.println(stack.size());
                    break;
                case "4":
                    if(stack.size() == 0){
                        System.out.println(1);
                    }else{
                        System.out.println(0);
                    }
                    break;
                case "5":
                    if(stack.size() == 0){
                        System.out.println(-1);
                    }else{
                        System.out.println(stack.get(stack.size()-1));
                    }
                    break;
            }
        }
    }
}
