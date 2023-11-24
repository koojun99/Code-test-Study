def solution(k, m, score):
    total = 0
    score.sort(reverse=True)
    for i in range(0, len(score), m):
        if (i+m) <= len(score):
            box = score[i:i+m]
            total += min(box)*m
        else:
            continue
            
    return total