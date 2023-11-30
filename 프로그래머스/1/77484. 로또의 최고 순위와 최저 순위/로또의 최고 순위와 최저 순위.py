def solution(lottos, win_nums):
    zero_count = lottos.count(0)
    match_count = len(set(lottos) & set(win_nums))
    
    highest_rank = 7 - match_count - zero_count
    lowest_rank = 7 - match_count
    highest_rank = 6 if highest_rank > 6 else highest_rank
    lowest_rank = 6 if lowest_rank > 6 else lowest_rank

    return [highest_rank, lowest_rank]