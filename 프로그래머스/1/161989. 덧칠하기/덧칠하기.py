def solution(n, m, section):
    paint_count = 0
    i = 0
    while i < len(section):
        # 롤러로 칠할 수 있는 마지막 구역의 위치 계산
        end = section[i] + m - 1

        # 롤러로 칠할 수 있는 범위 내에서 다음 구역 찾기
        while i < len(section) and section[i] <= end:
            i += 1

        # 롤러 한 번 사용
        paint_count += 1
          
    return paint_count