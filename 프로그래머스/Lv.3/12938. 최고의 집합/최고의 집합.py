def solution(n, s):
    answer = []
    if n > s:
        return [-1]
    
    answer = [s // n for _ in range(n)]
    remainder = s % n

    for i in range(remainder):
        answer[i] += 1

    answer.sort()
    return answer