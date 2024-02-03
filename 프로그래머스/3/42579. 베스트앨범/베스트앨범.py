def solution(genres, plays):
    genre_play_dict = {}
    song_play_list = {}
    
    # 장르별 총 재생 횟수와 노래별 재생 횟수를 저장
    for i, (genre, play) in enumerate(zip(genres, plays)):
        if genre not in genre_play_dict:
            genre_play_dict[genre] = play
            song_play_list[genre] = [(play, i)]
        else:
            genre_play_dict[genre] += play
            song_play_list[genre].append((play, i))
    
    # 장르별 총 재생 횟수에 따라 장르 정렬
    sorted_genres = sorted(genre_play_dict.items(), key=lambda x: x[1], reverse=True)
    
    result = []
    for genre, _ in sorted_genres:
        # 각 장르 내에서 노래를 재생 횟수에 따라 정렬 (재생 횟수가 같으면 고유 번호가 낮은 순으로 정렬)
        sorted_songs = sorted(song_play_list[genre], key=lambda x: (-x[0], x[1]))
        # 각 장르에서 상위 2개의 노래 선택
        result.extend([song_id for _, song_id in sorted_songs[:2]])
    
    return result