def solution(park, routes):
    H, W = len(park), len(park[0])
    for i in range(H):
        for j in range(W):
            if park[i][j] == 'S':
                h, w = i, j
                break
                
    direction = {'N' : (-1, 0), 'S' : (1, 0), 'W' : (0, -1), 'E' : (0, 1)}
    
    for route in routes:
        way, d = route.split()
        dh, dw = direction[way]
        is_reachable = True
        nh, nw = h, w
        for _ in range(int(d)):
            nh += dh
            nw += dw
            if not (0<=nh<H and 0<=nw<W) or park[nh][nw] == 'X':
                is_reachable = False
                break
        if is_reachable:
            h, w = nh, nw
        
    return [h, w]