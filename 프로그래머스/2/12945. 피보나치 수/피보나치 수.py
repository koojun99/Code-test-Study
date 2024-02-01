def solution(n):
    fibo = [0, 1] # 피보나치 수열의 첫 번째와 두 번째 항 초기화
    for i in range(2, n+1):
        # n번째 피보나치 수를 계산하고 1234567로 나눈 나머지를 저장
        fibo.append((fibo[i-1] + fibo[i-2]) % 1234567)
    return fibo[n]
