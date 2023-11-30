def solution(absolutes, signs):
    total = 0
    for i in range(len(signs)):
        if signs[i]:
            total += absolutes[i]
        else:
            total -= absolutes[i]
    return total