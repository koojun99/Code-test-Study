def solution(s):
    answer = ''
    s = list(s)
    s.sort(reverse=True)
    for i in range(len(s)):
        answer += s[i]
    
    return answer