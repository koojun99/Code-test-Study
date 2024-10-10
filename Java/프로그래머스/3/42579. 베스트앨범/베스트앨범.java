import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genrePlayCount = new HashMap<>();  // 장르별 총 재생 횟수
        Map<String, List<int[]>> genreToSongs = new HashMap<>(); // 장르별 노래 리스트

        // 1. 장르별 총 재생 횟수와 노래 리스트 저장
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int playCount = plays[i];
            int index = i;
            
            // 장르별 총 재생 횟수 저장
            genrePlayCount.put(genre, genrePlayCount.getOrDefault(genre, 0) + playCount);

            // 장르별 노래 리스트 저장
            genreToSongs.putIfAbsent(genre, new ArrayList<>());
            genreToSongs.get(genre).add(new int[] {index, playCount});
        }

        // 2. 장르별 총 재생 횟수 내림차순으로 정렬
        List<String> sortedGenres = new ArrayList<>(genrePlayCount.keySet());
        sortedGenres.sort((g1, g2) -> genrePlayCount.get(g2) - genrePlayCount.get(g1));

        // 3. 베스트 앨범 수록을 위한 결과 리스트
        List<Integer> bestAlbum = new ArrayList<>();

        // 4. 장르별로 노래 정렬 후, 최대 2곡 추가
        for (String genre : sortedGenres) {
            List<int[]> songs = genreToSongs.get(genre);
            // 재생 횟수 내림차순, 고유 번호 오름차순으로 정렬
            songs.sort((s1, s2) -> s2[1] == s1[1] ? s1[0] - s2[0] : s2[1] - s1[1]);
            
            // 최대 2곡 추가
            for (int i = 0; i < Math.min(2, songs.size()); i++) {
                bestAlbum.add(songs.get(i)[0]);
            }
        }

        // 5. 결과를 배열로 변환하여 반환
        return bestAlbum.stream().mapToInt(i -> i).toArray();
    }
}