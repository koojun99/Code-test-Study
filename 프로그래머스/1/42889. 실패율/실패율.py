def solution(N, stages):
    players_count = {i: 0 for i in range(1, N+1)}
    fail_rate = {}
    for stage in stages:
        if stage > N:
            continue
        players_count[stage] += 1
    total_players = len(stages)
    
    for i in range(1, N+1):
        if total_players == 0:  # 스테이지에 도달한 플레이어가 없는 경우
            fail_rate[i] = 0
        else:
            fail_rate[i] = players_count[i] / total_players
            total_players -= players_count[i]
    sorted_stages = sorted(fail_rate, key=lambda x: fail_rate[x], reverse=True)
    return sorted_stages