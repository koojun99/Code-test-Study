def solution(d, budget):
    d.sort()
    count = 0

    for cost in d:
        if budget - cost < 0:
            break
        budget -= cost
        count += 1

    return count
  