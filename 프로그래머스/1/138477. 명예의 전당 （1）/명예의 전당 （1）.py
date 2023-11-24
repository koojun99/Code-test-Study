def solution(k, score):
    hall_of_fame = []
    announce = []
    for i in range(len(score)):
        hall_of_fame.append(score[i])
        if i >= k:
            hall_of_fame.remove(min(hall_of_fame))
        announce.append(min(hall_of_fame))
    return announce