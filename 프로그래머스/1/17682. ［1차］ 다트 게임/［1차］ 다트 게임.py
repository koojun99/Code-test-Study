def solution(dartResult):
    scores = []
    num = 0
    for i in range(len(dartResult)):
        if dartResult[i].isdigit():
            num = num * 10 + int(dartResult[i])
        elif dartResult[i] in ['S', 'D', 'T']:
            if dartResult[i] == 'D':
                num **= 2
            elif dartResult[i] == 'T':
                num **= 3
            scores.append(num)
            num = 0
        elif dartResult[i] == '*':
            if len(scores) > 1:
                scores[-2] *= 2
            scores[-1] *= 2
        elif dartResult[i] == '#':
            scores[-1] *= -1
    return sum(scores)