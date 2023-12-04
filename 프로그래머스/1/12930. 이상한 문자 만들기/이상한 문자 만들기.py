def solution(s):
    return ' '.join(''.join(char.upper() if i % 2 == 0 else char.lower() for i, char in enumerate(word)) for word in s.split(' '))