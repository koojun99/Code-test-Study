def solution(food):
    result = []
    for i in range(1, len(food)):
        for j in range(food[i]//2):
            result.append(str(i))
    result.append("0")
    for i in range(len(food) - 1, 0, -1):
        for j in range(food[i]//2):
            result.append(str(i))
    return "".join(result)