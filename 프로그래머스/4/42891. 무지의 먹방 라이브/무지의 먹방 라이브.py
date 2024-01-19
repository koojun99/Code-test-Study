import heapq
def solution(food_times, k):
        
    if sum(food_times) <= k:
        return -1
    
    pq = []
    for i, time in enumerate(food_times):
        heapq.heappush(pq, (time, i + 1))

    sum_value = 0
    previous = 0
    length = len(food_times)
    
    while sum_value + ((pq[0][0] - previous) * length) <= k:
        now = heapq.heappop(pq)[0]
        sum_value += (now - previous) * length
        length -= 1
        previous = now

    # 남은 음식 중에서 몇 번째 음식인지 확인
    result = sorted(pq, key=lambda x: x[1])
    return result[(k - sum_value) % length][1]
