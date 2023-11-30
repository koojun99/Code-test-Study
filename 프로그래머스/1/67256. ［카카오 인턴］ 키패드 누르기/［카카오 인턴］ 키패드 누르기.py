def solution(numbers, hand):
    # 키패드 위치 설정
    key_dict = {1: (0, 0), 2: (0, 1), 3: (0, 2),
                4: (1, 0), 5: (1, 1), 6: (1, 2),
                7: (2, 0), 8: (2, 1), 9: (2, 2),
                '*': (3, 0), 0: (3, 1), '#': (3, 2)}

    left_hand = '*'
    right_hand = '#'
    answer = ''

    for num in numbers:
        if num in [1, 4, 7]:
            answer += 'L'
            left_hand = num
        elif num in [3, 6, 9]:
            answer += 'R'
            right_hand = num
        else:
            left_dist = sum(abs(a - b) for a, b in zip(key_dict[left_hand], key_dict[num]))
            right_dist = sum(abs(a - b) for a, b in zip(key_dict[right_hand], key_dict[num]))

            if left_dist < right_dist:
                answer += 'L'
                left_hand = num
            elif right_dist < left_dist:
                answer += 'R'
                right_hand = num
            else:  # 거리가 같은 경우
                if hand == 'right':
                    answer += 'R'
                    right_hand = num
                else:
                    answer += 'L'
                    left_hand = num

    return answer