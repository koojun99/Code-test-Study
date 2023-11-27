def solution(ingredient):
    correct_sequence = [1, 2, 3, 1]
    count = 0

    i = 0
    while i <= len(ingredient) - len(correct_sequence):
        if ingredient[i:i + len(correct_sequence)] == correct_sequence:
            count += 1
            del ingredient[i:i + len(correct_sequence)]
            # 제거된 시퀀스에 따라 인덱스 조정 없이 계속 진행
            i = max(0, i - len(correct_sequence) + 1)
        else:
            i += 1  # 일치하지 않으면 인덱스 증가

    return count