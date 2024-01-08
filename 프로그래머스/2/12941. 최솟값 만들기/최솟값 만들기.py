def solution(A,B):
    sum = 0
    A.sort()  # 오름차순 정렬
    B.sort(reverse=True)  # 내림차순 정렬

    for i in range(len(A)):
        sum += A[i] * B[i]  # 정렬된 순서대로 최솟값과 최댓값을 곱함

    return sum