def solution(x):
    digit_sum = 0
    y = x
    while y > 0:
        digit_sum += y % 10
        y //= 10
    if x % digit_sum == 0:
        return True
    else:
        return False