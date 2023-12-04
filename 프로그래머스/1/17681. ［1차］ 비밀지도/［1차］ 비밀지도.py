def solution(n, arr1, arr2):
    result = []

    for i in range(n):
        # 각 숫자를 2진수로 변환하고, n 비트로 맞춘다.
        bin1 = format(arr1[i], 'b').zfill(n)
        bin2 = format(arr2[i], 'b').zfill(n)

        # OR 연산 수행
        or_result = ''.join('#' if bin1[j] == '1' or bin2[j] == '1' else ' ' for j in range(n))
        result.append(or_result)

    return result