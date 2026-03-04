package 프로그래머스.java.LV3.베스트앨범;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Solution {
	public static int[] solution(String[] genres, int[] plays) {
		HashMap<String, Integer> genresTotal = new HashMap<>();
		for(int i=0; i<genres.length; i++) {
			String genre = genres[i];
			genresTotal.put(genre, genresTotal.getOrDefault(genre, 0) + plays[i]);
		}
		
		//장르별 재생횟수 리스트
		ArrayList<Integer> gNum = new ArrayList<>();
		gNum.addAll(genresTotal.values());
		Collections.sort(gNum, Collections.reverseOrder());
		
		//장르별 재생횟수 순위리스트 (재생횟수 중복 없음)
		String[] genresName = new String[gNum.size()];
		for(String str : genresTotal.keySet()) {
			int num = genresTotal.get(str);
			int order = gNum.indexOf(num);
			genresName[order] = str;
		}
		
		ArrayList<Integer> answerList = new ArrayList<>();
		//list-index : 장르 순서 / map<재생횟수, 곡번호>
		for(int i=0; i<genresName.length; i++) {
			String str = genresName[i];
			HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
			
			for(int j=0; j<genres.length; j++) {
				if(genres[j].equals(str)) {
					int playCnt = plays[j];
					
					ArrayList<Integer> songN;
					if(map.containsKey(playCnt)){
						songN = map.get(playCnt);
					}else {
						songN = new ArrayList<>();
					}
					
					songN.add(j);
					map.put(playCnt, songN);
				}
			}
			
			ArrayList<Integer> playOrder = new ArrayList<>();
			playOrder.addAll(map.keySet());
			Collections.sort(playOrder, Collections.reverseOrder());
			
			int k=0;
			while(k<Math.min(2, playOrder.size())){
				ArrayList<Integer> songN = map.get(playOrder.get(k));
				if(k<1) {
					for(int l=0; l<Math.min(2, songN.size()); l++) {
						songN.get(l);
						answerList.add(songN.get(l));
						k++;
					}
				}else {
					answerList.add(songN.get(0));
					k++;
				}
			}
		}
		
		
		int[] answer = new int[answerList.size()];
		for(int i=0; i<answer.length; i++) {
			answer[i] = answerList.get(i);
		}
		
		return answer;
	}
	
}
