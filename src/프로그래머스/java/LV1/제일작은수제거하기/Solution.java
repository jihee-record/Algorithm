package 프로그래머스.java.LV1.제일작은수제거하기;

class Solution {
    public int[] solution(int[] arr) {
    	if(arr.length == 1) return new int[] {-1};
    	
    	int minIdx = 0;
        for (int i=1; i < arr.length; i++) {
            if (arr[i] < arr[minIdx]) minIdx = i;
        }

        int[] answer = new int[arr.length - 1];
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == minIdx) continue;
            answer[idx++] = arr[i];
        }

        return answer;
    }
}