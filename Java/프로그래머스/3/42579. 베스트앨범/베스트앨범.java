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
        Map<String, Integer> genreCount = new HashMap<>();
        Map<String, List<Song>> playList = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        
        for(int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            genreCount.compute(genre, (a, b) -> b == null ? play : b + play);
            playList.putIfAbsent(genre, new ArrayList<>());
            playList.get(genre).add(new Song(i, play));
        }
        
        List<String> sortedGenre = new ArrayList<>(genreCount.keySet());
        sortedGenre.sort((a, b) -> genreCount.get(b) - genreCount.get(a));
        
        for(String genre : sortedGenre) {
            List<Song> songList = playList.get(genre);
            songList.sort((a, b) -> {
                if(a.play == b.play) {
                    return a.idx - b.idx;
                }
                return b.play - a.play;
            });
            
            for(int i = 0; i < Math.min(2, songList.size()); i++) {
                answer.add(songList.get(i).idx);
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}