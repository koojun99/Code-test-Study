def solution(n, stations, w):
    answer = 0
    last_covered = 0  # 마지막으로 커버된 위치
    range_width = 2 * w + 1  # 하나의 기지국이 커버할 수 있는 너비

    for station in stations:
        # 현재 기지국의 커버 시작 위치
        start_cover = station - w
        # 마지막으로 커버된 위치와 현재 기지국의 커버 시작 위치 사이의 거리
        # 이 거리만큼 추가로 기지국을 설치해야 함
        if start_cover > last_covered + 1:
            # 커버되지 않은 구간의 길이
            uncovered_length = start_cover - last_covered - 1
            # 커버되지 않은 구간에 필요한 추가 기지국 수
            answer += (uncovered_length + range_width - 1) // range_width
        # 마지막으로 커버된 위치 업데이트
        last_covered = station + w

    # 마지막 기지국 이후에 아직 커버되지 않은 아파트가 있는 경우
    if last_covered < n:
        uncovered_length = n - last_covered
        answer += (uncovered_length + range_width - 1) // range_width

    return answer