def solution(arr):
    answer = []
    for i in range(len(arr)):
        if not(i > 0 and arr[i] == arr[i-1]):
            answer.append(arr[i])
    return answer