import java.util.*;

class Song {
    int idx, play;
    Song(int idx, int play) {
        this.idx = idx;
        this.play = play;
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> genreList = new HashMap<>(); // 장르별 총 재생 수
        Map<String, List<Song>> songList = new HashMap<>(); // 고유 번호별 재생 수
        
        // 장르별 총 재생 수를 저장
        // 고유 번호별 재생 수를 저장
        for(int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            // 장르별 총 재생 수 update
            genreList.put(genre, genreList.getOrDefault(genre, 0) + play);
            // 고유 번호별 재생 수 save
            songList.putIfAbsent(genre, new ArrayList<>());
            songList.get(genre).add(new Song(i, play));
        }
        
        // 장르별 총 재생 수 내림차순 정렬
        List<String> sortedGenre = new ArrayList<>(genreList.keySet());
        sortedGenre.sort((a, b) -> genreList.get(b).compareTo(genreList.get(a)));
        
        // 장르별 재생 수 내림차순(or idx 오름차순) 정렬, 최다 재생 곡 (상위 2개) answer에 저장
        for(String genre : sortedGenre) {
            List<Song> sortedPlay = new ArrayList<>(songList.get(genre));
            
            sortedPlay.sort((a, b) -> {
                if(b.play == a.play) {
                    return a.idx - b.idx;
                }
                return b.play - a.play;
            });
            
            for(int i = 0; i < Math.min(2, sortedPlay.size()); i++) {
                answer.add(sortedPlay.get(i).idx);
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}