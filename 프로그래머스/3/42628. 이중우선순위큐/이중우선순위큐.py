def solution(operations):
    queue = []
    answer = []
    for operation in operations:
        if operation[0] == "I":
            queue.append(int(operation[2:]))
        elif operation[0] == "D":
            if len(queue) == 0:
                continue
            if operation[2:] == "1":
                queue.remove(max(queue))
            elif operation[2:] == "-1":
                queue.remove(min(queue))
    if len(queue) == 0:
        return [0,0]
    else:
        answer.append(max(queue))
        answer.append(min(queue))
    return answer