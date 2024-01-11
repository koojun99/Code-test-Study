import heapq

def solution(n, works):
    # 최대 힙 생성
    max_heap = [-work for work in works]
    heapq.heapify(max_heap)

    # N시간 동안 작업 처리
    for _ in range(n):
        if max_heap:
            max_work = heapq.heappop(max_heap)  # 가장 큰 작업량 추출
            if max_work < 0:  # 작업량이 남아있다면
                max_work += 1  # 작업량 감소
                heapq.heappush(max_heap, max_work)  # 다시 힙에 추가

    # 남은 작업량의 제곱의 합 계산
    return sum(work**2 for work in max_heap)
