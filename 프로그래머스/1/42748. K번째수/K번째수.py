def solution(array, commands):
    answer = []
    for command in commands:
        start,end,place = command
        sliced = array[start-1:end]
        sliced.sort()
        answer.append(sliced[place-1])
    return answer