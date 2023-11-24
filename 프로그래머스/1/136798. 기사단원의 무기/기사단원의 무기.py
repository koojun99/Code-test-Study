import math
def solution(number, limit, power):
    total = 0 
    for i in range(1, number+1):
        num = 0
        sqrt_i = int(math.sqrt(i))
        for j in range(1, sqrt_i+1):
            if i % j == 0:
                num += 2 if j != i // j else 1
        if num > limit:
            total += power
        else:
            total += num
    
    return total