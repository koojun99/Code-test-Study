def solution(num):
    count = 0
    while num != 1:
        if count == 500:
            return -1
        if num % 2 == 0:
            num = num / 2
        else:
            num = 3 * num + 1
        count += 1
    return count