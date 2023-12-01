def solution(n, lost, reserve):
    lost_set = set(lost) - set(reserve)
    reserve_set = set(reserve) - set(lost)
    total = n - len(lost_set)

    for student in reserve_set:
        if student - 1 in lost_set:
            lost_set.remove(student - 1)
            total += 1
        elif student + 1 in lost_set:
            lost_set.remove(student + 1)
            total += 1

    return total